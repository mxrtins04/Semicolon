package service;

import model.*;
import repository.*;
import dto.request.TransferRequest;
import dto.response.TransactionResponse;
import util.generator.ReferenceGenerator;
import util.mapper.TransactionMapper;
import util.validation.TransactionValidator;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    private TransactionRepo transactionRepository;
    private AccountRepo accountRepository;
    private BankRepo bankRepository;

    public TransactionService(TransactionRepo transactionRepository,
                              AccountRepo accountRepository,
                              BankRepo bankRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    public TransactionResponse transfer(TransferRequest request) {

        List<String> errors = TransactionValidator.validate(request);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + String.join(", ", errors));
        }

        Account sourceAccount = accountRepository.findByAccountNumber(request.getSourceAccountNumber())
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        BigDecimal totalDebit = request.getAmount();
        if (sourceAccount.getBalance().compareTo(totalDebit) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        boolean isInterBank = !sourceAccount.getBankCode().equals(request.getDestinationBankCode());

        Bank destinationBank = bankRepository.findByBankCode(request.getDestinationBankCode())
                .orElseThrow(() -> new RuntimeException("Destination bank not found"));

        if (isInterBank) {
            Account destAccount = accountRepository.findByAccountNumber(request.getDestinationAccountNumber())
                    .orElse(null);

            if (destAccount == null) {
                throw new RuntimeException("Destination account not found");
            }

            if (!destAccount.getBankCode().equals(request.getDestinationBankCode())) {
                throw new RuntimeException("Account number does not match destination bank");
            }
        } else {
            Account destAccount = accountRepository.findByAccountNumber(request.getDestinationAccountNumber())
                    .orElseThrow(() -> new RuntimeException("Destination account not found"));

        }

        String reference = ReferenceGenerator.generateTransactionReference();

        Transaction transaction = new Transaction();
        transaction.setReferenceNumber(reference);
        transaction.setSourceAccountNumber(request.getSourceAccountNumber());
        transaction.setSourceBankCode(sourceAccount.getBankCode());
        transaction.setDestinationAccountNumber(request.getDestinationAccountNumber());
        transaction.setDestinationBankCode(request.getDestinationBankCode());
        transaction.setAmount(request.getAmount());
        transaction.setType(TransactionType.TRANSFER_OUT);
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setNarration(request.getNarration());

        Transaction savedTransaction = transactionRepository.save(transaction);

        try {
            sourceAccount.debit(totalDebit);
            accountRepository.update(sourceAccount);

            Account destAccount = accountRepository.findByAccountNumber(request.getDestinationAccountNumber()).get();
            destAccount.credit(request.getAmount());
            accountRepository.update(destAccount);

            Transaction creditTransaction = new Transaction();
            creditTransaction.setReferenceNumber(reference + "-CR");
            creditTransaction.setSourceAccountNumber(request.getSourceAccountNumber());
            creditTransaction.setSourceBankCode(sourceAccount.getBankCode());
            creditTransaction.setDestinationAccountNumber(request.getDestinationAccountNumber());
            creditTransaction.setDestinationBankCode(request.getDestinationBankCode());
            creditTransaction.setAmount(request.getAmount());
            creditTransaction.setType(TransactionType.TRANSFER_IN);
            creditTransaction.setStatus(TransactionStatus.COMPLETED);
            creditTransaction.setNarration(request.getNarration());
            transactionRepository.save(creditTransaction);

            savedTransaction.setStatus(TransactionStatus.COMPLETED);


        } catch (Exception e) {
            savedTransaction.setStatus(TransactionStatus.FAILED);
            throw new RuntimeException("Transfer failed: " + e.getMessage());
        }

        return TransactionMapper.toResponse(savedTransaction, destinationBank);
    }

    public List<TransactionResponse> getAccountTransactions(String accountNumber) {
        List<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber);

        return transactions.stream()
                .map(txn -> {
                    Bank bank = bankRepository.findByBankCode(txn.getDestinationBankCode()).orElse(null);
                    return TransactionMapper.toResponse(txn, bank);
                })
                .collect(Collectors.toList());
    }

    public TransactionResponse getTransaction(String reference) {
        Transaction transaction = transactionRepository.findByReference(reference)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Bank bank = bankRepository.findByBankCode(transaction.getDestinationBankCode()).orElse(null);
        return;
    }
}
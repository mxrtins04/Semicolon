package com.app.service;

import com.app.entity.Lead;
import com.app.exception.LeadNotFoundException;
import com.app.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final ScoringService scoringService;

    public LeadServiceImpl(LeadRepository leadRepository, ScoringService scoringService) {
        this.leadRepository = leadRepository;
        this.scoringService = scoringService;
    }

    @Override
    @Transactional
    public Lead createLead(Lead lead) {
        log.info("Creating new lead: {}", lead.getName());
        scoringService.scoreLead(lead);
        Lead saved = leadRepository.save(lead);
        log.info("Lead created with id: {}", saved.getId());
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public Lead updateLead(Long id, Lead leadData) {
        log.info("Updating lead with id: {}", id);
        Lead lead = getLeadById(id);

        lead.setName(leadData.getName());
        lead.setEmail(leadData.getEmail());
        lead.setPhone(leadData.getPhone());
        lead.setCompany(leadData.getCompany());
        lead.setAnnualVolume(leadData.getAnnualVolume());
        lead.setTradingExperience(leadData.getTradingExperience());

        scoringService.scoreLead(lead);
        Lead updated = leadRepository.save(lead);
        log.info("Lead updated: {}", id);
        return updated;
    }

    @Override
    @Transactional(readOnly = true)
    public Lead getLeadById(Long id) {
        log.debug("Fetching lead with id: {}", id);
        return leadRepository.findById(id)
                .orElseThrow(() -> new LeadNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> getAllLeads() {
        log.debug("Fetching all leads");
        return leadRepository.findAllOrderedByScore();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> getLeadsByMinimumScore(Integer minScore) {
        log.debug("Fetching leads with minimum score: {}", minScore);
        return leadRepository.findByMinimumScore(minScore);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lead> getLeadsByCompany(String company) {
        log.debug("Fetching leads by company: {}", company);
        return leadRepository.findByCompany(company);
    }

    @Override
    @Transactional
    public void deleteLead(Long id) {
        log.info("Deleting lead with id: {}", id);
        getLeadById(id);
        leadRepository.deleteById(id);
        log.info("Lead deleted: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getTotalLeadsCount() {
        return (int) leadRepository.count();
    }
}

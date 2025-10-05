public int getFutureInvestment(int investmentAmount, float monthlyInterestRate, int years){
	float numberOfMonths = years / 12;
	
	float futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate) ** numberOfMonths;
	
	return futureInvestmentValue;

}


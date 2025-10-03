def future_investment(investment_amount, monthly_interest_rate, years):
	months = years / 12
	return investment_amount * (1 + monthly_interest_rate)**months


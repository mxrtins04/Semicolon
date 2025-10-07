def get_future_investment(investment_amount, monthly_interest_rate, years)
	number_0f_months = years / 12
	
	future_investment_value = investment_amount * (1 + monthly_interest_rate) ** number_of_months
	
	return future_investment_value

}


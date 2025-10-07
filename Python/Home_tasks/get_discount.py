get_discount(price, discount)
	
	percentage = discount / 100
	reducedPrice = percentage * price
	discountedPrice = price - reducedPrice

	return discountedPrice

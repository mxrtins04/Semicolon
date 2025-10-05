public int getDiscount(int price, int discount){
	
	double percentage = discount / 100;
	double reducedPrice = percentage * price;
	double discountedPrice = price - reducedPrice;

	return(discountedPrice);

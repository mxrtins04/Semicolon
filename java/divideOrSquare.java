public int divideOrSquare(int number){
	if(number % 5 == 0)
		System.out.print(math.sqrt(number));
	else
		System.out.print((number % 5));
}

divideOrSquare(10);
 public void onlyFloat(float a, float b){
	double a = 10.11;
	double b = 4;
	int wholeNumberA = a / 1;
	int wholeNumberB = b / 1;

	if( (a != wholeNumberA) && (b != wholeNumberB)){
		System.out.print("2");}

	else if( (a != wholeNumberA) || (b != wholeNumberB)){
		System.out.print("1");}
	
	else if( (a == wholeNumberA) && (b == wholeNumberB)){
		System.out.print("0");}

}
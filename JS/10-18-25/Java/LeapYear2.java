public class LeapYear2{
public static void main(String [] args){
	int count = 0;
	for( int year = 1900; year <= 2025; year++ ){
	if( year % 100 == 0 ){
		if( year % 400 == 0)					
			count++;
				}
	if( year % 4 == 0 && year % 100 != 0 )
		count++;
		
	}

	System.out.println(count);
	

			
}}
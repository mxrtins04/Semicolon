public class LeapYear{
public static void main(String [] args){
	
	for( int year = 1900; year <= 2025; year++ ){
	if( year % 100 == 0 ){
		if( year % 400 == 0)								System.out.println(year);
	}
	if( year % 4 == 0 && year % 100 != 0 )
		System.out.println(year);
	}


	

			
}}
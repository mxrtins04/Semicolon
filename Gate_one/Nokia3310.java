import java.util.Scanner;

public class Nokia3310{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	String phoneFunctions = """
		1 -> Phone book
		2 -> Messages
		3 -> Chat
		4 -> Call register
		5 -> Tones
		6 -> Settings
		7 -> Call divert.
		8 -> Games.
		9 -> Calculator
		10 -> Reminders
		11 -> Clock.
		12 -> Profiles.
		13 -> Sim services.

		""";
	System.out.print(phoneFunctions);
	int mainMenuFunctions = input.nextInt();
	
	switch(mainMenuFunctions){
		case 1 -> {String phoneBook = """
		1 -> Search.
		2 -> Service Nos.
		3 -> Add Name.
		4 -> Erase.
		5 -> Edit.
		6 -> Assign tone.
		7 -> Send b'card.
		8 -> Options
		9 -> Speed dials
		10 -> Voice tags
		""";
	System.out.print(phoneBook);
	int phoneBookFunctions = input.nextInt();
	
		switch(phoneBookFunctions){
			case 8 -> {String options = """
			1 -> Type of view.
			2 -> Memory Status. """;	
		
			System.out.print(options); }
}

		
	}
			
		case 2 -> {
	String Messages = """
		1 -> Write messages
		2 -> Inbox
		3 -> Outbox
		4 -> Picture messages
		5 -> Templates
		6 -> Smileys
		7 -> Message Settings
		8 -> Info service
		9 -> Voice mailbox number
		10 -> Service command editor
		""";
	System.out.print(Messages);
	int messagesFunctions = input.nextInt();
	
		switch(messagesFunctions){
			case 7 -> {
		String messageSettings = """
			1 -> Set 1
			2 -> Common
			""";
		System.out.print(messageSettings);
		int messageSettingsFunctions = input.nextInt();
		
			switch(messageSettingsFunctions){
				case 1 -> {
				String set1 = """
			1 -> Message centre numner
			2 -> Messages sent as
			3 -> Message validity
			""";
		System.out.print(set1);}

				case 2 -> {
				String common = """
			1 -> Delivery reports
			2 -> Reply via same centre
			3 -> Character support
			
			""";
		System.out.print(common);}
				}
				}}
		
	}
			
		
		case 4 -> {
	String callRegister = """
			1 -> Missed calls
			2 -> Received calls
			3 -> Dialled numbers
			4 -> Erace recent call lists
			5 -> Show call duration
			6 -> Show call costs
			7 -> Call cost settings
			8 -> Prepaid credit
				""";
	System.out.print(callRegister);
	int callRegisterFunction = input.nextInt();
			
		switch(callRegisterFunction){
			case 5 -> {
		String showCallDuration = """
			1 -> Last call duration
			2 -> All calls' duration
			3 -> Received call's duration
			4 -> Dialled calls' duration
			5 -> clear timers
			""";
		
		System.out.print(showCallDuration);}

			case 6 -> {
		String showCallCost = """
			1 -> Last call cost
			2 -> All call's cost
			3 -> Clear counters 
			""";
		System.out.print(showCallCost);}

		
			case 7 -> {
		String callCostSettings = """
			1 -> Call cost limit
			2 -> Show costs in
			""";
		System.out.print(callCostSettings);}
				}}

		case 5 -> {
	String tones = """
		1 -> Ringing tone
		2 -> Ringing volume
		3 -> Incoming call alert
		4 -> Composer
		5 -> Message alert tones
		6 -> Keypad tones
		7 -> Warning and games tones
		8 -> Vibrating alert
		9 -> Screen saver
		""";
		
		System.out.print(tones);}
	
		case 6 -> {
			
		String settings = """
			1 -> Call settings
			2 -> Phone settings
			3 -> Security settings
			4 -> Restore factory settings
			""";
			System.out.print(settings);
			int settingsFunctions = input.nextInt();

			switch(settingsFunctions){
				case 1 -> {
			String callSettings = """
				1 -> Automatic redial
				2 -> Speed dialling
				3 -> Call waiting options
				4 -> Own number sending 
				5 -> Phone line in use
				6 -> Automatic answer
				""";
				System.out.print(callSettings);}
				
				case 2 ->{
			String phoneSettings = """
				1 -> Language
				2 -> Cell info display
				3 -> Welcome note
				4 -> Network selection
				5 -> Lights
				6 -> Confirm SIM service actions
				""";
				System.out.print(phoneSettings);}
		
				case 3 -> {
			String securitySettings = """
				1 -> PIN code request
				2 -> Call barring service
				3 -> Fixed dialling
				4 -> Closed user group
				5 -> Phone security 
				6 -> Change access codes
				""";
			System.out.print(securitySettings);}

}}


		case 11 -> {
		String clock = """
			1 -> Alarm clock;
			2 -> Clock settings
			3 -> Date settings
			4 -> Stopwatch
			5 -> Countdown timer
			6 -> Auto update of date and time
			""";
		System.out.print(clock);}

}


}
}
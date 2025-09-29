import java.util.Scanner;

public class Nokia3310V2{
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
		11 -> Back
		""";
	System.out.print(phoneBook);
	int phoneBookFunctions = input.nextInt();
	
		if( phoneBookFunctions == 11){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}
	
		switch(phoneBookFunctions){
			case 8 -> {String options = """
			1 -> Type of view
			2 -> Memory Status
			3 -> Back 
			""";	
		
			System.out.print(options);
			int optionsFunctions = input.nextInt();

			if( optionsFunctions == 3){

			BackKey back  = new BackKey();
			
			back.getBackToPhoneBook();}
			 }
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
		11 -> Back

		""";
	System.out.print(Messages);
	int messagesFunctions = input.nextInt();

	
		if( messagesFunctions == 11){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}

	
		switch(messagesFunctions){
			case 7 -> {
		String messageSettings = """
			1 -> Set 1
			2 -> Common
			3 -> Back
			""";
		System.out.print(messageSettings);
		int messageSettingsFunctions = input.nextInt();

		
		if( messageSettingsFunctions == 3){
			BackKey back = new BackKey();
			
			back.getBackToMessages();}

		
			switch(messageSettingsFunctions){
				case 1 -> {
				String set1 = """
			1 -> Message centre numner
			2 -> Messages sent as
			3 -> Message validity
			4 -> Back
			""";
		System.out.print(set1);
		int set1Function = input.nextInt();

		if( set1Function == 4){
			BackKey back = new BackKey();
			back.getBackToMessageSettings();}}

				case 2 -> {
				String common = """
			1 -> Delivery reports
			2 -> Reply via same centre
			3 -> Character support
			4 -> Back
			
			""";
		System.out.print(common);
		int commonFunction = input.nextInt();
		
		if( commonFunction == 4 ){
			BackKey back = new BackKey();
			back.getBackToMessageSettings();}}
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
			9 -> Back
				""";
	System.out.print(callRegister);
	int callRegisterFunction = input.nextInt();
	
	
		if( callRegisterFunction == 9){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}
		
		switch(callRegisterFunction){
			case 5 -> {
		String showCallDuration = """
			1 -> Last call duration
			2 -> All calls' duration
			3 -> Received call's duration
			4 -> Dialled calls' duration
			5 -> Clear timers
			6 -> Back
			""";
		
		System.out.print(showCallDuration);
		int showCallDurationFunction = input.nextInt();
		
		if( showCallDurationFunction == 6){
			BackKey back = new BackKey();
			
			back.getBackToCallRegister();}
}

			case 6 -> {
		String showCallCost = """
			1 -> Last call cost
			2 -> All call's cost
			3 -> Clear counters 
			4 -> Back
			""";
		System.out.print(showCallCost);
		int showCallCostFunction = input.nextInt();
	
		if( showCallCostFunction == 4 ){
			BackKey back = new BackKey();
			back.getBackToCallRegister();}
}

		
			case 7 -> {
		String callCostSettings = """
			1 -> Call cost limit
			2 -> Show costs in
			3 -> Back
			""";
		System.out.print(callCostSettings);
		int callCostSettingFunction = input.nextInt();

		if( callCostSettingFunction == 3 ){
			BackKey back = new BackKey();
			back.getBackToCallRegister();}

		}
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
		10 -> Back
		""";
		
		System.out.print(tones);
		int tonesFunction = input.nextInt();
		
		if( tonesFunction == 10){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}

		
		}
	
		case 6 -> {
			
		String settings = """
			1 -> Call settings
			2 -> Phone settings
			3 -> Security settings
			4 -> Restore factory settings
			5 -> Back
			""";
			System.out.print(settings);
			int settingsFunctions = input.nextInt();
			
			
			if( settingsFunctions == 5){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}

			switch(settingsFunctions){
				case 1 -> {
			String callSettings = """
				1 -> Automatic redial
				2 -> Speed dialling
				3 -> Call waiting options
				4 -> Own number sending 
				5 -> Phone line in use
				6 -> Automatic answer
				7 -> Back
				""";
				System.out.print(callSettings);
				int callSettingsFunction = input.nextInt();
	
				if( callSettingsFunction == 7){
					BackKey back = new BackKey();
					back.getBackToSettings();}
}
				
				case 2 ->{
			String phoneSettings = """
				1 -> Language
				2 -> Cell info display
				3 -> Welcome note
				4 -> Network selection
				5 -> Lights
				6 -> Confirm SIM service actions
				7 -> Back
				""";
				System.out.print(phoneSettings);
				int phoneSettingsFunction = input.nextInt();

				if( phoneSettingsFunction == 7){
					BackKey back = new BackKey();
					back.getBackToSettings();}
}
		
				case 3 -> {
			String securitySettings = """
				1 -> PIN code request
				2 -> Call barring service
				3 -> Fixed dialling
				4 -> Closed user group
				5 -> Phone security 
				6 -> Change access codes
				7 -> Back
				""";
			System.out.print(securitySettings);
			int securitySettingsFunction = input.nextInt();
			
			if( securitySettingsFunction == 7){
					BackKey back = new BackKey();
					back.getBackToSettings();}}

}}


		case 11 -> {
		String clock = """
			1 -> Alarm clock;
			2 -> Clock settings
			3 -> Date settings
			4 -> Stopwatch
			5 -> Countdown timer
			6 -> Auto update of date and time
			7 -> Back
			""";
		System.out.print(clock);
		int clockFunction = input.nextInt();
		
		if( clockFunction == 7){
			BackKey back = new BackKey();
			
			back.getBackToMainMenu();}
}

}


}
}
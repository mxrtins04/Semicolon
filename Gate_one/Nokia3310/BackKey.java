import java.util.Scanner;

public class BackKey {
	static Scanner input = new Scanner(System.in);

	public void getBackToMainMenu() {
		System.out.println("""
				MAIN MENU
				1 -> Phone book
				2 -> Messages
				3 -> Chat
				4 -> Call register
				5 -> Tones
				6 -> Settings
				7 -> Call divert
				8 -> Games
				9 -> Calculator
				10 -> Reminders
				11 -> Clock
				12 -> Profiles
				13 -> Sim services
				""");
		String menuOption = input.nextLine();

		switch (menuOption) {
			case "1" -> getBackToPhoneBook();
			case "2" -> getBackToMessages();
			case "3" -> {
				String chat = """
					CHAT
				1 -> Back""";
				System.out.print(chat);
				String chatFunctions = input.nextLine();
				if (chatFunctions.equals("1") ){getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToChat();} 
			}
				
			case "4" -> getBackToCallRegister();
			case "5" -> getBackToTones();
			case "6" -> getBackToSettings();
			case "7" -> {
				System.out.print(""" 
					CALL DIVERT
				1 -> Back""");
				String callDivert = input.nextLine();
				if (callDivert.equals(1) ){
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToCallDivert();}
			}
			case "8" -> {
				String games = """
					GAMES
				1 -> Back""";
				System.out.print(games);
				String gamesFunction = input.nextLine();
				if (gamesFunction.equals(1) ){
					 getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToGames();}
			}
			case "9" -> {
				String calculator = """
					CALCULATOR
				1 -> Back""";
				
				System.out.print(calculator);
				String calculatorFunction = input.nextLine();
				
				if (calculatorFunction.equals(1)){ 
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToCalculator();}

			}
			case "10" -> {
				String reminders = """
					REMINDERS
				1 -> Back""";
				
				System.out.print(reminders);
				String remindersFunction = input.nextLine();
				
				if (remindersFunction.equals(1) ) {
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToReminders();}
			}
			case "11" -> getBackToClock();
			case "12" -> getBackToProfiles();
			case "13" -> getBackToSimServices();
			default -> getBackToMainMenu();
		}
	}

	public void getBackToPhoneBook() {
		System.out.println("""
				PHONE BOOK
				1 -> Search
				2 -> Service Nos.
				3 -> Add name
				4 -> Erase
				5 -> Edit
				6 -> Assign tone
				7 -> Send b'card
				8 -> Options
				9 -> Speed dials
				10 -> Voice tags
				11 -> Back
				""");
		String phoneBookFunctions = input.nextLine();

		switch (phoneBookFunctions) {
			case "11" -> getBackToMainMenu();
			case "1" -> {
				String search = """
					SEARCH
				1 -> Back""";
				
				System.out.print(search);
				String searchFunction = input.nextLine();
				if (searchFunction.equals("1")){ 
					getBackToPhoneBook();}
				else{System.out.print("Put a valid number: ");
					getBackToSearch();}
			}
			case "2" -> {
				String serviceNo = """
					SERVICE NOS.
				1 -> Back""";

				System.out.print(serviceNo);
				String serviceNoFunction = input.nextLine();

				if (serviceNoFunction.equals("1")) {
					getBackToPhoneBook();}
				else{System.out.print("Put a valid number: ");
					getBackToServiceNo();}

			}
			case "3" -> {
				String addName = """
					ADD NAME
				1 -> Back""";

				System.out.print(addName);
				String addNameFunction = input.nextLine();

				if (addNameFunction.equals("1"))
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToAddName();}
			}
			case "4" -> {
				String erase =  """
					ERASE
				1 -> Back""";
	
				System.out.print(erase);
				String eraseFunction = input.nextLine();

				if (eraseFunction.equals("1"))
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToErase();}
			}
			case "5" -> {
				String edit = """
					EDIT
				1 -> Back""";

				System.out.print(edit);
				String editFunction = input.nextLine();

		
				if (editFunction.equals("1")) 
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToEdit();}

			}
			case "6" -> {
				String assignTone = """
					ASSIGN TONE
				1 -> Back""";

				System.out.print(assignTone);
				String assignToneFunction = input.nextLine();

				if (assignToneFunction.equals("1")) 							getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToAssignTone();}
			}
			case "7" -> {
				String sendBCard = """
					SEND B'CARD
				1 -> Back""";

				System.out.print(sendBCard);
				String sendBCardFunction = input.nextLine();

				if (sendBCardFunction.equals("1")) 							
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToBCard();}
			}
			case "8" -> getBackToOptions();
			case "9" -> {
				String speedDials = """
					SPEED DIALS
				1 -> Back""";

				System.out.print(speedDials);
				String speedDialsFunction = input.nextLine();

				if (speedDialsFunction.equals("1")) 							
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToSpeedDials();}
			}

			case "10" -> {
				String voiceTags = """
					VOICE TAGS
				1 -> Back""";

				System.out.print(voiceTags);
				String voiceTagsFunction = input.nextLine();

				if (voiceTagsFunction.equals("1")) 							
					getBackToPhoneBook();
				else{System.out.print("Input a valid number: ");
					getBackToVoiceTags();}
			
			}
			default -> {System.out.print("Input a number: ");
					getBackToPhoneBook();}
		}
}

	public void getBackToOptions() {
			String options = """
				OPTIONS
				1 -> Type of view
				2 -> Memory status
				3 -> Back
				""";

		System.out.print(options);
		String optionsFunctions = input.nextLine();

		switch (optionsFunctions) {
			case "3" -> getBackToPhoneBook();
			case "1" -> {
				String typeOfView ="""
				TYPE OF VIEW
			1 -> Back""";

				System.out.print(typeOfView);
			
				String typeOfViewFunction = input.nextLine();
				if (typeOfView.equals("1"))
					getBackToOptions();
				else{System.out.print("Input a number: ");
					getBackToTypeOfView();}

			}
			case "2" -> {
				String memoryStatus ="""
			MEMORY STATUS
			1 -> Back""";

				System.out.print(memoryStatus);
				String memoryStatusFunction = input.nextLine();
				if (memoryStatusFunction.equals("1")) 
					getBackToOptions();
				else{System.out.print("Input a number: ");
					getBackToMemoryStatus();}

			}
			default ->{System.out.print("Input a number: ");
					getBackToOptions();}
		}
	}








































	public void getBackToMessages() {
		System.out.println("""
				MESSAGES
				1 -> Write messages
				2 -> Inbox
				3 -> Outbox
				4 -> Picture messages
				5 -> Templates
				6 -> Smileys
				7 -> Message settings
				8 -> Info service
				9 -> Voice mailbox number
				10 -> Service command editor
				11 -> Back
				""");

		
		String messageFunctions = input.nextLine();

		switch (messageFunctions) {
			case "11" -> getBackToMainMenu();
			case "1" -> {
				String writeMessage = """
					WRITE MESSAGE
				1 -> Back""";

				System.out.print(writeMessage);
				String writeMessageFunction = input.nextLine();
				if (writeMessage.equals("1")) 
					getBackToMessages();
	
				else{
					System.out.print("Input a valid number: ");
					getBackToWriteMessage();	}
			}
			case "2" -> {
				String inbox = """
					INBOX
				1 -> Back""";

				System.out.print(inbox);
				String inboxFunction = input.nextLine();
				if (inboxFunction.equals("1")) 
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToInbox();	}

			}
			case "3" -> {
				System.out.println("""
					OUTBOX
				1 -> Back""");
				String outboxFunction = input.nextLine();
				if (outboxFunction.equals("1"))
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToOutbox();	}

			}
			case "4" -> {
				System.out.println("""
					PICTURE MESSAGES
				1 -> Back""");
	
				String pmFunctions = input.nextLine();
				if (pmFunctions.equals("1"))
					getBackToMessages();
				else{System.out.print("Input a valid number: ");
					getBackToPictureMessages();}
			}
			case "5" -> {
				System.out.println("""
					TEMPLATES
				1 -> Back""");
		
				String templatesFunction = input.nextLine();
				if (templatesFunction.equals("1")) 
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToTemplates();	}

			}
			case "6" -> {
				System.out.println("""
					SMILEYS
				1 -> Back""");

				String smileysFunction = input.nextLine();
				if (smileysFunction.equals("1"))
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToSmileys();	}

			}
			case "7" -> getBackToMsgSettings();
			case "8" -> {
				System.out.println("""
					INFO SERVICE
				1 -> Back""");
				
				String infoServiceFunction = input.nextLine();
	
				if (infoServiceFunction.equals("1"))
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToInfoServices();	}

			}
			case "9" -> {
				System.out.println("""
					VOICE MAILBOX NUMBER
				1 -> Back""");

				String voiceMailboxFunctions = input.nextLine();

				if (voiceMailboxFunctions.equals("1"))
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToVoiceMail();	}

			}
			case "10" -> {
				System.out.println("""
					SERVICE COMMAND EDITOR
				1-> Back""");
	
				String serviceCommandFunction = input.nextLine();

				if (serviceCommandFunction.equals("1"))
					getBackToMessages();

				else{
					System.out.print("Input a valid number: ");
					getBackToServiceCommand();	}

			}
			default -> {System.out.print("Input a valid number: ");
					getBackToMessages();}
		}
	}

	public void getBackToMsgSettings() {
		System.out.println("""
				MESSAGE SETTINGS
				1 -> Set 1
				2 -> Common
				3 -> Back
				""");
		String msgSettings = input.nextLine();

		switch (msgSettings) {
			case "3" -> getBackToMessages();
			case "1" -> {
				System.out.println("""
					SET 1
				1 -> Back""");

				String set1Function = input.nextLine();

				if (set1Function.equals("1"))
					getBackToMsgSettings();

				else{
					System.out.print("Input a valid number: ");
					getBackToSet1();	}

			}
			case "2" -> {
				System.out.println("""
					COMMON
				1 -> Back""");
				String commonFunction = input.nextLine();
				if (commonFunction.equals("1"))
					getBackToMsgSettings();
				else{
					System.out.print("Input a valid number: ");
					getBackToCommon();	}

			}
			default -> getBackToMsgSettings();
		}
	}

	public void getBackToCallRegister() {
		System.out.println("""
				CALL REGISTER
				1 -> Missed calls
				2 -> Received calls
				3 -> Dialled numbers
				4 -> Erase recent call lists
				5 -> Show call duration
				6 -> Show call costs
				7 -> Call cost settings
				8 -> Prepaid credit
				9 -> Back
				""");
		String callRegFunctions = input.nextLine();

		switch (callRegFunctions) {
			case "9" -> getBackToMainMenu();
			case "1" -> {
				System.out.println("""
					MISSED CALLS
				1 -> Back""");

				String missedCallsFunction = input.nextLine();

				if (missedCallsFunction.equals("1")) 
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToMissedCalls();	}

			}
			case "2" -> {
				System.out.println("""
					RECEIVED CALLS
				1 -> Back""");

				String receivedCallsFunction = input.nextLine();
				if (receivedCallsFunction.equals("1"))
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToReceeivedCalls();	}

			}
			case "3" -> {
				System.out.println("""
					DIALLED NUMBERS
				1 -> Back""");

				String dialledNumbersFunction = input.nextLine();
				if (dialledNumbersFunction.equals("1"))
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToDialledNumbers();	}

			}
			case "4" -> {
				System.out.println("""
					ERASE RECENT CALL LISTS
				1 -> Back""");
				
				String eraseFunction = input.nextLine();
				if (eraseFunction.equals("1"))
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToEraseRecent();	}

			}
			case "5" -> {
				System.out.println("""
					SHOW CALL DURATION
				1 -> Back""");

				String showCallFunction = input.nextLine();

				if (showCallFunction.equals("1"))
					getBackToCallRegister();

else{
					System.out.print("Input a valid number: ");
					getBackToShowCall();	}

			}
			case "6" -> {
				System.out.println("""
					SHOW CALL COSTS
				1 -> Back""");

				String callCostFunction = input.nextLine();
				if (callCostFunction.equals("1"))
					getBackToCallRegister();
	
				else{
					System.out.print("Input a valid number: ");
					getBackToShowCallCost();	}

			}
			case "7" -> {
				System.out.println("""
					CALL COST SETTINGS
				1 -> Back""");
				
				String callCostSettingFunction = input.nextLine();
				if (callCostSettingFunction.equals("1"))
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToCallCost();	}

			}
			case "8" -> {
				System.out.println("""
					PREPAID CREDIT
				1 -> Back""");
				String prepaidCreditFunction = input.nextLine();
				if (prepaidCreditFunction.equals("1")
					getBackToCallRegister();

				else{
					System.out.print("Input a valid number: ");
					getBackToPrepaidCredit();	}

			}
			default -> getBackToCallRegister();
		}
	}

	public void getBackToTones() {
		System.out.println("""
				TONES
				1 -> Ringing tone
				2 -> Ringing volume
				3 -> Incoming call alert
				4 -> Composer
				5 -> Message alert tones
				6 -> Keypad tones
				7 -> Warning and game tones
				8 -> Vibrating alert
				9 -> Screen saver
				10 -> Back
				""");
		String tonesFunctions = input.nextLine();

		switch (tonesFunctions) {
			case "10" -> getBackToMainMenu();
			case "1" -> {
				System.out.println("""
					RINGING TONE
				1 -> Back""");
				
				String RingingToneFunction = input.nextLine();
				if (RingingToneFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToRingingTone();	}

			}
			case "2" -> {
				System.out.println("""
					RINGING VOLUME
				1 -> Back""");
				String ringingFunction = input.nextLine();
				if (ringingFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToRingingVolume();	}

			}
			case "3" -> {
				System.out.println("""
					INCOMING CALL ALERT
				1 -> Back""");
				String incomingFunction = input.nextLine();
				if (incomingFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToIncomingCall();	}

			}
			case "4" -> {
				System.out.println("""
					COMPOSER
				1 -> Back""");
				String composerFunction = input.nextLine();
				if (composerFunction.equals("1"))
					getBackToTones();
				else{
					System.out.print("Input a valid number: ");
					getBackToComposer();	}

			}
			case "5" -> {
				System.out.println("""
					MESSAGE ALERT TONES
				1 -> Back""");
				String alertFunction = input.nextLine();

				if (alertFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToMessageAlert();	}

			}
			case "6" -> {
				System.out.println("""
					KEYPAD TONES
				1 -> Back""");
				String keypadFunctions = input.nextLine();
				if (keypadFunctions.equals("1")) 
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToKeypadTones();	}

			}
			case "7" -> {
				System.out.println("""
					WARNING AND GAME TONES
				1 -> Back""");
				String warningFunction = input.nextLine();
				if (warningFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToWarning();	}

			}
			case "8" -> {
				System.out.println("""
					VIBRATING ALERT
				1 -> Back""");
				String vibratingFunction = input.nextLine();
				if (vibratingFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToVibratingAlert();	}

			}
			case "9" -> {
				System.out.println("""
					SCREEN SAVER
				1 -> Back""");
				String screenFunction = input.nextLine();
				if (screenFunction.equals("1"))
					getBackToTones();

				else{
					System.out.print("Input a valid number: ");
					getBackToScreenSaver();	}
			}
			default -> getBackToTones();
		}
	}

	public void getBackToSettings() {
		System.out.println("""
				SETTINGS
				1 -> Call settings
				2 -> Phone settings
				3 -> Security settings
				4 -> Restore factory settings
				5 -> Back
				""");
		String settingsFunctions = input.nextLine();

		switch (settingsFunctions) {
			case "5" -> getBackToMainMenu();
			case "1" -> {
				System.out.println("""
					CALL SETTINGS
				1 -> Back""");
				String callFunction = input.nextLine();
				if (callFunction.equals("1"))
					getBackToSettings();
			}

				else{
					System.out.print("Input a valid number: ");
					getBackToCallSetting();	}
			case "2" -> {
				System.out.println("""
					PHONE SETTINGS
				1 -> Back""");
				String phoneSettingsFunctions = input.nextLine();
				if (phoneSettingsFunctions.equals("1")) getBackToSettings();

				else{
					System.out.print("Input a valid number: ");
					getBackToPhoneSetting();	}
			}
			case "3" -> {
				System.out.println("""
					SECURITY SETTINGS
				1 -> Back""");
				String securityFunction = input.nextLine();
				if (securityFunction.equals("1"))
					getBackToSettings();
				else{
					System.out.print("Input a valid number: ");
					getBackToSecuritySetting();	}
				
			}
			case "4" -> {
				System.out.println("""
					RESTORE FACTORY SETTINGS
				1 -> Back""");
				String restoreFactoryFunction = input.nextLine();
				if (restoreFactoryFunction.equals("1"))
					getBackToSettings();

				else{
					System.out.print("Input a valid number: ");
					getBackToResetFactory();	}
			}
			default -> getBackToSettings();
		}
	}

	public void getBackToClock() {
		System.out.println("""
				CLOCK
				1 -> Alarm clock
				2 -> Clock settings
				3 -> Date settings
				4 -> Stopwatch
				5 -> Countdown timer
				6 -> Auto update of date and time
				7 -> Back
				""");
		String clockFunctions = input.nextLine();

		switch (clockFunctions) {
			case "7" -> getBackToMainMenu();
			case "1" -> {
				System.out.println("""
					ALARM CLOCK
				1 -> Back""");
				String alarmFunction = input.nextLine();
				if (alarmFunction.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToAlarm();	}
			}
			case "2" -> {
				System.out.println("""
					CLOCK SETTINGS
				1 -> Back""");
				String clockFunction = input.nextLine();
				
				if (clockFunction.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToClockSettings();	}
			}
			case "3" -> {
				System.out.println("""
					DATE SETTINGS
				1 -> Back""");
				String dateFunctions = input.nextLine();
				if (dateFunctions.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToDateSettings();	}
			}
			case "4" -> {
				System.out.println("""
					STOPWATCH
				1 -> Back""");
				String stopwatchFunction = input.nextLine();
				if (stopwatchFunction.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToStopWatch();	}
			}
			case "5" -> {
				System.out.println("""
					COUNTDOWN TIMER
				1 -> Back""");
				String countdownFunction = input.nextLine();
				if (countdownFunction.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToCountdown();	}
			}
			case "6" -> {
				System.out.println("""
					AUTO UPDATE DATE AND TIME
				1 -> Back""");

				String autoUpdateFunction = input.nextLine();


				if (autoUpdateFunction.equals("1"))
					getBackToClock();

				else{
					System.out.print("Input a valid number: ");
					getBackToAutoUpdateTime();	}
			}
			default -> getBackToClock();
		}
	}

	public void getBackToProfiles() {
		System.out.println("""
					PROFILES
			1 -> Back""");
			String profilesFunction = input.nextLine();
			
			
		if (profilesFunction.equals("1")) 

		else{
					System.out.print("Input a valid number: ");
					getBackToProfiles();	}

		getBackToMainMenu();
	}

	public void getBackToSimServices() {
		System.out.println("""
				SIM SERVICES
			1 -> Back""");
		String simFunction = input.nextLine();
		
		if (simFunction.equals(1))
			getBackToMainMenu();

		else{
					System.out.print("Input a valid number: ");
					getBackToSimServices();	}
	}

public void getBackToChat(){


	String chat = """
					CHAT
				1 -> Back""";
				System.out.print(chat);
				String chatFunctions = input.nextLine();
				if (chatFunctions.equals("1") )	
					{getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToChat();}
}

public void getBackToCallDivert(){
	System.out.print(""" 
					CALL DIVERT
				1 -> Back""");
				String callDivert = input.nextLine();
				if (callDivert.equals(1) ){
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToCallDivert();}

}

public void getBackToGames(){
	String games = """
					GAMES
				1 -> Back""";
				System.out.print(games);
				String gamesFunction = input.nextLine();
				if (gamesFunction.equals(1) ){
					 getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToGames();}

}
public void getBackToCalculator(){
String calculator = """
					CALCULATOR
				1 -> Back""";
				
				System.out.print(calculator);
				String calculatorFunction = input.nextLine();
				
				if (calculatorFunction.equals(1)){ 
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToCalculator();}

}
	
public void getBackToReminders(){
	String reminders = """
					REMINDERS
				1 -> Back""";
				
				System.out.print(reminders);
				String remindersFunction = input.nextLine();
				
				if (remindersFunction.equals(1) ) {
					getBackToMainMenu();}
				else{System.out.print("Put a valid number: ");
					getBackToReminders();}


}


public void getBackToSearch(){
	String search = """
					SEARCH
				1 -> Back""";
				
				System.out.print(search);
				String searchFunction = input.nextLine();
				if (searchFunction.equals("1")){ 
					getBackToPhoneBook();}
				else{System.out.print("Put a valid number: ");
					getBackToSearch();}
}

public void getBackToServiceNo(){
				String serviceNo = """
					SERVICE NOS.
				1 -> Back""";

				System.out.print(serviceNo);
				String serviceNoFunction = input.nextLine();

				if (serviceNoFunction.equals("1")) {
					getBackToPhoneBook();}
				else{System.out.print("Put a valid number: ");
					getBackToServiceNo();}	
}

public void getBackToAddName(){
String addName = """
					ADD NAME
				1 -> Back""";

				System.out.print(addName);
				String addNameFunction = input.nextLine();

				if (addNameFunction.equals("1"))
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToAddName();}

}

public void getBackToErase(){
	String erase =  """
					ERASE
				1 -> Back""";
	
				System.out.print(erase);
				String eraseFunction = input.nextLine();

				if (eraseFunction.equals("1"))
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToErase();}
}

public void getBackToEdit(){
	String edit = """
					EDIT
				1 -> Back""";

				System.out.print(edit);
				String editFunction = input.nextLine();

		
				if (editFunction.equals("1")) 
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToEdit();}

}

public void getBackToAssignTone(){
	String assignTone = """
					ASSIGN TONE
				1 -> Back""";

				System.out.print(assignTone);
				String assignToneFunction = input.nextLine();

				if (assignToneFunction.equals("1"))
					getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToAssignTone();}

}


public void getBackToBCard(){
	String sendBCard = """
					SEND B'CARD
				1 -> Back""";

				System.out.print(sendBCard);
				String sendBCardFunction = input.nextLine();

				if (sendBCardFunction.equals("1")) 							getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToBCard();}
}

public void getBackToSpeedDials(){
	String speedDials = """
					SPEED DIALS
				1 -> Back""";

				System.out.print(speedDials);
				String speedDialsFunction = input.nextLine();

				if (speedDialsFunction.equals("1")) 							getBackToPhoneBook();
				else{System.out.print("Put a valid number: ");
					getBackToSpeedDials();}

}


public void getBackToVoiceTags(){
	String voiceTags = """
					VOICE TAGS
				1 -> Back""";

				System.out.print(voiceTags);
				String voiceTagsFunction = input.nextLine();

				if (voiceTagsFunction.equals("1")) 							
					getBackToPhoneBook();
				else{System.out.print("Input a valid number: ");
					getBackToVoiceTags();}
}



public void getBackToTypeOfView(){
		String typeOfView ="""
				TYPE OF VIEW
			1 -> Back""";

				System.out.print(typeOfView);
			
				String typeOfViewFunction = input.nextLine();
				if (typeOfView.equals("1"))
					getBackToOptions();
				else{System.out.print("Input a number: ");
					getBackToTypeOfView();}
}


public void getBackToMemoryStatus(){
	String memoryStatus ="""
			MEMORY STATUS
			1 -> Back""";

				System.out.print(memoryStatus);
				String memoryStatusFunction = input.nextLine();
				if (memoryStatusFunction.equals("1")) 
					getBackToOptions();
				else{System.out.print("Input a number: ");
					getBackToMemoryStatus();}

}



public void getBackToPictureMessages(){
	System.out.println("""
					PICTURE MESSAGES
				1 -> Back""");
	
				String pmFunctions = input.nextLine();
				if (pmFunctions.equals("1"))
					getBackToMessages();
				else{System.out.print("Input a valid number: ");
					getBackToPictureMessages();}

}


}


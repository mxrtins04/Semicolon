while True:
    print("""
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
    """)
    main_menu = input("Choose: ")

    match main_menu:
        case "1":
           while True:
                print("""
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
                """)
                phonebook = input("Choose: ")
                match phonebook:
                    case "11": break
                    case "1":
                        while True:
                            print("SEARCH\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("SERVICE NOS.\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("ADD NAME\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("ERASE\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "5":
                        while True:
                            print("EDIT\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "6":
                        while True:
                            print("ASSIGN TONE\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "7":
                        while True:
                            print("SEND B'CARD\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "8":
                        while True:
                            print("""
                            OPTIONS
                            1 -> Type of view
                            2 -> Memory status
                            3 -> Back
                            """)
                            options = input("Choose: ")
                            match options:
                                case "3": break
                                case "1":
                                    while True:
                                        print("TYPE OF VIEW\n1 -> Back")
                                        if input("Choose: ") == "1": break
                                case "2":
                                    while True:
                                        print("MEMORY STATUS\n1 -> Back")
                                        if input("Choose: ") == "1": break
                    case "9":
                        while True:
                            print("SPEED DIALS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "10":
                        while True:
                            print("VOICE TAGS\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "2":
            while True:
                print("""
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
                """)
                msg = input("Choose: ")
                match msg:
                    case "11": break
                    case "1":
                        while True:
                            print("WRITE MESSAGE\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("INBOX\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("OUTBOX\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("PICTURE MESSAGES\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "5":
                        while True:
                            print("TEMPLATES\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "6":
                        while True:
                            print("SMILEYS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "7":
                        while True:
                            print("""
                            MESSAGE SETTINGS
                            1 -> Set 1
                            2 -> Common
                            3 -> Back
                            """)
                            settings = input("Choose: ")
                            match settings:
                                case "3": break
                                case "1":
                                    while True:
                                        print("SET 1\n1 -> Back")
                                        if input("Choose: ") == "1": break
                                case "2":
                                    while True:
                                        print("COMMON\n1 -> Back")
                                        if input("Choose: ") == "1": break
                    case "8":
                        while True:
                            print("INFO SERVICE\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "9":
                        while True:
                            print("VOICE MAILBOX NUMBER\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "10":
                        while True:
                            print("SERVICE COMMAND EDITOR\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "3":
            while True:
                print("CHAT\n1 -> Back")
                if input("Choose: ") == "1": break
        case "4":
            while True:
                print("""
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
                """)
                call_reg = input("Choose: ")
                match call_reg:
                    case "9": break
                    case "1":
                        while True:
                            print("MISSED CALLS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("RECEIVED CALLS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("DIALLED NUMBERS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("ERASE RECENT CALL LISTS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "5":
                        while True:
                            print("SHOW CALL DURATION\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "6":
                        while True:
                            print("SHOW CALL COSTS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "7":
                        while True:
                            print("CALL COST SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "8":
                        while True:
                            print("PREPAID CREDIT\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "5":
            while True:
                print("""
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
                """)
                tones = input("Choose: ")
                match tones:
                    case "10": break
                    case "1":
                        while True:
                            print("RINGING TONE\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("RINGING VOLUME\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("INCOMING CALL ALERT\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("COMPOSER\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "5":
                        while True:
                            print("MESSAGE ALERT TONES\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "6":
                        while True:
                            print("KEYPAD TONES\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "7":
                        while True:
                            print("WARNING AND GAME TONES\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "8":
                        while True:
                            print("VIBRATING ALERT\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "9":
                        while True:
                            print("SCREEN SAVER\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "6":
            while True:
                print("""
                SETTINGS
                1 -> Call settings
                2 -> Phone settings
                3 -> Security settings
                4 -> Restore factory settings
                5 -> Back
                """)
                sett = input("Choose: ")
                match sett:
                    case "5": break
                    case "1":
                        while True:
                            print("CALL SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("PHONE SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("SECURITY SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("RESTORE FACTORY SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "7":
            while True:
                print("CALL DIVERT\n1 -> Back")
                if input("Choose: ") == "1": break
        case "8":
            while True:
                print("GAMES\n1 -> Back")
                if input("Choose: ") == "1": break
        case "9":
            while True:
                print("CALCULATOR\n1 -> Back")
                if input("Choose: ") == "1": break
        case "10":
            while True:
                print("REMINDERS\n1 -> Back")
                if input("Choose: ") == "1": break
        case "11":
            while True:
                print("""
                CLOCK
                1 -> Alarm clock
                2 -> Clock settings
                3 -> Date settings
                4 -> Stopwatch
                5 -> Countdown timer
                6 -> Auto update of date and time
                7 -> Back
                """)
                clockk = input("Choose: ")
                match clock:
                    case "7": break
                    case "1":
                        while True:
                            print("ALARM CLOCK\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "2":
                        while True:
                            print("CLOCK SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "3":
                        while True:
                            print("DATE SETTINGS\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "4":
                        while True:
                            print("STOPWATCH\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "5":
                        while True:
                            print("COUNTDOWN TIMER\n1 -> Back")
                            if input("Choose: ") == "1": break
                    case "6":
                        while True:
                            print("AUTO UPDATE DATE AND TIME\n1 -> Back")
                            if input("Choose: ") == "1": break
        case "12":
            while True:
                print("PROFILES\n1 -> Back")
                if input("Choose: ") == "1": break
        case "13":
            while True:
                print("SIM SERVICES\n1 -> Back")
                if input("Choose: ") == "1": break


const prompt = require('prompt-sync')({ sigint: true });


const database = {};


function createEventObject(eventName, date, startTime, endTime) {
    return {
        eventName: eventName,
        date: date,
        startTime: startTime,
        endTime: endTime
    };
}


function createNewUserObject(userName, password) {
    if (database.hasOwnProperty(userName)) {
        return false;
    }
    database[userName] = {
        password: password,
        events: []
    };
    return true;
}

function addNewEventToUserObject(userName, event) {
    if (!database.hasOwnProperty(userName)) {
        return false;
    }
    database[userName].events.push(event);
    return true;
}

function updateEventField(userName, eventIndex, field, newValue) {
    if (!database.hasOwnProperty(userName)) 
        return false;
    const events = database[userName].events;
    if (!events[eventIndex]) 
        return false;
    if (!['eventName', 'date', 'startTime', 'endTime'].includes(field)) 
        return false;
    events[eventIndex][field] = newValue;
    return true;
}

function deleteEvent(userName, eventIndex) {
    if (!database.hasOwnProperty(userName)) 
        return false;
    let events = database[userName].events;
    if (!events[eventIndex]) 
        return false;
    events.splice(eventIndex, 1);
        return true;
}

function viewSchedule(userName) {
    if (!database.hasOwnProperty(userName) || database[userName].events.length == 0) {
        console.log("No events found.");
        return;
    }
    console.log(`\nSchedule for ${userName}:`);
    database[userName].events.forEach((event, i) => {
        console.log(
            `${i + 1}. ${event.eventName } | Date: ${event.date} | Start: ${event.startTime} | End: ${event.endTime}`
        );
    });

}

function validateDate(date){
    let parts = date.split('-');
    if(parts.length != 3) 
        return false;
    let day = Number(parts[0]);
    let month = Number(parts[1]);
    let year = Number(parts[2]);

    if(Number.isNaN(day) || Number.isNaN(month) || Number.isNaN(year))  
        return false;
    if(!Number.isInteger(day) || !Number.isInteger(month) || !Number.isInteger(year))
        return false;
    if(day < 1 || day > 31 || month < 1 || month > 12 || year.length < 4 || year.length > 2040)
        return false;   
    return true;
}

function checkIfDateConflits(userName, date, startTime, endTime){
    let sameDayEvents = [];

    for (let event of database[userName].events){
        if(event.date === date){
            sameDayEvents.push(event); 
        }
    }
    if(sameDayEvents.length == 0){
        return false;
    }   

    return true;
}   

function getMinutesOfsameDayEvents(sameDayEvents){
    let minutesArray = [];
    for (let event of sameDayEvents){
        let startMinutes = convertTimeToMinutes(event.startTime);
        let endMinutes = convertTimeToMinutes(event.endTime);
        minutesArray.push({start: startMinutes, end: endMinutes});
    }
    return minutesArray;
}


function convertTimeToMinutes(time){
    let parts = time.split(':');
    let hour = Number(parts[0]);
    let minute = Number(parts[1]);
    return hour * 60 + minute;
}

console.log("Simple Calendar (type 'exit' at username to quit)\n");

while (true) {
    userName = prompt("Enter username: ").trim();
    if (!userName) {
        console.log("Please enter a username.");
        continue;
    }
    if (userName.toLowerCase() == 'exit') {
        console.log("Goodbye.");
        break;
    }


    if (database.hasOwnProperty(userName)) {
        const password = prompt("Enter password: ");
        if (database[userName].password != password) {
            console.log("Incorrect password. Try again.\n");
            continue;
        }   
        console.log(`Login successful! Welcome back, ${userName}.`)   
        break;
    }
        else{
        const password = prompt("You are a new user! Create a password: ");
        createNewUserObject(userName, password);
        console.log(`User ${userName} created and logged in!`);
        break;
        }
   
    }


    while (true) {
        const menuChoice = prompt(
`What would you like to do?
1. Update event.
2. Add event.
3. View schedule.
4. Delete event.
5. Logout.
Choose (1-5): `
        ).trim();

        if (menuChoice == "1") {
            if (database[userName].events.length == 0) {
                console.log("No events to update.");
                continue;
            }
            viewSchedule(userName);
            let idxInput = prompt("Enter the number of the event to update: ").trim();
            let idx = parseInt(idxInput) - 1;
            if (Number.isNaN(idx) || idx < 0 || idx >= database[userName].length) {
                console.log("Invalid selection.");
                continue;
            }
            let fieldChoice = prompt("Which field to update? (name/date/start/end): ").trim().toLowerCase();
            let field = { name: 'eventName', date: 'date', start: 'startTime', end: 'endTime' };
            if (!field[fieldChoice]) {
                console.log("Invalid field selection.");
                continue;
            }
            let newValue = prompt("Enter new value: ");
            updateEventField(userName, idx, field[fieldChoice], newValue);

            console.log("Event updated successfully.");
           
        }

        if (menuChoice == "2") {
            let eventNameInput = prompt("Enter event name: ");
            let dateInput = prompt("Enter event date(i.e dd-mm-yyy): ");
                
            let startTimeInput = prompt("Enter start time: ");
            let endTimeInput = prompt("Enter end time: ");

            let newEvent = createEventObject(eventNameInput, dateInput, startTimeInput, endTimeInput);
            addNewEventToUserObject(userName, newEvent);
            console.log("Event added successfully.");
            continue;
        }

        if (menuChoice == "3") {
            viewSchedule(userName);
            continue;
        }

        if (menuChoice === "4") {
            if (!database.hasOwnProperty(userName) || database[userName].length === 0) {
                console.log("No events to delete.");
                continue;
            }
            viewSchedule(userName);
            let delInput = prompt("Enter the number of the event to delete: ").trim();
            let delIdx = parseInt(delInput, 10) - 1;
            if (Number.isNaN(delIdx) || delIdx < 0 || delIdx >= database[userName].length) {
                console.log("Invalid selection.");
                continue;
            }
            deleteEvent(userName, delIdx);
                console.log("Event deleted.");
        }
        

        if (menuChoice === "5") {
            console.log(`Logged out ${userName}.\n`);
            break;
        }

        console.log("Invalid menu choice. Choose 1-5.");
    }


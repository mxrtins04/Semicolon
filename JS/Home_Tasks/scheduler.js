const prompt = require('prompt-sync')({ sigint: true });


const database = {};


function createEventObject(eventName, date, startTime, endTime) {
    return {
        eventName: eventName || '',
        date: date || '',
        startTime: startTime || '',
        endTime: endTime || ''
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
    database[userName].push(event);
    return true;
}

function updateEventField(userName, eventIndex, field, newValue) {
    if (!database.hasOwnProperty(userName)) return false;
    const events = database[userName];
    if (!events[eventIndex]) return false;
    if (!['eventName', 'date', 'startTime', 'endTime'].includes(field)) return false;
    events[eventIndex][field] = newValue;
    return true;
}

function deleteEvent(userName, eventIndex) {
    if (!database.hasOwnProperty(userName)) 
        return false;
    const events = database[userName];
    if (!events[eventIndex]) 
        return false;
    events.splice(eventIndex, 1);
        return true;
}

function viewSchedule(userName) {
    if (!database.hasOwnProperty(userName) || database[userName].events.length === 0) {
        console.log("No events found.");
        return;
    }
    console.log(`\nSchedule for ${userName}:`);
    database[userName].events.forEach((event, i) => {
        console.log(
            `${i + 1}. ${event.eventName || '[No Name]'} | Date: ${event.date || '[No Date]'} | Start: ${event.startTime || '[No Start]'} | End: ${event.endTime || '[No End]'}`
        );
    });

}

console.log("Simple Calendar (type 'exit' at username to quit)\n");

while (true) {
    const userName = prompt("Enter username: ").trim();
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
    }
        else{
        const password = prompt("You are a new user! Create a password: ");
        createNewUserObject(userName, password);
        console.log(`User ${userName} created and logged in!`);
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

        if (menuChoice === "1") {
            if (!database.hasOwnProperty(userName) || database[userName].length === 0) {
                console.log("No events to update.");
                continue;
            }
            viewSchedule(userName);
            const idxInput = prompt("Enter the number of the event to update: ").trim();
            const idx = parseInt(idxInput, 10) - 1;
            if (Number.isNaN(idx) || idx < 0 || idx >= database[userName].length) {
                console.log("Invalid selection.");
                continue;
            }
            const fieldChoice = prompt("Which field to update? (name/date/start/end): ").trim().toLowerCase();
            let fieldMap = { name: 'eventName', date: 'date', start: 'startTime', end: 'endTime' };
            if (!fieldMap[fieldChoice]) {
                console.log("Invalid field selection.");
                continue;
            }
            const newValue = prompt("Enter new value: ");
            const ok = updateEventField(userName, idx, fieldMap[fieldChoice], newValue);
            console.log(ok ? "Event updated successfully." : "Failed to update event.");
            continue;
        }

        if (menuChoice === "2") {
            const eventNameInput = prompt("Enter event name: ");
            const dateInput = prompt("Enter event date: ");
            const startTimeInput = prompt("Enter start time: ");
            const endTimeInput = prompt("Enter end time: ");

            const newEvent = createEventObject(eventNameInput, dateInput, startTimeInput, endTimeInput);
            const ok = addNewEventToUserObject(userName, newEvent);
            console.log(ok ? "Event added successfully." : "Failed to add event.");
            continue;
        }

        if (menuChoice === "3") {
            viewSchedule(userName);
            continue;
        }

        if (menuChoice === "4") {
            if (!database.hasOwnProperty(userName) || database[userName].length === 0) {
                console.log("No events to delete.");
                continue;
            }
            viewSchedule(userName);
            const delInput = prompt("Enter the number of the event to delete: ").trim();
            const delIdx = parseInt(delInput, 10) - 1;
            if (Number.isNaN(delIdx) || delIdx < 0 || delIdx >= database[userName].length) {
                console.log("Invalid selection.");
                continue;
            }
            const confirmed = prompt("Type 'yes' to confirm delete: ").trim().toLowerCase();
            if (confirmed === 'yes') {
                const ok = deleteEvent(userName, delIdx);
                console.log(ok ? "Event deleted." : "Failed to delete event.");
            } else {
                console.log("Delete cancelled.");
            }
            continue;
        }

        if (menuChoice === "5") {
            console.log(`Logged out ${userName}.\n`);
            break;
        }

        console.log("Invalid menu choice. Choose 1-5.");
    }
}
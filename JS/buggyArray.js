let buggyArray = [1,5,6,0,3,43,7];


function removeUnneededNumbersThatWerePutInByMistake(buggyArray){
let newArray = []
for(let number of buggyArray){
	if(number <= 5 && number >= 1)
		newArray.push(number);
		
		
	}
	return(newArray);
}

console.log(removeUnneededNumbersThatWerePutInByMistake(buggyArray));
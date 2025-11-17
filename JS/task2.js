const customersScores = [{Martins: 40, 
			Isiah: 80,
			John: 92,
			katty: 86,
			jk: 92,
			ok: 82,
			bin: 90,}]


let newArray = [];
let index = customersScores[0]
for( let object in index ){
		if( index[object] >= 80 )
			newArray.push(index[object]);
} 

console.log(newArray);
console.log(sortNumbers(newArray));

function sortNumbers(newArray){
	for( let index = 0; index< newArray.length; index++){
		for(let innerIndex = 0; innerIndex < newArray.length; innerIndex++){
			if(newArray[index] > newArray[innerIndex]){
				let temp = newArray[index];
				newArray[index] = newArray[innerIndex];
				newArray[innerIndex] = temp;
			}
		}
	
	}
return newArray;
}
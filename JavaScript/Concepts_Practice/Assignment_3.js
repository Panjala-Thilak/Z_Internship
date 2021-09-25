//one-liner
const printName = (name) => 'Hi ' + name;
console.log(printName("thilak"))


//template literals
const printBill = (name,bill) => `Hi ${name}, please pay: ${bill}`;
console.log(printBill("thilak","100"))

//Object destructing

const person = {
    name: "Noam Chomsky",
    age: 92,
}

const {name:firstName,age}=person

console.log(firstName);
console.log(age);
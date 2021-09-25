const person = {
    name: "Noam Chomsky",
    age: 92,
    favoriteFood : "Rice"
}

const {name:firstName,age,favoriteFood='Biryani'}=person

console.log(firstName);
console.log(age);
console.log(favoriteFood)

const {name,...rest}=person

console.log(name)
console.log(rest)


const person1 = {
    name: "Nisanth",
    age: 22,
    city:"karimnagar"
}


const person2 = {
    name: "Thilak",
    age: 22,
    state:"Telangana"
}

const person3={...person1,...person2}

console.log(person3)
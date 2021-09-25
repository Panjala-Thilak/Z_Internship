console.log("async/await demo");

async function fun() {
    console.log("Inside async function")
    const response = await fetch('https://api.github.com/users');
    console.log('before response');
    const users=await response.json();
    console.log("users resolved");
    return users;
    //return "thilak";
}


console.log("Before calling the async function")
let a=fun();
a.then(d=>console.log(d))
console.log("After calling the async function")
console.log(a)
console.log("End")
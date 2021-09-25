
async function getData(uId) {
    let email=await new Promise((resolve)=>setTimeout(() => {
        console.log("Fetched the data!");
        resolve("skc@gmail.com");
        }, 4000));
    return email;
    }
    
console.log("start");
var email = getData("skc");
email.then(message=>console.log("Email id of the user id is: " + message));
console.log("end");
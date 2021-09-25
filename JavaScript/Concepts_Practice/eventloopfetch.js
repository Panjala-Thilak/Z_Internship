const fetch = require("node-fetch")
console.log("start")

setTimeout(function cb(){
    console.log("call back1");
});

fetch("https://api.netflix.com")
.then(function cbF(){
console.log("CB netflix");
});


console.log("End")
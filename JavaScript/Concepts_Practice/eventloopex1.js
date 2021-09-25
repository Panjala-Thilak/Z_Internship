console.log("start")

setTimeout(function cb(){
    console.log("call back1");
});

console.log("middle")

setTimeout(function cb(){
    console.log("call back2");
});


console.log("End")
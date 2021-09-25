function makeFunc() {
    var name = 'Mozilla';
    function displayName() {
      return name;
    }
    return displayName;
  }
  
var myFunc = makeFunc();
console.log(myFunc());



function outerFunction(outerVariable) {
    return function innerFunction(innerVariable) {
        console.log("Outer Variable : "+outerVariable);
        console.log("Inner Variable : "+innerVariable);
    }
    
}

const myFunction=outerFunction("outside");
myFunction('inside');
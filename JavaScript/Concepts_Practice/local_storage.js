/*localStorage.setItem("name","thilak");
localStorage.removeItem("name");
console.log(localStorage)*/

localStorage.setItem("name","thilak");
localStorage.setItem("age","22");
console.log(localStorage.getItem("age"));
console.log(localStorage.key(0));

user={name:"thilak"};

localStorage.setItem("user",JSON.stringify(user));
console.log(JSON.parse(localStorage.getItem("user")));
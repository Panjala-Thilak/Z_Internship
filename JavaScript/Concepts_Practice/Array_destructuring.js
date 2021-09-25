
const alphabet=['A','B','C','D']

const numbers=['1,','2','3','4']

const [a,b,...rest]=alphabet
console.log(a)
console.log(b)
console.log(rest)


const alphanum=[...alphabet,...numbers]
console.log(alphanum)


function sumAndMultiply(a,b){
    return  [a+b,a*b];
}
const [sum,multiply]=sumAndMultiply(3,4);
console.log(sum);
console.log(multiply);
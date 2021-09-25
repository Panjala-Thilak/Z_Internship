function* generatorExample() {
    console.log("in side func");
    yield 9;
    yield 10;

    return 11;
    yield 12;
}

const generator=generatorExample();

console.log(generator.next())
console.log(generator.next())
console.log(generator.next())
console.log(generator.next())

for(const n of generatorExample()){
    console.log(n);
}
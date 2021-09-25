const items=['bat','ball'];
console.log(items);

const itemsCopy=[...items];
console.log(itemsCopy);

itemsCopy[0]='wickets';
console.log(itemsCopy)

const itemsCopy1=itemsCopy
itemsCopy1[0]='bat'

console.log(itemsCopy)
console.log(itemsCopy1)
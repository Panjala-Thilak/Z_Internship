
localStorage.clear();
localStorage.setItem("Veg Manchuria",180);
localStorage.setItem("Chicken Manchuria",220);
localStorage.setItem("Panner 65",200);
localStorage.setItem("Chicken 65",200);
localStorage.setItem("Veg Biryani",120);
localStorage.setItem("Chicken Biryani",220);
localStorage.setItem("Chciken  Biryani Family Pack",620);
localStorage.setItem("Mutton Biryani",420);
localStorage.setItem("Double Ka Meetha",100);
localStorage.setItem("Qubani Ka Meetha",120);
localStorage.setItem("Thumps Up",45);
localStorage.setItem("Coffee",40);
localStorage.setItem("Drinking Water",50);

let starter=document.querySelector("#starters");
console.log(localStorage.length)
for(var key in localStorage.length){
    let h4=document.createElement('h4');
    h4.className='item';
    h4.id='item1';
    h4.draggable=true;
    h4.innerHTML=`${key}-${localStorage.key(key).getItem(key)}`
    starter.appendChild(h4)
}
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev,target) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    console.log(target.id);
    console.log(data);
    let item=document.getElementById(data).textContent;
    console.log(target.id);
    var setTableId=target.id.replace('able','');
    var vals=item.split(" Rs-");
    console.log(vals);
    let itemcount=1;
    var itemexists=false;
    let tbodies=document.getElementById(setTableId).getElementsByTagName("tbody");
    console.log(tbodies);
    console.log(tbodies.length);
    for(var i=0;i<tbodies.length;i++){
        let tr=tbodies[i].children[0];
        let itemname=tr.children[0].textContent;
        console.log(itemname);
        if(itemname==vals[0]){
            itemexists=true;
            showTable(setTableId);
            break;
        } 
    }   
    let quantity=1;
    let inpId=setTableId+"i"+document.getElementById(setTableId).rows.length; 
    if(itemexists==false){
    console.log(document.getElementById(setTableId).innerHTML);
    document.getElementById(setTableId).innerHTML+=`<tr><td>${vals[0]}</td><td>${vals[1]}</td><td><input type="number" id=${inpId} value=${quantity}  min='1' max='10' onChange="setQuantity(this); calculateTotal('${setTableId}'); "></td><td><a onclick="deleteItem(this,'${setTableId}')"><div class="w3-padding w3-xlarge w3-text-black">
    <i class="material-icons">delete</i>
    </div></a></td></tr>`;   
    }
    var itemsId="items"+setTableId;
    var noOfItems=document.getElementById(setTableId).rows.length-1;
    document.getElementById(itemsId).innerHTML=`Items : ${noOfItems}`;
    calculateTotal(setTableId);
}


function setQuantity(ele){
    let quantity=ele.value;
    if(quantity<0 || quantity>10){
        alert("Minimum order 1 and Maximum orders is 10");
        ele.defaultValue=1;
        ele.value=1;
    }
    else{
    ele.defaultValue=quantity;
    }
    console.log(ele);
}

function calculateTotal(tableId){
    
    var totalId="total"+tableId;
    var ans=0;
    console.log(totalId);
    console.log(tableId);
    var Rows=document.getElementById(tableId).rows;
    var noOfItems=Rows.length-1;
    for(let k=1;k<Rows.length;k++){
    
        let inpId=Rows[k].children[2].children[0].id;
        let price=parseInt(Rows[k].children[1].textContent);
        ans+=price*parseInt(document.getElementById(inpId).value);
    }
    var itemsId="items"+tableId;
    document.getElementById(itemsId).innerHTML=`Items : ${Rows.length-1}`
    document.getElementById(totalId).innerHTML=`Total : ${ans}`;
}

function deleteItem(ele,id){
    ele.parentElement.parentElement.parentElement.remove();
    calculateTotal(id);
}


function resetTable(id){
    document.getElementById(id).innerHTML=`<thead><tr>
    <th>Item</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>delete</th>
    </tr></thead>`
    calculateTotal(id);
    console.log(id);
    let viewId="view"+id.slice(1);
    let bId="reset"+id.slice(1);
    document.getElementById(id).style.display='none';
    document.getElementById(bId).style.display='none';
    document.getElementById(viewId).style.display='block';
}
/*
const modal = document.querySelector('#my-modal');
const modalBtn = document.getElementById('view1');
const closeBtn = document.querySelector('.close');
console.log(modalBtn)

// Events
modalBtn.addEventListener('click', openModal);
closeBtn.addEventListener('click', closeModal);
window.addEventListener('click', outsideClick);

// Open
function openModal() {
    modal.style.display = 'block';
}*/


function closeTable(id) {
    var viewId="view"+id.slice(1);
    document.getElementById(viewId).style.display='block';
    var bId='reset'+id.slice(1);
    document.getElementById(bId).style.display='none';
    document.getElementById(id).style.display='none';
}

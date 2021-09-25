var course=["starters","main course","desserts","beverages"];
//Filtering
function search(){
    var searchfilter=document.getElementById("search").value;
    searchfilter=searchfilter.toLowerCase();
    if(searchfilter==""){
        allItems();
    }
    if(course.includes(searchfilter)){
        displayCourseMenu(searchfilter);
    }
    else{
        var allitems=document.getElementsByClassName("item");
        for(var k=0;k<allitems.length;k++){
            if(allitems[k].textContent.toLowerCase().indexOf(searchfilter)!=-1){
                allitems[k].style.display='block';
            }
            else{
                allitems[k].style.display='none';
            }
        }
    }
}

function allItems(){
    for(let j=0;j<course.length;j++){
        document.getElementById(course[j]).style.display='block';
    }
    let allItems=document.getElementsByClassName("item");
    for(let i=0;i<allItems.length;i++){
        allItems[i].style.display='block';
    }
}

//Filtering For Particular Course Items List
function displayCourseMenu(x){
    allItems();
    for(var i=0;i<course.length;i++){
        if(course[i]==x){
            document.getElementById(x).style.display='block';
        }
        else{
            document.getElementById(course[i]).style.display='none';
        }
    }
}

function tableSearch(){
    let tablesearchfilter=document.getElementById("tablesearch").value;
    tablesearchfilter=tablesearchfilter.toLowerCase();
    let tableitems=document.getElementsByClassName("tableitem");
    console.log(tableitems);
    for(let k=0;k<tableitems.length;k++){
        if(tableitems[k].textContent.toLowerCase().indexOf(tablesearchfilter)!=-1){
            tableitems[k].style.display='block';
        }
        else{
            tableitems[k].style.display='none';
        }
    }
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
    var total=0;
    console.log(totalId);
    console.log(tableId);
    var Rows=document.getElementById(tableId).rows;
    var noOfItems=Rows.length-1;
    for(let k=1;k<Rows.length;k++){
    
        let inpId=Rows[k].children[2].children[0].id;
        let price=parseInt(Rows[k].children[1].textContent);
        total+=price*parseInt(document.getElementById(inpId).value);
    }
    var itemsId="items"+tableId;
    document.getElementById(itemsId).innerHTML=`Items : ${Rows.length-1}`
    document.getElementById(totalId).innerHTML=`Total : ${total}`;
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
    document.getElementById(bId).style.display='block';
    document.getElementById(viewId).style.display='block';
    const modal = document.querySelector('#my-modal-'+id);
    modal.style.display = 'none';
}

function closeTable(id) {
    const modal = document.querySelector('#my-modal-'+id);
    modal.style.display = 'none';
}

const modal = document.querySelector('#my-modal');

// Close If Outside Click
function outsideClick(e) {
  if (e.target == modal) {
    modal.style.display = 'none';
  }
}


function showTable(id){
    
    console.log(id);
    const modal = document.querySelector('#my-modal-'+id);
    modal.style.display = 'block';
}
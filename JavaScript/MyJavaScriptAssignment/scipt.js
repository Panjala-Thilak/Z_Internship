var tableList  = [
		{ "totalItems" : 0,
		 "totalPrice" : 0,
		 "ids" : "table-1",
		 "items": [] ,
		 "slNo" : 1},
		 { "totalItems" : 0,
		 "totalPrice" : 0,
		 "ids" : "table-2",
		"items": [] ,
		"slNo" : 2},
		 { "totalItems" : 0,
		 "totalPrice" : 0,
		"ids" : "table-3",
	     "items": [] ,
	     "slNo" : 3},
		 { "totalItems" : 0,
		 "totalPrice" : 0,
		"ids" : "table-4",
	     "items": [] ,
	     "slNo" : 4},
		 { "totalItems" : 0,
		 "totalPrice" : 0,
		"ids" : "table-5",
	     "items": [] ,
	     "slNo" : 5} ,
		 { "totalItems" : 0,
		 "totalPrice" : 0,
		"ids" : "table-6", 
	     "items": [] ,
	     "slNo" : 6}
		 ]

var foodlist =  [
	{ "itemName" : "KEY WEST NACHOS" ,
	  "itemPrice" : 100.00,
	   "ids" : "menu1",
	   "type" : "entree"},
	{ "itemName" : "FRENCH FRIES" ,
	  "itemPrice" : 120.00,
	   "ids" : "menu2",
	   "type" : "entree"},
	{ "itemName" : "CHICKEN 65" ,
	  "itemPrice" : 300.00,
	   "ids" : "menu3",
	   "type" : "main course"},
	{ "itemName" : "PANEER BUTTER MASALA" ,
	  "itemPrice" : 400.00,
	   "ids" : "menu4",
	   "type" : "main course"},
	{ "itemName" : "PANEER TIKKA" ,
	  "itemPrice" : 350.00,
	   "ids" : "menu5",
	   "type" : "entree"},
	{ "itemName" : "VEG BIRIYANI" ,
	  "itemPrice" : 450.00,
	   "ids" : "menu6",
	   "type" : "main course"},
	{ "itemName" : "CHICKEN BIRIYANI" ,
	  "itemPrice" : 320.00,
	   "ids" : "menu7",
	   "type" : "main course"},
	{ "itemName" : "CHICKEN BUTTER MASALA" ,
	  "itemPrice" : 420.00,
	   "ids" : "menu8",
	   "type" : "main course"},
	{ "itemName" : "MATAR PANEER" ,
	  "itemPrice" : 330.00,
	   "ids" : "menu9" ,
	   "type" : "main course"},
	{ "itemName" : "FRENCH FRIES WITH CHEES" ,
	  "itemPrice" : 120.00,
	   "ids" : "menu10",
	   "type" : "entree"},
	{ "itemName" : "HOME COUNTRY FRIES" ,
	  "itemPrice" : 150.00,
	   "ids" : "menu11",
	   "type" : "entree"},
	{ "itemName" : "FRENCH FRIES WITH JALAPENOS" ,
	  "itemPrice" : 200.00,
	   "ids" : "menu12",
	   "type" : "entree"},
	{ "itemName" : "CRUSTRY GARLIC FOCACCIA" ,
	  "itemPrice" : 220.00,
	   "ids" : "menu13",
	   "type" : "entree"},
	]




    
/*------------------------------------------------------------------------------------------------------------------
------------------------------function for loading-----------------------------------------------------------------*/
    function loadTables(){
        var table_div = document.getElementById("table_div");
        if( table_div.childElementCount < 3){
        for(var i = 0; i< tableList.length ; i++){
        var div = document.createElement('div');
        var h2 = document.createElement("h2");
        var p = document.createElement("p");
        div.setAttribute("class" , "table");
        div.setAttribute("droppabel" ,"true");
        h2.textContent = tableList.list[i].ids;
        div.appendChild(h2);
        p.setAttribute("class" , "table-status");
        div.appendChild(p);
        table_div.appendChild(div);
    }
}
}
loadTables();
function loadMenu(){
    var menu_div = document.getElementById("menu_div");
    if(menu_div.childElementCount < 3){
    for(var i=0; i< foodlist.list.length; i++){
        var div = document.createElement('div');
        var h2 = document.createElement('h2');
        var p = document.createElement('p');
        div.setAttribute("class" , "menu");
        div.setAttribute("draggable", "true");
        h2.setAttribute("class" , "menu-h2");
        p.setAttribute("class" , "menu-price");
        div.appendChild(h2);
        div.appendChild(p);
        menu_div.appendChild(div);
    }
}
}
loadMenu();
/*-------------------------------------------------------------------------------------------------------------------*/

/*-------------------------------------------------------------------------------------------------------------------
-------------------------------update function---------------------------------------------------------------------*/
    var tables  = document.getElementsByClassName("table");
 	function menuList(){
     var menuList = document.getElementsByClassName("menu-h2");
     var menuPrice = document.getElementsByClassName("menu-price");
     var menus = document.getElementsByClassName("menu");
     for(var i =0; i< menuList.length ; i++){
         menuList[i].textContent = foodlist.list[i].itemName;
         menuPrice[i].textContent = "price:" + " " +foodlist.list[i].itemPrice;
         menus[i].setAttribute("id", foodlist.list[i].ids);
         menus[i].addEventListener("dragstart" , onDrag);

     }
 	}
 	 menuList();

 	function tableUpdate(){
 		var tables  = document.getElementsByClassName("table");
 		var tableUpdate = document.getElementsByClassName("table-status");
 		for(var i =0 ; i < tables.length ; i++){
 			tableUpdate[i].textContent = "Rs. " +tableList.list[i].totalPrice + 
 			" | " + " total items : " + tableList.list[i].totalItems; 
 			tables[i].setAttribute("id" , tableList.list[i].ids);
            tables[i].addEventListener("hover" , hovered);
 			tables[i].addEventListener("drop" , onDrop);
 			tables[i].addEventListener("dragover" , allowDrop);
 			tables[i].addEventListener("dragleave" , dragLeave);
            tables[i].addEventListener("click" , popupModal);
 		}
 	}
 	tableUpdate();
 	var droperId;
 	var droperPrice;
 	var dragItemName;
 	var inputMenu = document.getElementById("menu-input");
    var inputTable = document.getElementById("table-input");
    var modal = document.getElementById("table-modal");
    var span = document.getElementsByClassName("close")[0];
/*------------------------------------------------------------------------------------------------------------------*/

/*-------------------------------------------------------------------------------------------------------------------
-------------------------eventListener functions--------------------------------------------------------------------*/
    function onDrag(ev){
        for(var i =0; i< 13 ; i++){
        	if(foodlist.list[i].ids == this.id){
                ev.dataTransfer.setData("text/plain", foodlist.list[i].itemName);
        		break;
        	}
        }
    }

    function onDrop(ev){
    	for( var i =0; i < 6; i++){
    		if(tableList.list[i].ids == this.id){
    			tableList.list[i].totalItems++;
    			//--useing data transfer api for transfering the data--------------//
    			tableList.list[i].items.push(ev.dataTransfer.getData("text/plain"));
                 updateTotalPrice();
                this.style.backgroundColor= "white";
    			this.style.opacity = 1;
    			tableUpdate();
    			break;
    		}
    	}
    }
    function updateTotalPrice(){
        for(var i =0; i< tableList.list.length; i++){
            tableList.list[i].totalPrice = 0;
            tableList.list[i].totalItems = tableList.list[i].items.length;
            for(var j =0; j< tableList.list[i].items.length; j++){
                for(var k=0; k< foodlist.list.length ; k++){
                    if(tableList.list[i].items[j] == foodlist.list[k].itemName)
                        tableList.list[i].totalPrice += foodlist.list[k].itemPrice;
                }

            }
        }
    }
    function allowDrop(ev){     // on drag over
        ev.preventDefault();
        this.style.backgroundColor = "OLIVEDRAB";
        this.style.opacity = 1;
    }
    function dragLeave(){
    	this.style.backgroundColor = "white";
    	this.style.opacity = 1;
        }
    function hovered(){
        this.style.backgroundColor = "#b5b3b3";
    }
    function DeleteItem(IDofParent ,ID){    // when delete image is clicked.
        var delRow = IDofParent.parentElement;
   
         var item = delRow.getElementsByTagName("td")[1].textContent;
        delRow.remove();
        for(var i =0; i< tableList.list.length; i++){
            if(tableList.list[i].ids == ID){
        while(tableList.list[i].items.indexOf(item) > -1){
                tableList.list[i].items.splice(tableList.list[i].items.indexOf(item) , 1);
               }
           }
           }
               updateTotalPrice();
               updateRow(ID);
               tableUpdate();
    }
    function popupModal(){                   // to display the modal.
       
        document.getElementById("table_div").style.opacity = 0.3;
        document.getElementById("menu_div").style.opacity = 0.3;
        var node = document.getElementById("tableData");
        while (node.hasChildNodes()) {
           node.removeChild(node.lastChild);
         }
        modal = document.getElementById("table-modal");
        modal.style.display = "block";
        var orderHeading= document.getElementById("heading3");
        var orderDetail = document.createElement("div");
        orderDetail.setAttribute("id" , "orderDetailDiv");
        orderHeading.textContent = "" + this.id + " : " + "order detail" ;
        orderHeading.style.color = "white";
        document.getElementById("table-modal").appendChild(orderDetail);
        document.getElementById("inner-modal").appendChild(orderHeading);
       
        loadModal(this.id);
    }
/*-------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------*/

/*------------------------------------------------------------------------------------------------------------------
-----------------------------------Associate functions-------------------------------------------------------------*/
    function loadModal(idofClicked){
        var table = document.getElementById("tableData");
        var tr = document.createElement("tr");
                    var th1= document.createElement("th");
                    var th2= document.createElement("th");
                    var th3= document.createElement("th");
                    th1.textContent = "Sl No.";
                    th2.textContent = "items";
                    th3.textContent = "price";
                    tr.appendChild(th1);  tr.appendChild(th2);  tr.appendChild(th3);
                    table.appendChild(tr);
        for(var i = 0; i < tables.length ; i++){
            if(tableList.list[i].ids == idofClicked){
                //-- getting the unique items from the list-----------------------------------------------//
                //----------------------------------------------------------------------------------------//
                var uniqueList = tableList.list[i].items.filter(function(elem, index, self) {
                         return index == self.indexOf(elem);
                     })
                for(var j = 0 ; j < uniqueList.length ; j++){
                    var tr = document.createElement("tr");
                    var td1= document.createElement("td");
                    var td2= document.createElement("td");
                    var td3= document.createElement("td");
                    var lable = document.createElement('lable');
                    var input = document.createElement("input");
                    var id = tableList.list[i].ids;
                    var itemCount = countOfParticularItems(i , uniqueList[j]);
                    var itemPrice = priceOfParticularItem(uniqueList[j]);
                    var deleteImg = new Image();
                    var item = uniqueList[j];
                    deleteImg.setAttribute("class" , "deleteLogo");
                    deleteImg.setAttribute("src" ,"http://www.freeiconspng.com/uploads/remove-icon-png-25.png");
                    deleteImg.addEventListener('click' , function(){DeleteItem(this ,id);});
                    input.setAttribute("placeholder" ,"no. of items");
                    input.setAttribute("value" , itemCount);
                    input.setAttribute("class" , "itemNoInput");
                    input.setAttribute("id", tableList.list[i].ids);
                    input.addEventListener("keyup" ,function(){OninputvalueChange(this , this.id , this.value);});
                    lable.setAttribute("for" , "itemNoInput");
                    lable.setAttribute("id" , "itemNoInputLable");
                    lable.textContent = "no of items";
                    td1.textContent = "" +(j+1);
                    td2.textContent = uniqueList[j];
                    td3.textContent = itemPrice;
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    tr.appendChild(td3); tr.appendChild(deleteImg);  tr.appendChild(lable); tr.appendChild(input);
                    table.appendChild(tr);
                }
                   var p = document.getElementById("totalprice");
                   p.textContent = "total Price : " + tableList.list[i].totalPrice;
            }
        }
    }
    function updateRow(ID){
        document.getElementById("table_div").style.opacity = 0.3;
        document.getElementById("menu_div").style.opacity = 0.3;
        var node = document.getElementById("tableData");
        while (node.hasChildNodes()) {
           node.removeChild(node.lastChild);
         }
        modal = document.getElementById("table-modal");
        modal.style.display = "block";
        var orderHeading= document.getElementById("heading3");
        var orderDetail = document.createElement("div");
        orderDetail.setAttribute("id" , "orderDetailDiv");
        orderHeading.textContent = "" + ID + " : " + "order detail" ;
        orderHeading.style.color = "white";
        document.getElementById("table-modal").appendChild(orderDetail);
        document.getElementById("inner-modal").appendChild(orderHeading);
        loadModal(ID);
    }
    function countOfParticularItems(tableNo, item){
        var count = 0;
        for( var i =0; i< tableList.list[tableNo].items.length ; i++){
          if(tableList.list[tableNo].items[i] == item){
            count++;
          }
        }
        return count;
    }
    function priceOfParticularItem(item){
        for(var i =0; i< foodlist.list.length; i++){
            if(item === foodlist.list[i].itemName)
                return foodlist.list[i].itemPrice;
        }
    }
   function OninputvalueChange(idOfparent ,ID , value){
    var td = idOfparent.parentElement;
    var item = td.getElementsByTagName("td")[1].textContent;
    value = parseInt(value);
    if(!isNaN(value)){

    if(value < 0){
        alert("incorrect input");
        }
        else{ 
            for( var i = 0; i < tableList.list.length; i++){
            if(tableList.list[i].ids == ID){
               var firstIndex = tableList.list[i].items.indexOf(item);
               while(tableList.list[i].items.indexOf(item) > -1){

                tableList.list[i].items.splice(tableList.list[i].items.indexOf(item) , 1);
               
               }
               while(value > 0){
                tableList.list[i].items.splice(firstIndex, 0, item);
                value--;
               }
               break;
           }
       }
               updateTotalPrice();
               updateRow(ID);
               tableUpdate();
    
        }
      }
   }
/*-----------------------------------------------------------------------------------------------------------------*/

/*-----------------------------------------------------------------------------------------------------------------
---------------------------------onclick, onkeyup  functions------------------------------------------------------*/
    span.onclick = function() {
    modal.style.display = "none";
    document.getElementById("table_div").style.opacity = 1;
        document.getElementById("menu_div").style.opacity = 1;
}
        inputMenu.onkeyup = function(){
             var menus = document.getElementsByClassName("menu");
    	for(var i =0; i< foodlist.list.length ; i++){
    		if(foodlist.list[i].itemName.indexOf(inputMenu.value) > -1 || 
                foodlist.list[i].itemName.indexOf(inputMenu.value.toUpperCase()) > -1||
                foodlist.list[i].type.indexOf(inputMenu.value) > -1){
                menus[i].style.display = "";
    		}
    		else{
    			menus[i].style.display = "none";
    		}
    	}
    }
    inputTable.onkeyup = function(){
             var tables = document.getElementsByClassName("table");
        for(var i =0; i< tableList.list.length ; i++){
            if(tableList.list[i].ids.indexOf(inputTable.value) > -1 || 
                tableList.list[i].ids.indexOf(inputTable.value.toUpperCase()) > -1){
                tables[i].style.display = "";
            }
            else{
                tables[i].style.display = "none";
            }
        }

    }
/*---------------------------------------------------------------------------------------------------------------------
=======================================================================================================================*/
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
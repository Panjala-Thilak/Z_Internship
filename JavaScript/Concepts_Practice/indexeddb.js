
let request=indexedDB.open("QuizQuestDatabase",1),
    db,
    tx,
    store,
    index;

request.onupgradeneeded=function (e) {
    let db=request.result,
    store=db.createObjectStore("QuestionsStore",{
        keyPath:"qId"});
    //store=db.createObjectStore("QuestionStore",{autoIncrement:true});
    index=store.createIndex("questionText","questionText",{unique:false});
    
}
request.onerror=function (e) {
    console.log("there was an error "+ e.target.errorCode);
};

request.onsuccess=function(e) {
    db=request.result
    tx=db.transaction("QuestionsStore","readwrite");
    store=tx.objectStore("QuestionsStore");
    index=store.index("questionText");

    db.onerror=(e)=>{
        console.log("there was an error "+ e.target.errorCode);
    }

    /*store.put({qId:1, questionText : "The sun rises in the east",
        correctAnswer:true, studentAnswer:true, result:true});
    store.put({qId:2, questionText : "The sky is blue",
        correctAnswer:true, studentAnswer:true, result:true});*/

    let q1=store.get(1);
    let qs=index.get("The sky is blue");
    
    q1.onsuccess=()=>{
        console.log(q1.result);
        console.log(q1.result.questionText);
    }

    qs.onsuccess=()=>{
        console.log(qs.result.questionText);
    }

        tx.oncomplete=function () {
            db.close();
        };
}
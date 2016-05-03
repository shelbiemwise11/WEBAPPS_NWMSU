function estimate(){
    
    var allFilled = true;
    var level;
     if (document.getElementById("topOff").checked) {
     level = document.getElementById("topOff").value;
   } else if (document.getElementById("half").checked) {
     level = document.getElementById("half").value;
   } else if (document.getElementById("min").checked) {
      level = document.getElementById("min").value;
   } else {
      allFilled = false;
      alert("You must select a fuel level.");
  }
      
      if(document.getElementById("numOfPass").value === "0" || document.getElementById("numOfPass").value === "" ){
          allFilled = false;
          alert("Must be at least one passanger!");
      }
     
     var raft = ""; 
     var vest = "";
     if(document.getElementById("raft").checked){
         raft = "raft";
     }
     else if(document.getElementById("vest").checked){
         vest = "vest";
     }
   
   if(allFilled){

    request = new XMLHttpRequest();
    var url = "aircraftServlet?planeType=" + document.getElementById("TypesofAircraft").value 
    + "&level=" + level
    + "&pass=" + document.getElementById("numOfPass").value
    + "&raft=" + raft
    + "&vest=" + vest;
    request.open("GET", url, true);
    request.onreadystatechange = displayMessage;
    request.send(null);
   }
   
       
}


function displayMessage() {
   if (request.readyState === 4 && request.status === 200) {
       var results = request.responseText.split("\n");
       document.getElementById("weight").innerHTML = results[0];
       document.getElementById("time").innerHTML = results[1];
   } 
}
   
   
   window.onload = function() {
       document.getElementById("estimate").onclick = estimate;
};




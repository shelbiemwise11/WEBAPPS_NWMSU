function estimate(){
    MC9 = 50000;
    MD83 = 75000;
    TOP_OFF = 10000;
    HALF = 5000;
    MIN = 1000;
    VEST = 300;
    RAFT = 150;
    
    var weight = 0;
    var time = 0;
    var allFilled = true;
    
    
     if (document.getElementById("TypesofAircraft").value === "MC9") {
        weight += MC9;  
     }else if (document.getElementById("TypesofAircraft").value === "MD83"){
         weight += MD83;
     }
     else{
         allFilled = false;
         print("You must select a type of aircraft");
     }
    
     if (document.getElementById("topOff").checked) {
      weight += TOP_OFF;
   } else if (document.getElementById("half").checked) {
      weight += HALF;
   } else if (document.getElementById("min").checked) {
      weight += MIN;
   } else {
      allFilled = false;
      alert("You must select a fuel level.");
   }
   var pass = parseInt(document.getElementById("numOfPass").value)
   if (pass !== 0){
       randTime = Math.floor(Math.random() * (3 - 1 + 1)) +1 ;
        time += pass * randTime;
        weight += pass * 150;
   }
   else{
       allFilled = false;
   }
   
   if(document.getElementById("raft").checked){
       weight += RAFT;
   }
   else if(document.getElementById("vest").checked){
       weight += VEST;
   }
   
   if(allFilled){
       document.getElementById("weight").innerHTML = "Estimated weight is: " + weight + " lbs";
       document.getElementById("time").innerHTML = "Estimated time is: " + time + " minutes";
   }
   
   }
   window.onload = function() {
       document.getElementById("estimate").onclick = estimate;
}




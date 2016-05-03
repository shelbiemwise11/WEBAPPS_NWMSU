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
    
    
     if ($("#TypesofAircraft").val() === "DC9") {
        weight += MC9;
        $("body").css("background-color", "pink");
        $("#pic").attr("src", "DC9.jpg"); 
        $("#pics").slideUp(10);
        $("#pics").slideDown(5000);
     }else if ($("#TypesofAircraft").val() === "MD83"){
         weight += MD83;
        $("body").css("background-color", "yellow");
        $("#pic").attr("src", "MD83.jpg"); 
        $("#pics").slideUp(10);
        $("#pics").slideDown(5000);
         
     }
     else{
         allFilled = false;
         print("You must select a type of aircraft");
     }
    
     if ($(":radio[id=topOff]:checked").val()) {
      weight += TOP_OFF;
   } else if ($(":radio[id=half]:checked").val()) {
      weight += HALF;
   } else if ($(":radio[id=min]:checked").val()) {
      weight += MIN;
   } else {
      allFilled = false;
      alert("You must select a fuel level.");
   }
   var pass = parseInt($("#numOfPass").val());
   if (pass !== 0){
       randTime = Math.floor(Math.random() * (3 - 1 + 1)) +1 ;
        time += pass * randTime;
        weight += pass * 150;
   }
   else{
       allFilled = false;
   }
   
   if($(":checkbox[id=raft]:checked").val()){
       weight += RAFT;
   }
   else if($(":checkbox[id=vest]:checked").val()){
       weight += VEST;
   }
   
   if(allFilled){
       $("#weight").html("Estimated weight is: " + weight + " lbs");
       $("#time").html("Estimated time is: " + time + " minutes");
   }
}
   
   $(document).ready(
           function() {
       $("#estimate").click(estimate);
       }
);



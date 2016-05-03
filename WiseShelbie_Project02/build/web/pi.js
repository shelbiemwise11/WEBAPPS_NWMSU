function calculatePI() {
    var iterations = parseInt(document.getElementById("iterations").value);
    var pi = 0;
     //4 * ((-1)^ i + 1 ) / (2i -1))
    for( i = 1;i<=iterations;i++){
        var x = Math.pow(-1, 1 + i);
        var y = ( 2 * i) -1 ;
        pi += x / y;
    }
    pi = pi * 4;
    document.getElementById("estimate").value = pi;
    
    var percError = Math.abs((Math.PI - pi)/Math.PI) * 100;
    document.getElementById("percError").value = percError.toFixed(2);
}

function calculateDOW() {
    var dow = ["Saturday", "Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];
    var year = parseInt(document.getElementById("year").value);
    var month = parseInt(document.getElementById("mo").value);
    var dayOM = parseInt(document.getElementById("dom").value);
    
    if(month == 1){
        month = 13;
        --year;
    }else if(month == 2){
        month = 14;
        --year;       
    }
    
    var x = Math.floor(13 * (month +1)/5);
    var k = year % 100;
    var j = Math.floor(year/100);
    var y = Math.floor(k/4);
    var z = Math.floor(j/4);
    var dayOW = (dayOM + x + k + y + z + (5*j)) % 7;
    alert("The day of the week is: " + dow[dayOW]);
}

window.onload = function () {
    document.getElementById("calculatePI").onclick = calculatePI;
    document.getElementById("calculateDOW").onclick = calculateDOW;
};
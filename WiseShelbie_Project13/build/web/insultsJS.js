function getInsult(){
    $.getJSON("http://localhost:8080/ShakespeareanInsults/webresources/insultGen", printInsult);
}

function printInsult(insult){
    $('#insult').empty();
    var result = insult.pronoun + " " + insult.adjective1 + ", " + insult.adjective2 + ", " + insult.noun;
    $('#insult').html(result);
    
}

$(document).ready(function(){getInsult()});
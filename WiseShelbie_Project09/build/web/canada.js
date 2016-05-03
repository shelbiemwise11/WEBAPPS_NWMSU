function find(){
    var allFilled = true;
    if($("#pop").val() === "" ){ 
        allFilled = false;
        alert("Need a population count!");
      }
    if($("#land").val() === "" ){ 
        allFilled = false;
        alert("Need the land area!");
      }
    if($("#water").val() === "" ){ 
        allFilled = false;
        alert("Need the water area!");
      }
    if(allFilled){
        
    var url = "canadaServlet?pop=" + $("#pop").val() + "&land=" + $("#land").val() + "&water=" + $("#water").val() ;
    $.getJSON(url,display);
    }
}


function display(canInfo){
   
      $("#tableInfo").empty();
      $.each(canInfo.provinces,
            function() {
                $('#tableInfo').append("<tr>"
                        + "<td>" + this.name + "</td>"
                        + "<td>" + this.population + "</td>"
                        + "<td>" + this.landArea + "</td>"
                        + "<td>" + this.waterArea + "</td>"
                        + "<td>" + this.totalArea + "</td>"
                        + "<td>" + this.officialLanguage + "</td>"
                        + "</tr>");
            });
   
}
   $(document).ready(function() {
       $("#find").click(find);
       }
);

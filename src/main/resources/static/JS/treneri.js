//prikaz svih trenera
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                if(response[i].aktivan == true){
                    row += "<td>" + response[i].id + "</td>";
                    row += "<td>" + response[i].korisnickoIme + "</td>";
                    row += "<td>" + response[i].ime + "</td>";
                    row += "<td>" + response[i].prezime + "</td>";
                    row += "<td>" + response[i].email + "</td>";
                    row += "</tr>";
                }else{
                }
                $('#treneri').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

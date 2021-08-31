// Prikaz svih treninga
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                row += "<th>" + response[i].id + "</th>";
                row += "<td>" + response[i].naziv + "</td>";
                row += "<th>" + response[i].nivoTreninga + "</th>";
                row += "<th>" + response[i].trajanjeUNedeljama + "</th>";
                row += "<th>" + response[i].danaUNedelji + "</th>";
                row += "<th>" + response[i].tipTreninga + "</th>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
            alert("Greska pri dobavljanju treninga");
        }
    });
});
function sortTable() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("treninzi");
    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

$(document).ready(function(){
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#treninzi tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
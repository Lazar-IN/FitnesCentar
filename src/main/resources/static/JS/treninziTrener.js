
$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening/odTrenera/" +trenerId,
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
                let btn = "<button class='btnTermin' data-id=" + response[i].id + ">vidi termine</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnTermin', function () {
    let treningId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    //window.alert(trenerId);
    window.location.href = "terminTrener.html?treningId="  + treningId + "&trenerId=" + trenerId;
});
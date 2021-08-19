$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let treningId = urlParams.get('treningId');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termin/zaTrening/" + treningId,
        dataType: "json",
        success: function (response) {
            for (i = 0; i < response.length; i++) {
                let row = "<tr>";
                row += "<th>" + response[i].datumIVreme + "</th>";
                row += "<td>" + response[i].cena + "</td>";
                let btn = "<button class='btnPrijavi' data-id=" + response[i].id + ">Prijavi se</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#termini').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnPrijavi', function () {
    let terminId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    let urlParams1 = new URLSearchParams(window.location.search);
    let treningId = urlParams1.get('treningId');
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/prijavljeniTrening/odClana/" + clanId + "/termin/" + terminId,
        dataType: "json",
        success: function (response) {
            alert("Termin " + response.id + " je prijavljen");
            window.location.href = "prijavljeniTreninzi.html?clanId=" + clanId + "&terminId=" + terminId + "&treningId=" + treningId;
        },
        error: function () {
            alert("Greška prilikom prijave");
        }
    });
});

function sortTable() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("termini");
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
        $("#termini tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
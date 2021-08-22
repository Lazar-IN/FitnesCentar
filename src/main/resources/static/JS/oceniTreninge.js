$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeniTrening/odClana/" + clanId,
        dataType: "json",
        success: function (res) {

            for (i = 0; i < res.length; i++) {
                let row = "<tr>";
                if (res[i].ocena == null){
                    row += "<td>" + res[i].id + "</td>";
                    row += "<th>" + res[i].naziv + "</th>";
                    row += "<th>" + res[i].nivoTreninga + "</th>";
                    row += "<th>" + res[i].tipTreninga + "</th>";
                    row += "<th>" + res[i].datumIVreme + "</th>";
                    let btn = "<button class='btnOceni' data-id=" + res[i].id + ">oceni</button>";
                    row += "<td>" + btn + "</td>";
                    row += "</tr>";
                } else {
                }
                $('#treninzi').append(row);

            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
            window.alert("Greska u prikazu!");
        }
    });
});

$(document).on('click', '.btnOceni', function () {
    let treningId = this.dataset.id;
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    window.location.href = "unosOcene.html?treningId=" + treningId + "&clanId=" + clanId;
});
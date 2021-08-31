$(document).ready(function () {
    let urlParams1 = new URLSearchParams(window.location.search);
    let treningId = urlParams1.get('treningId');
    let urlParams2 = new URLSearchParams(window.location.search);
    let clanId = urlParams2.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeniTrening/" + treningId,
        dataType: "json",
        success: function (res) {
            $('#ocena').val(res.ocena);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
            alert("Greska pri dobavljanju");
        }
    });

    $(document).on("submit", "#oceni", function (event) {
        event.preventDefault();
        let ocena = $("#ocena").val();

        let newOdradjeniTrening = {
            ocena
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/odradjeniTrening/" + treningId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newOdradjeniTrening),
            success: function (res) {
                alert("Odradjeni trening " + res.naziv + " je uspešno ocenjen!");
                window.location.href = "http://localhost:8080/pocetnaClan.html?clanId=" + clanId;
            },
            error: function () {
                alert("Greška prilikom ocenjivanja!");
            }
        });
    });
});
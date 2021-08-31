$(document).on("submit", "#dodajSaluForm", function (event) {
    event.preventDefault();

    let urlParams = new URLSearchParams(window.location.search);
    let trenerId = urlParams.get('trenerId');
    window.alert(trenerId);

    let naziv = $("#naziv").val();
    let nivoTreninga = $("#nivoTreninga").val();
    let danaUNedelji = $("#danaUNedelji").val();
    let trajanjeUNedeljama = $("#trajanjeUNedeljama").val();
    let tipTreninga = $("#tipTreninga").val();
    let opis = $("#opis").val();
    //let trenerId;

    let newTrening = {
        naziv,
        nivoTreninga,
        danaUNedelji,
        trajanjeUNedeljama,
        tipTreninga,
        opis,
        trenerId
    }
    window.alert(naziv);
    window.alert(nivoTreninga);
    window.alert(danaUNedelji);
    window.alert(trajanjeUNedeljama);
    window.alert(tipTreninga);
    window.alert(opis);
    window.alert(trenerId);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/trening/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrening),
        success: function (res) {
            console.log(res);

            alert("Trening " + res.naziv + " je uspešno kreirana!");
            window.location.href = "http://localhost:8080/pocetnaTrener.html?adminId="+trenerId;
        },
        error: function () {
            alert("Greška prilikom kreiranja novog treninga!");
        }
    });
});
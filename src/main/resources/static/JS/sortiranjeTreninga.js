$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening",
        dataType: "json",
        success: function (response) {
//za sortiranje

            //var data = response;
            var treningData = JSON.parse('response');
            //console.log("id"+treningData.id);
            //console.log("naziv"+treningData.naziv);
            //console.log("nivoTreninga"+treningData.nivoTreninga);
            //console.log("trajanjeUNedeljama"+treningData.trajanjeUNedeljama);
            //console.log("danaUNedelji"+treningData.danaUNedelji);
            //console.log("tipTreninga"+treningData.id);
            //console.log("opis"+treningData.opis);

            $('#treninzi').DataTable( {
                data: treningData,
                columns: [
                    { title: "Id" },
                    { title: "Naziv" },
                    { title: "Nivo Treninga" },
                    { title: "Trajanje u Nedeljama" },
                    { title: "Dana u nedlji" },
                    { title: "Tip treninga" },
                    { title: "opis" }
                ]
            } );
        },
        error: function (response) {
            console.log("ERROR:\n", response);
            alert("Greska");
        }
    });
});




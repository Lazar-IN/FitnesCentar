$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let clanId = urlParams.get('clanId');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clan/" + clanId,
        dataType: "json",
        success: function (res) {
            $('#korisnickoIme').val(res.korisnickoIme);
            $('#lozinka').val(res.lozinka);
            $('#ime').val(res.ime);
            $('#prezime').val(res.prezime);
            $('#kontaktTelefon').val(res.kontaktTelefon);
            $('#email').val(res.email);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
            alert("Greska pri dobavljanju");
        }
    });

    $(document).on("submit", "#prikaz", function (event) {
        event.preventDefault();
        let korisnickoIme = $("#korisnickoIme").val();
        let lozinka = $("#lozinka").val();
        let ime = $("#ime").val();
        let prezime = $("#prezime").val();
        let kontaktTelefon = $("#kontaktTelefon").val();
        let email = $("#email").val();

        let newTermin = {
            korisnickoIme,
            lozinka,
            ime,
            prezime,
            kontaktTelefon,
            email
        }

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/clan/" + clanId,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
            success: function (res) {
                alert("Profil je uspešno ispravljen!");
                window.location.href = "pocetnaClan.html?clanId=" + clanId;
            },
            error: function () {
                alert("Greška prilikom ispravke profila!");
            }
        });
    });
});
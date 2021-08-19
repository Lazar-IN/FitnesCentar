$(document).on("submit", "#login", function (event) {
    event.preventDefault();

    let korisnickoIme = $("#korisnickoIme").val();
    let lozinka = $("#lozinka").val();
    let uloga = $("#uloga").val();

    if(uloga === "TRENER") {

        let newTrener = {
            korisnickoIme,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/trenerlogin",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTrener),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao trener");
                let trenerId = res.id;
                //window.location.href = "../pocetnaTrener.html";
                window.location.href = "pocetnaTrener.html?trenerId=" + trenerId;
            },
            error: function () {
                alert("Pogresna lozinka ili korisnicko ime!");
            }
        });
    } else if (uloga === "CLAN") {

        let newClan = {
            korisnickoIme,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/clanlogin",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newClan),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao clan");
                let clanId = res.id;
                //window.location.href = "../pocetnaClan.html";
                window.location.href = "pocetnaClan.html?clanId=" + clanId;
            },
            error: function () {
                alert("Pogresna lozinka ili korisnicko ime!");
            }
        });
    } else if (uloga === "ADMIN") {
        let newAdmin = {
            korisnickoIme,
            lozinka,
            uloga
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/adminlogin",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newAdmin),
            success: function (res) {
                alert("Uspesno ste se ulogovali kao administrator");
                let adminId = res.id;
                //window.location.href = "../pocetnaAdmin.html";
                window.location.href = "pocetnaAdmin.html?adminId=" + adminId;
            },
            error: function () {
                alert("Pogresna lozinka ili korisnicko ime!");
            }
        });
    }
});
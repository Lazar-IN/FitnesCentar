    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/clan",
        dataType: "json",
        contentType: "application/json",
        data: {
            korisnickoIme: $("#korisnickoIme").val(),
            lozinka: $("#lozinka").val()
        },
        success: function (response){
            var data = response;
            clanData = JSON.parse(data);
                console.log("id:"+clanData.id);
                console.log("korisnickoIme"+clanData.korisnickoIme);
                console.log("lozinka"+clanData.lozinka);
        },
        failure: function (data){
            alert('Server connection failed');
        },
        error: function (request, error){
            alert(error);
        }
    });







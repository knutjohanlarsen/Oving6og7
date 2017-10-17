$(document).ready(function(){
    var booking = JSON.parse(localStorage.getItem("booking"));
    document.getElementById("bookingnavn").innerHTML = booking['bookingId'];
    document.getElementById("antall").innerHTML = booking['antallGjester'];
    document.getElementById("kortnummer").innerHTML = booking['kredittkort'];
    document.getElementById("utlopsdato").innerHTML = booking['utlopsdato'];
    document.getElementById("dato").innerHTML = booking['bookingsTidspunkt'].toString();
    document.getElementById("klokkeslett").innerHTML = booking['bookingsTidspunkt'].toString();
    document.getElementById("forrett").innerHTML = booking['forrett'];
    document.getElementById("hovedrett").innerHTML = booking['hovedrett'];
    document.getElementById("dessert").innerHTML = booking['dessert'];
    document.getElementById("drikke").innerHTML = booking['drikke'];
    console.log(booking);

    $("#aksept").click(function () {
        alert("check");
        var booking = localStorage.getItem("booking");
        $.ajax({
            url: 'rest/services/bookings',
            type: 'POST',
            data: booking,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(data) {
                console.log(booking)
                if (data == -1) alert("Bord opptatt");
                else alert("Success")
            }
        });
    });

    $("#avbryt").click(function () {
        window.open ('index.html','_self',false);
    });
});


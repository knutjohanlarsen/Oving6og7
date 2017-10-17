$(document).ready(function() {
    $("#confirm").click(function () {
        var booking = JSON.parse(localStorage.getItem("booking"));
        booking['kredittkort'] = $("#kortnummer").val();
        booking['utlopsdato'] = new Date($("#utløpsdato").val()).toJSON();
        booking['kontrollsiffer'] = $("#kontrollsiffer").val();
        booking = JSON.stringify(booking);
        /*$.ajax({
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
        });*/
        localStorage.setItem("booking", booking);
        window.open ('confirmBooking.html','_self',false);
    });

});
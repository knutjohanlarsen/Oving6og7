var booking;

$(document).ready(function(){
    console.log(document);
    var coeff = 1000 * 60 * 30;
    var date = new Date();
    var offset = date.getTimezoneOffset() * 60000;
    var rounded = new Date(Math.ceil(date.getTime() / coeff) * coeff - offset);
    document.getElementById("date").min = rounded.toISOString().slice(0,19);
    document.getElementById("date").defaultValue = rounded.toISOString().slice(0,19);
    /*var elements = document.getElementsByTagName("SELECT");
    console.log(elements);
    for (var i = 0; i < elements.length; i++) {
        elements[i].oninvalid = function(e) {
            if (!elements[0].validity.valid && !elements[1].validity.valid &&
                !elements[2].validity.valid && !elements[3].validity.valid) {
                    elements[0].setCustomValidity("Minst èn rett eller drikke må velges");
            }
            else{
                e.target.setCustomValidity("");
            }

        };
        elements[i].oninput = function(e) {
            e.target.setCustomValidity("");
        };
    }*/

});

function addBooking() {
    if(checkValidBookingInformation()) {
        booking = JSON.stringify({
            bookingId: $("#navn").val(),
            bookingsTidspunkt: new Date($("#date").val()).toJSON(),
            antallGjester: $("#antGjester").val(),
            forrett: $("#forrett option:selected").val(),
            hovedrett: $("#hovedrett option:selected").val(),
            dessert: $("#dessert option:selected").val(),
            drikke: $("#drikke option:selected").val()
        });
        // if(checkAvailability()) {
            console.log(booking);
            localStorage.setItem("booking", booking);
            window.open('payment.html', '_self', false);
        // }

    }
}

function checkAvailability() {
    var freeDates = [];
    $.get('/rest/services/' + new Date($("#date").val()).getTime(), function (data) {
        console.log(data);
        for (var bookings = 0; bookings < data.length; bookings++) {
            var bord = data[bookings];
            /*for (var bookingId = 0; bookingId < bord.bookings.length; bookingId++) {
                freeDates.push(new Date());
            }*/
        }
        console.log(freeDates);
        });
    return true;
}

function resetDateField(){
    var coeff2 = 1000 * 60 * 30;
    var date = new Date();
    var offset = date.getTimezoneOffset() * 60000;
    var rounded = new Date(Math.ceil(date.getTime() / coeff2) * coeff2 - offset);
    document.getElementById("date").value = rounded.toISOString().slice(0,19);
}

function checkValidBookingInformation(){
    if($("#forrett").val() == "" && $("#hovedrett").val() == "" && $("#dessert").val() == "" && $("#drikke").val() == ""){
        alert("Minst èn rett eller drikke må velges");
        return false;
    }
    return true;
}
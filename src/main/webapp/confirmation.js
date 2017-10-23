$(document).ready(function(){
    console.log(localStorage.getItem("booking"));
    var booking = JSON.parse(localStorage.getItem("booking"));
    document.getElementById("bookingnavn").innerHTML = booking['bookingId'];
    document.getElementById("antall").innerHTML = booking['antallGjester'];
    document.getElementById("kortnummer").innerHTML = booking['kredittkort'];
    document.getElementById("dato").innerHTML = new Date(booking['bookingsTidspunkt']).toLocaleDateString();
    document.getElementById("klokkeslett").innerHTML = new Date(booking['bookingsTidspunkt']).toLocaleTimeString();
    document.getElementById("forrett").innerHTML = booking['forrett'];
    document.getElementById("hovedrett").innerHTML = booking['hovedrett'];
    document.getElementById("dessert").innerHTML = booking['dessert'];
    document.getElementById("drikke").innerHTML = booking['drikke'];
    console.log(booking);


});


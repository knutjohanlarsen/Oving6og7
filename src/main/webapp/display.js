function getText() {
    $.get('rest/services/bookings/display', function (data) {
        console.log(data);
        console.log(data.length);
        console.log(data[0]);
        console.log();
        var html = "";
        for (var i = 0; i < data.length; i++) {
            html += "<tr>";
            html += "<td>" + data[i].bookingId + "</td>";
            html += "<td>"
            html += "<td>" + new Date(data[i].bookingsTidspunkt).toLocaleDateString() + "</td>";
            html += "<td>" + new Date(data[i].bookingsTidspunkt).toLocaleTimeString() + "</td>";
            html += "<td>" + data[i].forrett + "</td>";
            html += "<td>" + data[i].hovedrett + "</td>";
            html += "<td>" + data[i].dessert + "</td>";
            html += "<td>" + data[i].drikke + "</td>";
            html += "</tr>";
        }
        $("#tabell").html(html);
    });
}

$(document).ready(function() {
    getText();
    setInterval(getText, 30000);
});
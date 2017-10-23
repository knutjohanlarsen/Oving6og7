package services;

import java.util.Date;

public class Bookings {

    private String bookingId;
    private Date bookingsTidspunkt;
    private Date utlopsBookingsTidspunkt;
    private String antallGjester;
    private String forrett;
    private String hovedrett;
    private String dessert;
    private String drikke;
    private String kredittkort;
    private Date utlopsdato;
    private String kontrollsiffer;


    public Bookings(){

    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingsTidspunkt() {
        return bookingsTidspunkt;
    }

    public void setBookingsTidspunkt(Date bookingsTidspunkt) {
        this.bookingsTidspunkt = bookingsTidspunkt;
    }

    public Date getUtlopsBookingsTidspunkt() {
        return utlopsBookingsTidspunkt;
    }

    public void setUtlopsBookingsTidspunkt(Date utlopsBookingsTidspunkt) {
        this.utlopsBookingsTidspunkt = utlopsBookingsTidspunkt;
    }

    public String getAntallGjester() {
        return antallGjester;
    }

    public void setAntallGjester(String antallGjester) {
        this.antallGjester = antallGjester;
    }

    public String getForrett() {
        return forrett;
    }

    public void setForrett(String forrett) {
        this.forrett = forrett;
    }

    public String getHovedrett() {
        return hovedrett;
    }

    public void setHovedrett(String hovedrett) {
        this.hovedrett = hovedrett;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrikke() {
        return drikke;
    }

    public void setDrikke(String drikke) {
        this.drikke = drikke;
    }

    public String getKredittkort() {
        return kredittkort;
    }

    public void setKredittkort(String kredittkort) {
        this.kredittkort = kredittkort;
    }

    public Date getUtlopsdato() {
        return utlopsdato;
    }

    public void setUtlopsdato(Date utlopsdato) {
        this.utlopsdato = utlopsdato;
    }

    public String getKontrollsiffer() {
        return kontrollsiffer;
    }

    public void setKontrollsiffer(String kontrollsiffer) {
        this.kontrollsiffer = kontrollsiffer;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", antallGjester=" + antallGjester +
                ", forrett=" + forrett.toString() +
                ", hovedrett=" + hovedrett.toString() +
                ", dessert=" + dessert.toString() +
                ", drikke=" + drikke.toString() +
                ", kredittkort=" + kredittkort +
                ", utløpsdato=" + utlopsdato +
                ", kontrollsiffer=" + kontrollsiffer +
                '}';
    }
}

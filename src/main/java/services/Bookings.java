package services;

import java.util.Date;

public class Bookings {

    private String bookingId;
    private Date bookingsTidspunkt;
    private Date utløpsBookingsTidspunkt;
    private String antallGjester;
    private String forrett;
    private String hovedrett;
    private String dessert;
    private String drikke;
    private int kredittkort;
    private Date utlopsdato;
    private int kontrollsiffer;


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

    public Date getUtløpsBookingsTidspunkt() {
        return utløpsBookingsTidspunkt;
    }

    public void setUtløpsBookingsTidspunkt(Date utløpsBookingsTidspunkt) {
        this.utløpsBookingsTidspunkt = utløpsBookingsTidspunkt;
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

    public int getKredittkort() {
        return kredittkort;
    }

    public void setKredittkort(int kredittkort) {
        this.kredittkort = kredittkort;
    }

    public Date getUtlopsdato() {
        return utlopsdato;
    }

    public void setUtlopsdato(Date utlopsdato) {
        this.utlopsdato = utlopsdato;
    }

    public int getKontrollsiffer() {
        return kontrollsiffer;
    }

    public void setKontrollsiffer(int kontrollsiffer) {
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

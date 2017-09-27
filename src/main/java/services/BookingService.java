package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/services/")
public class BookingService {

    public static Bord[] bord = new Bord[3];

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bord[] getBord() {
        return bord;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void populateBord() {
        for (int i = 0; i < bord.length; i++) bord[i] = new Bord(String.valueOf(i));
    }

    @POST
    @Path("/bookings")
    @Consumes(MediaType.APPLICATION_JSON)
    public int addBooking(Bookings booking) {
        for (Bord bord: bord) if(bord.addBooking(booking)) return 1;
        return -1;
    }

    @GET
    @Path("/bookings/display/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Bord[] displayTest(){
        return bord;
    }

    @GET
    @Path("/bookings/display")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<services.Bookings> display(){
        ArrayList<services.Bookings> bookings = new ArrayList<>();
        for (int i = 0; i < bord.length; i++){
            ArrayList<Bookings> temp = bord[i].getBookings();
            for (int j = 0; j < temp.size(); j++){
                bookings.add(temp.get(j));
            }
        }
        return bookings;
    }

    @DELETE
    @Path("/{bordId}/{bookingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteKunde(@PathParam("bordId") String bordId, @PathParam("bookingId") String bookingId) {
        this.bord[Integer.parseInt(bordId)].removeBooking(bookingId);
    }
}
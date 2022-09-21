package cinema;

public class ReturnedTicket {
    Seat returned_ticket;

    ReturnedTicket(Seat seat) {
        this.returned_ticket = seat;
    }
    public Seat getReturned_ticket() {
        return returned_ticket;
    }

}

package cinema;

import java.util.UUID;

public class Reservation {
    UUID token;
    Seat ticket;
    Reservation(Seat ticket) {
        this.token = UUID.randomUUID();
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}

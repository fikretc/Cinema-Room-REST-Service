package cinema;

public class Statistics {
    CinemaRoom cinemaRoom;
    int current_income;
    int number_of_available_seats;
    int number_of_purchased_tickets;
    public Statistics(CinemaRoom cinemaRoom) {
        this.current_income = cinemaRoom.currentIncome();
        this.number_of_available_seats = cinemaRoom.numberOfAvailableSeats();
        this.number_of_purchased_tickets = cinemaRoom.numberOfPurchasedTickets();
    }

    public int getCurrent_income() {
        return current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }
}

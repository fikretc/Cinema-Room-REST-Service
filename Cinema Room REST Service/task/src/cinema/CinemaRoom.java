package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats = new ArrayList<Seat>();
    private List<Seat> occupied_seats = new ArrayList<Seat>();

    private final int premiumRows = 5;

    public CinemaRoom() {
        total_rows =9;
        total_columns =9;
        initSeats();
    }

    public CinemaRoom(int rows, int cols){
        total_rows = rows;
        total_columns = cols;
        initSeats();
    }
    public int seatPrice(int rowNumber) {
        return (rowNumber < premiumRows) ? 10 : 8;
    }

    private void initSeats() {
        for (int i = 0; i < total_rows; i++){
            for (int j = 0; j < total_columns; j++){
                int price = seatPrice(i+1);
                available_seats.add(new Seat(i+1,j+1, price));

            }
        }
    }

    public boolean checkParamError(Seat seat) {
        return ((this.total_rows < seat.getRow()) || (this.total_columns < seat.getColumn())
                || (seat.getRow() < 0) || (seat.getColumn() < 0));
    }


    public Seat processPurchaseRequest(Seat seat) {
        if (available_seats.contains(seat)) {
            seat.setPrice(seatPrice(seat.getRow()));
            occupied_seats.add(seat);
            available_seats.remove(seat);
            return seat;
        }
        return null;

    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }


    public void cancelPurchaseRequest(Seat seat) {
        if (occupied_seats.contains(seat)) {
            seat.setPrice(seatPrice(seat.getRow()));
            occupied_seats.remove(seat);
            available_seats.add(seat);
        }
    }

    public int currentIncome() {
        int income = 0;
        for (Seat seat: occupied_seats) {
            income += seat.getPrice();
        }
        return income;
    }

    public int numberOfAvailableSeats() {
        return this.available_seats.size();
    }

    public int numberOfPurchasedTickets() {
        return this.occupied_seats.size();
    }
}

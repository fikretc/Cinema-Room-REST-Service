package cinema;

public class Seat {
    private int row;
    private int column;


    private int price;

    Seat() {}

    Seat(int rown, int columnn, int pricen) {
        this.setRow(rown);
        this.setColumn(columnn);
        this.setPrice(pricen);
    }

    Seat(int rown, int columnn) {
        this(rown, columnn,0);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if(obj instanceof Seat) {
            Seat seat = (Seat)obj;
            if (this.row == seat.row && this.column == seat.column) { //price is not compared!!!
                return true;
            }
        }
        return false;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}


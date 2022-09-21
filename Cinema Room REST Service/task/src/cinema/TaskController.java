package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class TaskController {
    private final CinemaRoom cinemaRoom = new CinemaRoom(9, 9);
    private ConcurrentMap<UUID, Seat> reservationBook = new ConcurrentHashMap<>();
    private String password = "super_secret";

    @GetMapping("/seats")
    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    public ResponseEntity makePurchase(@RequestBody Seat seat) {
        //seat.setPrice(cinemaRoom.seatPrice(seat.getRow()));

        if (cinemaRoom.checkParamError(seat)) {
            String invalidSeatRequest = "{\n    \"error\": \"The number of a row or a column is out of bounds!\"\n}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(invalidSeatRequest);
        }
        Seat foundSeat = cinemaRoom.processPurchaseRequest(seat);
        if (foundSeat != null) {
            Reservation reservation = new Reservation(foundSeat);
            reservationBook.put(reservation.token, foundSeat);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(reservation);
        }
        String purchasedSeatRequest = "{\n    \"error\": \"The ticket has been already purchased!\"\n}";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(purchasedSeatRequest);

    }

    @PostMapping(value = "/return", consumes = "application/json", produces = "application/json")
    public ResponseEntity makePurchase(@RequestBody Token keyToken) {
        UUID token = keyToken.getToken();
        if(reservationBook.containsKey(token)) {
            Seat seat = (Seat) reservationBook.remove(token);
            cinemaRoom.cancelPurchaseRequest(seat);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ReturnedTicket(seat));
        }

        String wrongToken = "{\n    \"error\": \"Wrong token!\"\n}";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(wrongToken);
    }

    @PostMapping(value = "/stats",
            produces = "application/json")
    public ResponseEntity sendStatistics(@RequestParam(required = false) String password) {
        if (Objects.equals(password, this.password)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Statistics(cinemaRoom));
        }
        String invalidPassword = "{\n    \"error\": \"The password is wrong!\"\n}";
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(invalidPassword);
    }



}

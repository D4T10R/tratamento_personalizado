package entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    // ATRIBUTOS
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    // CONSTRUTORES
    public  Reservation() {
    }
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // ENCAPSULAMENTO
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }
   
    public Date getCheckout() {
        return checkout;
    }
    

    // METODOS
    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    } 

    public String updateDates(Date checkIn, Date checkOut) {
        
        Date now = new Date();
        if ( checkIn.before(now) || checkOut.before(now)) {
            return "Erro in reservation: reservation dates for update be future";
        }
        else if (! checkOut.after(checkIn)) {
            return "Erro in reservation: Check-out date must be after";
        }

        this.checkin = checkIn;
        this.checkout = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room" 
            + roomNumber
            + ", check-in: "
            + getCheckin() 
            + ", check-out: "
            + getCheckout() 
            + ", "
            + duration()
            + " Nigths.";
    }
    


}

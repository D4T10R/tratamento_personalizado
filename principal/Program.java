package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("Check-in : ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out : ");
        Date checkOut = sdf.parse(sc.next());

        if (! checkOut.after(checkIn)) {

            System.out.println("Erro in reservation: Check-out date must be after");

        }  
        else {

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-in : ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out : ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if ( checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro in reservation: reservation dates for update be future");
            }
            else if (! checkOut.after(checkIn)) {
                System.out.println("Erro in reservation: Check-out date must be after");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
            
        }


        
        


    }

}
package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Exception.DomainException;
import entities.Reservation;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in : ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out : ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-in : ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out : ");
            checkOut = sdf.parse(sc.next());
    
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");            
        }
        catch (DomainException e) {
            System.out.println("Erro in reservationr" + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected erro!");
        }
        
            














    }

}
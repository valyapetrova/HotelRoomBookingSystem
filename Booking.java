package com.HotelRoomBookingSystem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//this class is still in progress
//please don't pay too much attention to it :)


public class Booking {
    public void dateBooking() {
        System.out.println("Enter a date (YYYY-MM-DD):");
        // String dateInput = sc.nextLine();
        // Define the expected date format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the user input into a LocalDate
        //LocalDate date = LocalDate.parse(dateInput, dateFormatter);

    }
}
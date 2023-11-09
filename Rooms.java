package com.HotelRoomBookingSystem;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rooms implements Serializable {

    enum roomType{
        SUITE,
        DELUXE,
        REGULAR

    }
    private roomType type;
    private int number;
    private int maxOccupancy;
    private double price;
    private double cancellationFee;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public Rooms(int number, int maxOccupancy, double price, double cancellationFee, roomType type) {
        this.type = type;
        this.number = number;
        this.maxOccupancy = maxOccupancy;
        this.price = price;
        this.cancellationFee = cancellationFee;
    }

    public roomType getType() {
        return type;
    }

    public void setType(roomType type) {
        this.type = type;
    }

    public String toString(){
        return "type: " + this.type + "\n" + "number: " + this.number + "\n" + "max occupancy: " + this.maxOccupancy + "\n"
                + "cancellation fee: " + this.cancellationFee + "\n" + "price per night: "+ this.price;
    }




}
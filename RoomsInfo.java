package com.HotelRoomBookingSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsInfo implements Serializable {
    private List<Rooms> deluxe = new ArrayList<>();
    private List<Rooms> suite = new ArrayList<>();
    private List<Rooms> regular = new ArrayList();


    public void addRooms() {
        // Populate the room lists
        deluxe.add(new Rooms(102, 6, 300, 50, Rooms.roomType.DELUXE));
        deluxe.add(new Rooms(103, 6, 300, 50, Rooms.roomType.DELUXE));
        suite.add(new Rooms(201, 3, 130, 20, Rooms.roomType.SUITE));
        suite.add(new Rooms(202, 4, 180, 30, Rooms.roomType.SUITE));
        suite.add(new Rooms(203, 4, 175, 25, Rooms.roomType.SUITE));
        regular.add(new Rooms(203, 4, 175, 25, Rooms.roomType.SUITE));
        regular.add(new Rooms(301, 2, 100, 15, Rooms.roomType.REGULAR));
        regular.add(new Rooms(302, 1, 80, 10, Rooms.roomType.REGULAR));
    }

    public void writeRoomsToFile() {
        addRooms();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Users/valya/OneDrive/rooms.txt"));
            out.writeObject(deluxe);
            out.writeObject(suite);
            out.writeObject(regular);
            System.out.println("nice");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readRoomsFromFile() {
        writeRoomsToFile();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/valya/OneDrive/rooms.txt"))) {
            deluxe = (List<Rooms>) in.readObject();
            suite = (List<Rooms>) in.readObject();
            regular = (List<Rooms>) in.readObject();
            for(Rooms room : deluxe){
                System.out.println(room);
            }
            for(Rooms room : suite){
                System.out.println(room);
            }
            for(Rooms room : regular){
                System.out.println(room);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getRoomNumbers() {
        List<Integer> roomNumbers = new ArrayList<>();

        for (Rooms room : deluxe) {
            roomNumbers.add(room.getNumber());
        }
        for (Rooms room : suite) {
            roomNumbers.add(room.getNumber());
        }
        for (Rooms room : regular) {
            roomNumbers.add(room.getNumber());
        }
        for (Integer num : roomNumbers){
            System.out.print(num + ", ");

        }
    }

}
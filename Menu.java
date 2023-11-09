package com.HotelRoomBookingSystem;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Menu {
    public static void menu() {
        String name = "";
        String email = "";
        String pass = "";

        System.out.println("Welcome to VALS GRANDE HOTEL!");
        introduction();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equals("1")){
            //view rooms
            RoomsInfo info = new RoomsInfo();
            info.readRoomsFromFile();

        }
        if(input.equals("2")){
            //book a room
            RoomsInfo book = new RoomsInfo();
            System.out.println("Choose your desired room: ");
            book.getRoomNumbers();
            int num = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the dates you want to reserve (, separated): ");
            String[] dateStrings = input.split(",");
            int[] dates = Arrays.stream(dateStrings)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            HashMap<Integer, List<Date>> reservedDates = new HashMap<>();
            for (int i=0; i<dates.length; i++){
                if (!reservedDates.containsValue(i)){
                    ArrayList <Date> date = new ArrayList<>();
                    //date.add(i);
                    reservedDates.put(num,new ArrayList<>());
                }else{
                    System.out.printf("The room is reserved for the selected dates %d", dates[i]);
                }
            }
        }
        if(input.equals("3")){
            //cancel booking

        }
        if(input.equals("4")){
            //register
            System.out.println("Enter your name: ");
            name = sc.nextLine();
            System.out.println("Enter your e-mail: ");
            RegexVerification obj = new RegexVerification();
            boolean isValid = false;
            while(! isValid){
                email = sc.nextLine();
                if (obj.emailValidation(email)){
                    System.out.println("Valid.");
                    isValid = true;
                }else{
                    isValid = false;
                    System.out.println("Invalid e-mail format.");
                }
            }
            System.out.println("Enter your password: ");
            pass = sc.nextLine();
            User user = new User(name,email,pass);
            //read userJson from file (if file exists)

            JSONObject userJson = new JSONObject();
            userJson.putIfAbsent("users",new JSONObject());

            HashMap<String, String> newUserInfo = new HashMap<String, String>();
            newUserInfo.put("name",user.getName());
            newUserInfo.put("password",user.getPass());

            HashMap currentUsers = (HashMap) userJson.get("users");
            currentUsers.put(user.getEmail(),newUserInfo);
            userJson.put("users",currentUsers);

            try {
                FileWriter file = new FileWriter("C:/Users/valya/OneDrive/userInfos2.json");
                file.write(userJson.toJSONString());
                file.close();

            } catch (IOException e) {
                System.out.println("I/O error during json file write");
                throw new RuntimeException(e);
            }

        }
        if(input.equals("5")){
            //login
            login(name, pass);
        }

    }
    public static void introduction() {
        System.out.println("How can we help you today? Please choose a number from the list menu down below.");
        List<String> menu = new ArrayList<>();
        menu.add("View Rooms");
        menu.add("Book a Room");
        menu.add("Cancel Booking");
        menu.add("Register");
        menu.add("Login");
        menu.add("Exit");
        int count = 0;

        for (String el : menu) {
            count++;
            System.out.print(count + "." + el);
            System.out.println();
        }
    }
    public static boolean login(String email, String pass){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        email = sc.nextLine();
        System.out.println("Enter your password: ");
        pass = sc.nextLine();

        JSONParser jsonParser = new JSONParser();
        try {
            FileReader file = new FileReader("C:/Users/valya/OneDrive/userInfos2.json");

            JSONObject allUsersInfo = (JSONObject) jsonParser.parse(file);
            HashMap currentUsers = (HashMap) allUsersInfo.get("users");
            HashMap userObj = (HashMap) currentUsers.getOrDefault(email, new JSONObject());

            if (pass.equals(userObj.getOrDefault("password", ""))){
                System.out.println("Login successuful");
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Login failed");
        return false;

    }
}

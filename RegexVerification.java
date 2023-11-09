package com.HotelRoomBookingSystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexVerification {
    public static boolean emailValidation(String a) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(a);

        return matcher.find();

    }public static boolean passwordValidation(String b) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+[\\d+\\.]{2,10}$");
        Matcher matcher = pattern.matcher(b);
        return matcher.find();

    }

}
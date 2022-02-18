package com.codeup.adlister.util;

import java.util.regex.Pattern;

public class Validate {


   //When a string of email gets passed it is ran against
    //the regex and if it matches it will return true;
    public static boolean emailVal(String email) {
        //regex for emails to be like bob@mail.com
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        return pat.matcher(email).matches();

    }

    //When a string of password gets passed it is ran against
    //the regex and if it matches it will return true;
    public static boolean passVal(String password){
        //regex for passwords to have 6-15 characters and at least one character
        //of uppercase, lowercase, number, and symbol of @#$%^&+= example Java#@#8 is true
        String passRegex ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,15}$";
        Pattern pat = Pattern.compile(passRegex);

        return pat.matcher(password).matches();

    }

}

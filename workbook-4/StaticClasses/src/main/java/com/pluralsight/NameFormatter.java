package com.pluralsight;

public class NameFormatter {


    public static String format (String prefix, String firstName, String middleName, String lastName, String suffix){
        StringBuilder userName = new StringBuilder();

        if (!prefix.isEmpty()) {
            userName.append(prefix).append(" ");
        }

        userName.append(lastName);
        userName.append(", ").append(firstName);

        if (!middleName.isEmpty()) {
            userName.append(" ").append(middleName);
        }

        if (!suffix.isEmpty()) {
            userName.append(", ").append(suffix);
        }

        return userName.toString();
    }

    private NameFormatter(){

    };

}

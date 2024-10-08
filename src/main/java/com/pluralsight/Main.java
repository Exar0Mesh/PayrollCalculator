package com.pluralsight;
import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            
            System.out.println("ID, Names, Hours, Pay, PayPerHour");

            while ((input = bufReader.readLine()) != null) {
                String[] lineSplit = input.split(Pattern.quote("|"));
                int id = Integer.parseInt(lineSplit[0]);
                String names = lineSplit[1];
                float hours = Float.parseFloat(lineSplit[2]);
                float pay = Float.parseFloat(lineSplit[3]);
                Employee object = new Employee(id, names, hours, pay);
                System.out.printf(object.getID() + ", ");
                System.out.printf(object.getName() + ", ");
                System.out.printf(object.getHours() + ", ");
                System.out.printf(object.getPayRate() + ", ");
                System.out.println(object.getGrossPay());
            }
            bufReader.close();


        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
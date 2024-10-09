package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner writing = new Scanner(System.in);
            System.out.print("Type in the filename: ");
            String fileName = writing.nextLine();

            FileReader fileReader = new FileReader("src/main/resources/" + fileName);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            System.out.print("Enter the name of the payroll file to create: ");
            String fileCreate = writing.nextLine();
            FileWriter fileWriter = new FileWriter("src/main/resources/" + fileCreate);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            bufWriter.write("id|name|gross pay\n");

            while ((input = bufReader.readLine()) != null) {
                if(input.startsWith("id")) {
                    continue;
                }
                String[] lineSplit = input.split(Pattern.quote("|"));
                int id = Integer.parseInt(lineSplit[0]);
                String names = lineSplit[1];
                double hours = Double.parseDouble(lineSplit[2]);
                double pay = Double.parseDouble(lineSplit[3]);
                Employee object = new Employee(id, names, hours, pay);
                bufWriter.write(object.getEmployeeID() + "|");
                bufWriter.write(object.getName() + "|");
                bufWriter.write(object.getGrossPay() + "\n");
            }
            bufReader.close();

            bufWriter.close();


        } catch (IOException e) {
            System.out.println("Error: An unexpected error occured");
            e.getStackTrace();
            e.printStackTrace();
        }
    }
}

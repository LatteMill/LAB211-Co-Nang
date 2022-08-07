/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.management.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputValidation {

    private static final Scanner scan = new Scanner(System.in);

    public static int getInputOption() {
        //loop while user input correct 
        while (true) {
            System.out.print("> Choose: ");
            String input = scan.nextLine().trim();
            try {
                int option = Integer.parseInt(input);
                //if option is from 1 to 3
                if (option >= 1 && option <= 3) {
                    System.out.println("");
                    return option;
                } else {
                    System.out.println("Please enter from 1 to 3");
                }
            } catch (NumberFormatException e) {
                //if input was empty
                if (input.isEmpty()) {
                    System.out.println("Please input something");
                } else {
                    System.out.println("Please enter a number");
                }
            }
        }
    }

    public static String getInputString(String type, int length) {
        //loop while user input incorrect
        while (true) {
            System.out.print("Enter " + type + ": ");
            String input = scan.nextLine();
            //if user input nothing
            if(input.isEmpty()){
                System.out.println("Please input something");
            }
            //if user enter at least length character and no space
            else if (input.length() < length || input.contains(" ")) {
                System.out.println("You must enter least at " + length + " character, and no space!");
            }
            //if user enter ; character
            else if(input.contains(";")){
                System.out.println("Can not enter ; character");
            }
            else {
                return input;
            }
        }
    }

    private static List<String> getUsernameList(File file) {
        ArrayList usernameList = new ArrayList();
        try {
            Scanner reader = new Scanner(file);
            //while there are still lines in file
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String username = line.split(";")[0];
                usernameList.add(username);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usernameList;
    }

    private static boolean isDuplicate(String username, List<String> usernameList){
        //for every string in list
        for(String name : usernameList){
            //if name is equal to username
            if(name.equals(username))
                return true;
        }
        return false;
    }
    
    public static String getUsername(File file){
        //while user input duplicate name
        while(true){
            String username = getInputString("Username", 5);
            //if file already exist
            if(file.exists()){
                List<String> usernameList = getUsernameList(file);
                //if username already exist
                if(isDuplicate(username, usernameList)){
                    System.out.println("Username is already exist");
                }else{
                    return username;
                }
            }else{
                return username;
            }
        }
    }
    
}

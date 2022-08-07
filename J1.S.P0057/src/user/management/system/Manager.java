/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.management.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Manager {

    private static final File file = new File("user.dat");

    public static void menu() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    private static void writeAccountToFile(String username, String password, File file) {
        
    }

    public static void createAccountProgram() {
        
    }

    private static HashMap<String, String> getAccountMap() {
        
    }

    private static boolean isExistAccount(HashMap<String, String> accountMap, String username, String password) {
        
    }

    public static void loginProgram(){
        S
    }
    

}

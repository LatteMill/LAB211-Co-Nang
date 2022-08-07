/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Scanner;


public class CheckValidation {
    
    public static Scanner SCANNER = new Scanner(System.in);
    
    public static int validArray(){
        //loop while user input invalid
        while(true){
            System.out.print("Enter number of array: ");
            String input = SCANNER.nextLine().trim();
            try{
                int number = Integer.parseInt(input);
                //if numeber is greater than 0
                if(number > 0){
                    return number;
                }else{
                    System.out.println("Please enter a positive number!");
                }
            }catch(NumberFormatException e){
                //if input is empty
                if(input.isEmpty()){
                    System.out.println("Please input something!");
                }else{
                    System.out.println("Invalid input! Please enter a number");
                }
            }
        }
    }

}

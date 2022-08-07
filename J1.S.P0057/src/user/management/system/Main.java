/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.management.system;

/**
 *
 * @author laptopAZ.vn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //loop while user choose exit option
        while(true){
            Manager.menu();
            int option = InputValidation.getInputOption();
            //switch between option
            switch(option){
                case 1:
                    //allow user to run create account program
                    Manager.createAccountProgram();
                    break;
                case 2:
                    //allow user to run login program
                    Manager.loginProgram();
                    break;
                case 3:
                    //exit program
                    return;
            }
        }
    }
    
}

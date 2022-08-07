
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lee.Phuoc
 */
public class Validate {

    static Scanner in = new Scanner(System.in);

    public static String inputString() {
        while (true) {
            String input = in.nextLine().trim();
            // check if string is empty or just space character
            if (input.isEmpty() || input.equals(" ")) {
                System.out.println("Empty");
                System.out.println("Enter again");
            } else {
                return input;
            }
        }
    }

    public static double inputDouble() {
        //loop end when the user input is in right form
        while (true) {
            try {
                double input = Double.valueOf(in.nextLine());
                if (input < 1) {
                    throw new Exception();
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.println("Wrong,you must enter a number");
                System.out.println("Enter the number : ");
            } catch (Exception ex) {
                System.out.println("Wrong,you must enter the number greater than 0");
                System.out.println("Enter the number again: ");
            }
        }
    }

    public static int inputNumberInRange(int min, int max, String msg) {
        //loop end when the user input is in right form
        while (true) {
            try {
                int input = Integer.valueOf(in.nextLine());
                if (input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.println("Wrong,you must enter a number");
                System.out.print("Enter the number : ");
            } catch (Exception ex) {
                System.out.println(msg);
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkItemsExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (id.equalsIgnoreCase(order.getId())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDuplicate(ArrayList<Fruit> lf, String name,
            String origin, double price) {
        for (Fruit fruit : lf) {
            if (name.equalsIgnoreCase(fruit.getFruitName())
                    && origin.equalsIgnoreCase(fruit.getOrigin())
                    && price == fruit.getPrice()) {
                return false;
            }
        }
        return true;
    }

    public static boolean yesNo() {
        System.out.print("\nDo you want to continue: ");
        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            }
            if (input.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input Y/N or y/n");
            System.out.print("Enter again: ");
        }
    }
}

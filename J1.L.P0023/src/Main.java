
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lee.Phuoc
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        ArrayList fruitList = new ArrayList();
        Hashtable<String, ArrayList<Order>> cart = new Hashtable<>();
        while(true){
            int choice = m.menu();
            switch(choice){
                case 1:
                    m.createFruit(fruitList);
                    break;
                case 2:
                    m.viewOrder(cart);
                    break;
                case 3: 
                    m.shopping(fruitList, cart);
                    break;
                case 4:
                    return;
            }
        }
    }
}

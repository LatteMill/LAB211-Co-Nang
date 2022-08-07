
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
public class Manager {

    public int menu() {
        System.out.println("\nFRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping(for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.inputNumberInRange(1, 4, "Please enter between 1 and 4");
        return choice;
    }

    public void createFruit(ArrayList<Fruit> fl) {
        while (true) {
            System.out.print("\nEnter fruit id: ");
            String fruitId = Validate.inputString();
            //if the id exist then return
            if (!Validate.checkIdExist(fl, fruitId)) {
                System.out.println("Id existed");
                return;
            }
            System.out.print("Fruit name: ");
            String name = Validate.inputString();
            System.out.print("Price: ");
            double price = Validate.inputDouble();
            System.out.print("Quantity: ");
            int quantity = Validate.inputNumberInRange(1, Integer.MAX_VALUE,
                    "You must input positive number!!!");
            System.out.print("Origin: ");
            String origin = Validate.inputString();
            //if the fruit have the same name, price and origin then update the quantity
            if (!Validate.checkDuplicate(fl, name, origin, price)) {
                updateQuantityShop(fl, name, quantity);
                System.out.println("Updated " + name + " quantity!!!");
            } else {
                //else create new
                fl.add(new Fruit(fruitId, name, quantity, price, origin));
            }
            if (!Validate.yesNo()) {
                return;
            }
        }
    }

    public void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        if (ht.isEmpty()) {
            System.out.println("There is nothing here '_'");
            return;
        }
        //take out name and order list from the map
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> cart = ht.get(name);
            printOrderList(cart);
        }

    }

    public void shopping(ArrayList<Fruit> fl, Hashtable<String, ArrayList<Order>> lh) {
        if (fl.isEmpty()) {
            System.out.println("\nThere is nothing here '_'");
            return;
        }
        ArrayList<Order> cart = new ArrayList<>();
        while (true) {
            printFruitList(fl);
            System.out.print("\nEnter item: ");
            int item = Validate.inputNumberInRange(1, fl.size(),
                    "Out of items!!!");
            //get fruit by the item buyer insert
            Fruit fruit = getFruitByItems(fl, item);
            String selectedFruit = fruit.getFruitName();
            System.out.println("You selected: " + selectedFruit);
            System.out.print("Enter quantity: ");
            int quantity = Validate.inputNumberInRange(1, fruit.getQuantity(),
                    "There are " + fruit.getQuantity() + " left");
            //minus the quantity after buyer buy selected fruit
            fruit.setQuantity(fruit.getQuantity() - quantity);
            //if there is the same fruit in cart then update it
            if (!Validate.checkItemsExist(cart, fruit.getFruitId())) {
                updateQuantityCustomer(cart, fruit.getFruitId(), quantity);
            } else {
                //else create new one
                cart.add(new Order(fruit.getFruitId(), selectedFruit, fruit.getPrice(), quantity));

            }
            if (!Validate.yesNo()) {
                break;
            }
        }
        printOrderList(cart);
        System.out.println("Enter your name: ");
        String name = Validate.inputString();
        lh.put(name, cart);
        System.out.println("Add successful!!!\n");

    }

    public void printFruitList(ArrayList<Fruit> fl) {
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Items", "Fruit name", "Country", "Price");
        for (Fruit fruit : fl) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f\n", count++, fruit.getFruitName(),
                        fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    public void printOrderList(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order cart : lo) {
            if (cart.getQuantity() != 0) {
                System.out.printf("%-15s%-15d%-15.0f%-15.0f\n", cart.getProduct(), cart.getQuantity(),
                        cart.getPrice(), cart.getPrice() * cart.getQuantity());
            }
            // add to total price after buyer buy a fruit
            total += cart.getPrice() * cart.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public Fruit getFruitByID(ArrayList<Fruit> fl, String id) {
        for (Fruit fruit : fl) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    public Fruit getFruitByItems(ArrayList<Fruit> lf, int item) {
        int countItemsLeft = 1;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                countItemsLeft++;
            }
            if (countItemsLeft - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    public void updateQuantityShop(ArrayList<Fruit> lf, String name, int quantity) {
        for (Fruit fruit : lf) {
            if (name.equalsIgnoreCase(fruit.getFruitName())) {
                fruit.setQuantity(fruit.getQuantity() + quantity);
                return;
            }
        }
    }

    public void updateQuantityCustomer(ArrayList<Order> lo, String id, int quantity) {
        for (Order cart : lo) {
            if (id.equalsIgnoreCase(cart.getId())) {
                cart.setQuantity(cart.getQuantity() + quantity);
                return;
            }
        }
    }
}

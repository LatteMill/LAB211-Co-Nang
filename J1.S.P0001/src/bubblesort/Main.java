/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;


public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //let user enter a number of array
        int number = CheckValidation.validArray();
        //creater random array in number range input
        int[] array = Manage.getArray(number);
        //display unsorted array
        Manage.displayArray("Unsorted array: ", array);
        System.out.println("\n");
        //sort array ascending
        Manage.bubbleSort(array);
        //display sorted array
        Manage.displayArray("Sorted array: ", array);
        System.out.println("\n");
    }
    
}

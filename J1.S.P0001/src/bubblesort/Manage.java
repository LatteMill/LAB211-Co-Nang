/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;
import java.util.Random;


public class Manage {

    public static int[] getArray(int number){
        int[] array = new int[number];
        //loop from first to last index in array
        for(int i = 0; i < array.length; i++){
            array[i] = new Random().nextInt(number);
        }
        return array;
    }
    
    public static void displayArray(String message, int[] array){
        System.out.print(message + Arrays.toString(array));
    }
    
    public static void bubbleSort(int[] array) {
        int size = array.length;
        //loop from first element to the previous element of the last element in array 
        for (int i = 0; i < size - 1; i++) {
            boolean check = false;
            //loop from first element to the previous element of the last unsorted element
            for (int j = 0; j < size - i - 1; j++) {
                //if current element is greater than adjacent element
                if (array[j] > array[j + 1]) {                  
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    check = true;
                }
            }
            //if no pairs were swapped
            if(!check){
                break;
            }
        }      
    }
}

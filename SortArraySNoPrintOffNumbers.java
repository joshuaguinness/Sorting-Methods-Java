
package sort.array.s.no.print.off.numbers;

// Imports
import java.util.Arrays;
import java.util.Scanner;

public class SortArraySNoPrintOffNumbers {

// Methods to do things with/in the arrays    
    
    // Method to print out an array
    public static void print(int[] array) {
        
        // Runs loop to print out items in the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }

    // Method to swap two items in an array
    public static int[] swap(int[] array, int pos1, int pos2) {
        
        // Creates a temporary variable in order to shuffle around the numbers
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;

        return array;
    }

    // Method to check if the array is sorted
    public static boolean sortedCheck(int[] array) {
        
        /* Runs through a loop checking to see if numbers are in order. If numbers 
        are not in order, returns false. If they are in order, returns true. */
        boolean sorted = true;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;

                break;
            }
        }
        return sorted;
    }

    // Method to randomize an array
    public static int[] randomize(int[] array) {
        
        // Creates a random number between 0 - array length
        int randomNumber = (int) (Math.random() * array.length);
        
        /* Swaps each number in the array with a random number from somewhere
        else in the array */
        for (int i = 0; i < array.length; i++) {
            array = swap(array, i, randomNumber);

        }
        return array;
    }

// Methods to sort items in an array from smallest to greatest    
    
    // Method to sort an array using selection sort
    public static int[] selectionSort(int[] array) {
        
        /* Loop to run through every number in the array, changing the set of numbers
        to be compared by the next method every single run */
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minSpot = i;
            
            // Loop to run through a set of numbers to determine the smallest one
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minSpot = j;
                }
            }
            // Swaps next lowest number to its correct spot
            array = swap(array, i, minSpot);
        }
        return array;
    }

    // Method to sort an array using bubble sort    
    public static int[] bubbleSort(int[] array) {

        // Loop to reset the count of the loop below it back to 0
        for (int i = 0; i < array.length - 1; i++) {

            /* Compares every number in an array placing the largest number as far 
            back in the array as possible */
            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    
                    array = swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    // Method to sort an array using bogo sort
    public static int[] bogoSort(int[] array) {
        
        int counter = 0;
        
        // Randomizes an array every loop until it is sorted
        while (sortedCheck(array) == false) {
            
            counter++;
            array = randomize(array);   
        }
        // Prints out how many times it took to sort the array
        System.out.println("\nIt took " + counter + " tries to sort.");
        
        return array;
    }

    // Method to sort an array using insertion sort
    public static int[] insertionSort(int[] array) {
        
        // Moves up a position in the array
        for (int i = 1; i < array.length; i++) {
            
            /* Compares a number, to the number positioned below it. It swaps
            the two if they are out of order, and then further compares numbers 
            below it to check if out of order */
            for (int j = i; j > 0; j--) {

                if (array[j] < array[j - 1]) {

                    array = swap(array, j, j - 1);

                } 
                else {
                    
                    break;
                }
            }
        }
        return array;
    }
    
    // Method to sort an array using count sort
    public static int [] countSort (int[] array){
           
        // Finds the max index of the array
        int max = 0;

        for (int h = 0; h < array.length; h++) {

            if (max < array[h]) {
                max = array[h];
            }
        }

        // Creates a new array used to count how many numbers there are per term 
        int[] countArray = new int[max + 1];

        // Gets how many numbers of each term there is
        for (int j = 0; j < array.length; j++) {

            int temp = array[j];
            countArray[temp]++;
        }

        int counter = 0;
        
        // Writes to the original array with the numbers in order
        for (int k = 0; k < countArray.length; k++) {

            /* Loop that runs through if there is at least one value. If no values
            does not run loop and goes back to first loop */
            for (int m = 0; m < countArray[k]; m++) {

                // Assigns a spot in the array with a number
                array[counter] = k;
                
                counter++;
            }

        }

        return array;
    }

    // Method to sort an array using cocktail sort
    public static int[] cocktailSort(int[] array) {
        for (int i = 0; i < array.length; i++) { //iterate through entire array
            boolean sorted = true; //as far as we know its sorted
            for (int j = i; j < array.length - i - 1; j++) { //iterate through array minus iteration #
                if (array[j] > array[j + 1]) { //if the first of the two terms is bigger
                    swap(array, j, j + 1);
                    sorted = false; //its not sorted
                }
            }
            if (sorted) {
                break;
            }
            sorted = true;
            for (int k = array.length - i - 2; k > 0; k--) {
                //minus two because:
                //   array[array.length] is out of bounds and array[array.length-2] isn't
                //   also the last number in the array has already been dealt with because of the up algorithm
                if (array[k] < array[k - 1]) {
                    swap(array, k, k - 1);
                    sorted = false; //its not sorted
                }
            }
            if (sorted) {
                break;
            }
        }
        return array;
    }
    
        public static int[] mergeSort(int[] myArray){
        int[] sort1, sort2;
        if(myArray.length > 1){
          int[] firstHalf = Arrays.copyOfRange(myArray, 0, myArray.length/2);
          //print(firstHalf);
          sort1 = mergeSort(firstHalf);
          int[] secondHalf = Arrays.copyOfRange(myArray, myArray.length/2, myArray.length);
          //print(secondHalf);
          sort2 = mergeSort(secondHalf);
        }else{
            //System.out.println("All done");
            return myArray;
        }
        
        return merge(sort1, sort2);
    }
     public static int[] merge(int[] array1, int[] array2){
        int i=0;
        int j=0;
        int k=0;
        int[] merged = new int[array1.length + array2.length];
        while(i<array1.length || j<array2.length){
            if(i >= array1.length){
                merged[k] = array2[j];
                j++;
            }else if(j >= array2.length){
                merged[k] = array1[i];
                i++;
            }else if(array1[i] <= array2[j]){
                merged[k] = array1[i];
                i++;
            }else{
                merged[k] = array2[j];
                j++;
            }
            k++;
                  }
        return merged;
    }
   

    // Main method to run the code out of
    public static void main(String[] args) {
        
        // Creates a new scanner and outputs a question for the user
        Scanner kb = new Scanner(System.in);
        System.out.print("How many numbers do you want?  ");
        
        // Creates an integer of a size decided by the user
        int size = kb.nextInt();
        int[] array = new int[size];
        
        // Fills an array with random numbers in a certain range designated by the user
    
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * size) + 1;
        }
        
        // Outputs the array to sort
        
        System.out.print("\nUnsorted array: ");
        //print(array);
        
        /* Outputs instruction to ask user what sorting method to use and then
        runs that sorting method */
        System.out.println("\nWhich sorting method would you like to use?\n");
        System.out.println("1. Selection Sort");
        System.out.println("2. Bubble Sort");
        System.out.println("3. Bogo Sort");
        System.out.println("4. Insertion Sort");
        System.out.println("5. Count Sort");
        System.out.println("6. Cocktail Sort");
        System.out.println("7. Merge Sort");
        
        int sortingMethod = kb.nextInt();
       
        // Starts the timer
        long tStart = System.currentTimeMillis();
        
        switch (sortingMethod) {
            case 1:
                array = selectionSort(array);
                break;
            case 2:
                array = bubbleSort(array);
                break;
            case 3:
                array = bogoSort(array);
                break;
            case 4:
                array = insertionSort(array);
                break;
            case 5:
                array = countSort(array);
                break;
            case 6:
                array = cocktailSort(array);
                break;
            case 7:
                array = mergeSort(array);
                break;
            default:
                break;
        }
        
        //Figure out how much time has passed
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        
        // Prints out the final array
        System.out.print("\nSorted array: ");
        print(array);
        
        System.out.println("It sorted in " + elapsedSeconds + " seconds");

    }
}

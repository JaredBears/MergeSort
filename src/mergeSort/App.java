package mergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numArray = toArray(sc.nextLong());
        
        int[] sortedArray = mergeSort(numArray);

        System.out.println(Arrays.toString(sortedArray));
        
        sc.close();

    }

    private static int[] mergeSort(int[] numArray) {
        int[] result = new int[numArray.length];
        /*
         * base case if there are two or fewer entries
         */
        if(numArray.length == 2) {
            if(numArray[1] > numArray[0]) {
                return numArray;
            } else {
                result[0] = numArray[1];
                result[1] = numArray[0];
                return result;
            }
            
        } else if(numArray.length <= 1) {
            return numArray;
        }
        
        /*
         * split array into two roughly even arrays
         */
        int half = numArray.length/2;
        
        int[] firstHalf = new int[half];
        int[] secondHalf = new int[half + numArray.length%2];
        
        for(int i = 0; i < numArray.length; i++) {
            if(i < half) {
                firstHalf[i] = numArray[i];
            } else {
                secondHalf[i - half] = numArray[i];
            }
        }
        
        /*
         * recursive sorting calls
         */
        int[] sortedFirst = mergeSort(firstHalf);
        int[] sortedSecond = mergeSort(secondHalf);
        
        /*
         * merging
         */
        int firstCount = 0;
        int secondCount = 0;
        
        for(int i = 0; i < result.length; i++) {
            if (firstCount >= sortedFirst.length && secondCount < sortedSecond.length) {
                result[i] = sortedSecond[secondCount++];
            } else if (firstCount < sortedFirst.length && secondCount >= sortedSecond.length) {
                result[i] = sortedFirst[firstCount++];
            } else if(sortedFirst[firstCount] <= sortedSecond[secondCount]) {
                result[i] = sortedFirst[firstCount++];
            } else {
                result[i] = sortedSecond[secondCount++];
            }
        }
        
        return result;
    }

    private static int[] toArray(long x) {
        String xString = Long.toString(x);
        int[] result = new int[xString.length()];
        
        for(int i = 0; i < xString.length(); i++) {
            result[i] = Character.getNumericValue(xString.charAt(i));
        }
        
        return result;
    }

}

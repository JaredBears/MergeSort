package mergeSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/resources/int_list.txt");
        Scanner sc = new Scanner(file);
        
        int counter = 1;
        int[] numArray = new int[1];
        
        while(sc.hasNextLine()) {
            if(counter == 1) {
                numArray = new int[Integer.parseInt(sc.nextLine())];
            } else {
                numArray[counter-2] =  Integer.parseInt(sc.nextLine());
            }
            counter++;
        }
        
        IntMerger mergeSortArray = new IntMerger(numArray);
        mergeSortArray = Merger.mergeSort(mergeSortArray);
        
        IntMerger quickSortArray = new IntMerger(numArray);
        QuickSort.quickSort(quickSortArray);
        
        //System.out.println(Arrays.toString(mergeSortArray.fullArray));
        System.out.println("Merge Sort Inversions: " + mergeSortArray.inversions);
        
        System.out.println(Arrays.toString(quickSortArray.fullArray));
        System.out.println("Quick Sort Comparisons: " + quickSortArray.comparisons);
        
        sc.close();

    }

}

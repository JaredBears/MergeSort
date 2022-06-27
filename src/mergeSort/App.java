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
        
        IntMerger sortArray = new IntMerger(numArray);
        sortArray = Merger.mergeSort(sortArray);
        
        System.out.println(Arrays.toString(sortArray.fullArray));
        System.out.println(sortArray.inversions);
        
        sc.close();

    }

}

package mergeSort;

public class IntMerger {
    
    int[] fullArray; 
    long inversions;
    
    IntMerger(int[] fullArray) {
        this.fullArray = fullArray;
        this.inversions = 0;
    }
    
    IntMerger(int[] fullArray, long inversions){
        this.fullArray = fullArray;
        this.inversions = inversions;
    }
}

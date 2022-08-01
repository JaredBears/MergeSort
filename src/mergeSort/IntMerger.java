package mergeSort;

public class IntMerger {
    
    int[] fullArray; 
    long inversions;
    long comparisons;
    
    IntMerger(int[] fullArray) {
        this.fullArray = fullArray;
        this.inversions = 0;
        this.comparisons = 0;
    }
    
    IntMerger(int[] fullArray, long inversions, long comparisons){
        this.fullArray = fullArray;
        this.inversions = inversions;
        this.comparisons = comparisons;
    }
}

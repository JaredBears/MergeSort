package mergeSort;

public class Merger {

    public static IntMerger mergeSort(IntMerger sortArray) {
        IntMerger result = new IntMerger(new int[sortArray.fullArray.length]);
        IntMerger left;
        IntMerger right;
        
        /*
         * base case if there is one entry
         */
        
        if(sortArray.fullArray.length <= 1) {
            return sortArray;
        }
        
        /*
         * split array into two roughly even arrays
         */
        
        int half = sortArray.fullArray.length/2;
        
        left = new IntMerger(new int[half]);
        right = new IntMerger(new int[half + sortArray.fullArray.length%2]);
        
        for(int i = 0; i < sortArray.fullArray.length; i++) {
            if(i < half) {
                left.fullArray[i] = sortArray.fullArray[i];
            } else {
                right.fullArray[i - half] = sortArray.fullArray[i];
            }
        }
        
        /*
         * recursive sorting calls
         */
        
        left = Merger.mergeSort(left);
        right = Merger.mergeSort(right);
        
        /*
         * merging
         */
        int firstCount = 0;
        int secondCount = 0;
        
        for(int i = 0; i < result.fullArray.length; i++) {
            if (firstCount >= left.fullArray.length && secondCount < right.fullArray.length) {
                result.fullArray[i] = right.fullArray[secondCount++];
            } else if (firstCount < left.fullArray.length && secondCount >= right.fullArray.length) {
                result.fullArray[i] = left.fullArray[firstCount++];
            } else if(left.fullArray[firstCount] <= right.fullArray[secondCount]) {
                result.fullArray[i] = left.fullArray[firstCount++];
            } else {
                result.fullArray[i] = right.fullArray[secondCount++];
                result.inversions += left.fullArray.length - firstCount;
            }
        }
        
        result.inversions += left.inversions + right.inversions;
        
        return result;
    }
    
}

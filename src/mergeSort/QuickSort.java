package mergeSort;

public class QuickSort {
  
  public static void quickSort(IntMerger quickSortArray) {
    if(quickSortArray.fullArray.length == 1) {
      return;
    }
    
    int index = partition(quickSortArray, 0, quickSortArray.fullArray.length);
    quickSort(quickSortArray, 0, index-1);
    quickSort(quickSortArray, index+1, quickSortArray.fullArray.length);
  }

  public static void quickSort(IntMerger quickSortArray, int l, int r) {
    if(l < r) {
      int index = partition(quickSortArray, l, r);
      quickSort(quickSortArray, l, index);
      quickSort(quickSortArray, index+1, r);
    }
    
  }

  
  private static int partition(IntMerger quickSortArray, int l, int r) {
    int pivotIndex = choosePivot(quickSortArray, l, r);
    swap(quickSortArray, l, pivotIndex);
    
    int pivot = quickSortArray.fullArray[l];
    int i = l + 1;
    for(int j = l + 1; j < r; j++) {
      if(quickSortArray.fullArray[j] < pivot) {
        swap(quickSortArray, i, j);
        i++;
      }
    }
    
    swap(quickSortArray, l, i-1);
    
    quickSortArray.comparisons += (r - l) - 1;
    
    return i-1;
    
  }
  
  private static void swap(IntMerger quickSortArray, int i, int j) {
    int swap = quickSortArray.fullArray[i];
    quickSortArray.fullArray[i] = quickSortArray.fullArray[j];
    quickSortArray.fullArray[j] = swap;
  }
  
  private static int choosePivot(IntMerger quickSortArray, int l, int r) {
    int middle = ((r - l) / 2) + ((r - l) % 2);
    
    if((quickSortArray.fullArray[middle] > quickSortArray.fullArray[r-1] && quickSortArray.fullArray[middle] < quickSortArray.fullArray[l]) || (quickSortArray.fullArray[middle] > quickSortArray.fullArray[l] && quickSortArray.fullArray[middle] < quickSortArray.fullArray[r-1])) {
      return middle;
    } else if((quickSortArray.fullArray[r-1] > quickSortArray.fullArray[middle] && quickSortArray.fullArray[r-1] < quickSortArray.fullArray[l]) || (quickSortArray.fullArray[r-1] < quickSortArray.fullArray[middle] && quickSortArray.fullArray[r-1] > quickSortArray.fullArray[l])) {
      return r-1;
    } else {
      return l;
    }
  }

}

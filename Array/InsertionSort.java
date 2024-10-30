package leetcodeProblems.Array;

public class InsertionSort {
    public void insertionSort(int arr[], int n)
    {
        for(int i=1; i<n; i++){
            int key = arr[i];
            int pos = i-1;

            while (pos >= 0 && arr[pos] > arr[key]){
                arr[pos+1] = arr[pos];
                pos --;
            }
            arr[pos+1] = key;
        }
    }
}

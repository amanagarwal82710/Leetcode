package leetcodeProblems.Array;

public class MergeSort {
    public int[] mergeSort(int[] arr1, int[] arr2){
        int i = 0 , j =0, k= 0;
        int[] arr3 = new  int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length){
            if(arr2[j] < arr1[i]){
                arr3[k] = arr2[j];
                j++;
            }
            else {
                arr3[k] = arr1[i];
                i++;
            }
            k++;
        }

        while (i<arr1.length){
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        while (j<arr2.length){
            arr3[k] = arr1[j];
            j++;
            k++;
        }
        return arr3;
    }
}

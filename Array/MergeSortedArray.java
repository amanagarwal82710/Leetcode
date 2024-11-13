package leetcodeProblems.Array;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m+n];

        int si =0;
        int ei= m;
        int x =0;
        while(si<m && ei<n){
            if(nums1[si] > nums2[ei]){
                merged[x] = nums2[ei];
                x++;
                ei++;
            }
            else {
                merged[x] = nums1[si];
                si++;
                x++;
            }
        }

        while (si < m){
            merged[x] = nums1[si];
            x++;
            si++;
        }

        while (ei < n){
            merged[x] = nums1[ei];
            x++;
            ei++;
        }
    }
}

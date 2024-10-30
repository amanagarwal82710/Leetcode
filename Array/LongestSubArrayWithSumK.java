package leetcodeProblems.Array;

public class LongestSubArrayWithSumK {

    public static int lenOfLongSubarr(int A[], int N, int K) {
        int j =0;
        int i=0;
        int sum = 0;
        int max = 0;

       while (j < N){
           sum = sum + A[j];

           if(sum < K){
               j ++;
           } else if (sum == K) {
               max = Math.max(max, i-j+1);
           }
           else if(sum > K){
               while (sum > K){
                   sum = sum - A[i];
                   i++;
                   }
               j++;
               }
       }
        return max;
    }

    public int findPeakElement(int[] nums) {

        int low =0;
        int high = nums.length -1;
        while(low < high){
            int mid = (low+high)/2;

            if(nums[mid] > nums[mid+1]){
                high = mid;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
}

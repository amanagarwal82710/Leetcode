package leetcodeProblems.BinarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int sum =0;
        int n= nums.length;
        int max = Integer.MIN_VALUE;

        for(int i: nums){
            sum += i;
            max = Math.max(max,i);
        }

        int low = max;
        int high = sum;

        while (low <= high){
            int mid = (low+high)/2;
            int partitions = possible(mid,nums);

            if(partitions > k){
                low = mid+1;
            }
            else {
               high = mid-1;
            }
        }

        return low;
    }

    private int possible(int mid, int[] nums) {
        int partition = 1;
        int sum =0;
        for(int i: nums){
            if(sum + i <= mid){
                sum += i;
            }
            else {
                sum = i;
                partition++;
            }

        }

        return partition;
    }
}

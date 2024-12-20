package leetcodeProblems.Array;

public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum =0;
        int min = Integer.MAX_VALUE;
        int j=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            while (sum >= target){
                min = Math.min(min,i-j+1);
                sum -= nums[j];
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }

        return min;
    }
}

package leetcodeProblems;

public class MinSizeSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {

       int n= nums.length;
       int sum  =0;
       int min = Integer.MAX_VALUE;
       int i=0;
       int j=0;
       while (i<n){
          sum += nums[i];
          while (sum >= target){
              sum -= nums[j];
              min = Math.min(i-j+1, min);
              j++;
          }
          i++;
       }

        if(min > target){
            return 0;
        }
        return min;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(target,nums);
        System.out.println(result);
    }
}

package leetcodeProblems.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSubArraySUm {

    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
           sum += nums[i];
           int rem = sum%k;
           if(rem <0){
               rem = rem+k;
           }
           if(map.containsKey(rem)){
               if(i-map.get(rem) > 1){
                   return true;
               }
           }

           else {
               map.put(rem, i);
           }
        }
        return false;

    }

    public static void  main(String[] args){
        int[] nums = {23,2,6,4,7};
        System.out.println(checkSubarraySum(nums,13));
    }


}

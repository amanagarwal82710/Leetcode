package leetcodeProblems.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] %2 != 0){
                nums[i] = 1;
            }
            else {
                nums[i] = 0;
            }
        }
        int cnt =0;

        int prefixSum =0;
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            cnt += map.getOrDefault(prefixSum-k,0);
            map.put(prefixSum,1);

        }

        return cnt;
    }

}

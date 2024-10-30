package leetcodeProblems.Array;

import java.util.HashMap;
import java.util.Map;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        Map<Integer,Integer> pi = new HashMap<>();
        Map<Integer,Integer> ni = new HashMap<>();

        int iIndex = 0;
        int jIndex = 1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                pi.put(iIndex,nums[i]);
                iIndex += 2;
            }
            else {
                pi.put(jIndex,nums[i]);
                jIndex += 2;
            }
        }


        for (int j=0; j<n; j++){
            if(j%2 == 0){
                nums[j] = pi.get(j);
            }
            else {
                nums[j] = pi.get(j);
            }
        }

        return nums;
    }
}

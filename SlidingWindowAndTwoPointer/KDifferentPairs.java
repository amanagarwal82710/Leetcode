package leetcodeProblems.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {
    public int findPairs(int[] nums, int k) {
        int cnt =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i: nums){
            if(k == 0){
                if(map.get(i) >= 2){
                    cnt++;
                }
            }
            else {
                if(map.containsKey(i+k) && map.get(i) == 1){
                    cnt++;
                }
                else {
                    if(map.containsKey(i+k)){
                        cnt++;
                        map.remove(i);
                    }
                }
            }
        }

        return cnt;
    }
}

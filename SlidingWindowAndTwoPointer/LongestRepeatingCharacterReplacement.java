package leetcodeProblems.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int r =0, l = 0;
        int maxF= 0;
        int maxLen =0;
        Map<Character,Integer> map = new HashMap<>();
        while (r <= s.length()){

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxF = Math.max(maxF,map.get(s.charAt(r)));
            if((r-l+1) - maxF >k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(r), 0)-1);
                maxF = 0;
                l++;
            }
            if((r-l+1) - maxF <=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;

        }


        return maxLen;
    }
}

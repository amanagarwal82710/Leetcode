package leetcodeProblems.Strings;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> freq = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for (int value : freq.values()) {
                    max = Math.max(max, value);
                    min = Math.min(min, value);
                }
                ans += max - min;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String s = "aabcb";
        beautySum(s);

    }
}

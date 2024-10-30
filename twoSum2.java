package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class twoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i=0; i<n; i++){
            if(!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i + 1);
            }

            else{
                return new int[]{map.get(numbers[i]), i+1};
            }
        }
        return numbers;
    }
}

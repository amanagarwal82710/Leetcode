package leetcodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class RankOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: arr){
            priorityQueue.add(i);
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int count =0;



        for(int i=0; i<ans.length; i++){
            if(map.containsKey(priorityQueue.peek())){
                if(map.get(priorityQueue.peek()) == 1){
                    count = count + 1;
                    ans[i] = count;
                    priorityQueue.poll();
                }
                else{
                    count = count + 1;
                    ans[i] = count;
                    count -= 1;
                    map.put(priorityQueue.peek(), map.getOrDefault(priorityQueue.peek(), 0)-1);
                    priorityQueue.poll();
                }
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int maxSum = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (b_pointer < s.length()) {
            if (!hashSet.contains(s.charAt(b_pointer))) {
                hashSet.add(s.charAt(b_pointer));
                maxSum = Math.max(hashSet.size(), maxSum);
                b_pointer++;
            } else {
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums= {40,10,20,30};
        int [] result  = arrayRankTransform(nums);
        System.out.println(Arrays.toString(result));
    }
}

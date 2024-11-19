package leetcodeProblems.StackQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n-1],-1);
        stack.push(nums2[n-1]);
        for(int i=n-2; i>=0; i--){
            if(!stack.isEmpty() && stack.peek() > nums2[i]){
                map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
                continue;
            }


            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }
            else {
                map.put(nums2[i],stack.peek());
            }

            stack.push(nums2[i]);


        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

}

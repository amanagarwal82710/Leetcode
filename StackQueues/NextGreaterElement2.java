package leetcodeProblems.StackQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=(2*n)-1; i>=0; i--){
            while (!st.isEmpty() && nums[i%n]> st.peek()){
                st.pop();
            }
            if(!st.isEmpty() && i<n){
                ans[i] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
}

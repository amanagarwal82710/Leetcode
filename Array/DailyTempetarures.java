package leetcodeProblems.Array;

import java.util.Stack;

public class DailyTempetarures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int indx = stack.pop();
                ans[indx] = i-indx;
            }
            stack.push(i);
        }
        return ans;


    }
}

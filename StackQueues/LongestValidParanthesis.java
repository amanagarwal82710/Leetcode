package leetcodeProblems.StackQueues;

import java.util.Stack;

public class LongestValidParanthesis {

    public int longestValidParentheses(String s) {
        int open = 0;
        int close =0;
        int max =0;
        int ans  =0;
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }
            else {
                close++;
            }

            if(open == close){
                max = Math.max(max,open+close);

            }
            if(close > open){
                open = 0;
                close = 0;
            }
        }
            for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i) == '('){
                    open++;
                }
                else {
                    close++;
                }

                if(open == close){
                    ans = Math.max(ans,open+close);

                }
                if(close > open){
                    open = 0;
                    close = 0;
                }
            }


        return Math.max(max,ans);
    }

    public int longestValidParenthesesUsingStack(String s){
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        stack.push(-1);
        int max = 0;
//        int length = 0;
//        for(char c: s.toCharArray()){
//            if(c == '('){
//                stack.push(c);
//            }
//
//            else {
//                if(!stack.isEmpty() && stack.pop() == ')'){
//                    length += 2;
//                }
//            }
//        }
//        return length;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }

            else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

}

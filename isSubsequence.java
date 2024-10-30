package leetcodeProblems;

import java.util.Stack;

public class isSubsequence {

    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            stack.push(c);
        }

        for(int i=n-1; i>=0; i--){
            if(!stack.isEmpty() && stack.contains(t.charAt(i))){
                if(stack.peek() != t.charAt(i)){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}

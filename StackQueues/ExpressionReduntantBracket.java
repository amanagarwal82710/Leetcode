package leetcodeProblems.StackQueues;

import java.util.Stack;

public class ExpressionReduntantBracket {
    public static boolean check(String s){
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                char top = st.pop();
                boolean flag = true;
                while (top != '('){
                    if(top == '+' || top == '-' || top == '*' || top == '/'){
                        flag = false;
                    }
                   top = st.pop();
                }
                if(flag){
                    return true;
                }
            }

            else {
                st.push(c);
            }
        }

        return false;
    }
}

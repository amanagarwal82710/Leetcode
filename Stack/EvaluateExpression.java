package leetcodeProblems.Stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluateExpression {

    public int evalRPN(String[] tokens) {
        int n= tokens.length;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(!Objects.equals(tokens[i], "+") && !Objects.equals(tokens[i], "-") && !Objects.equals(tokens[i], "*") && !Objects.equals(tokens[i], "/")){
                stack.push(Integer.parseInt(tokens[i]));
            }

            else {
                if(Objects.equals(tokens[i], "+")){
                    int x1 = stack.pop();
                    int x2 =  stack.pop();
                    stack.push(x2+x1);
                }

                if(Objects.equals(tokens[i], "-")){
                    int x1 = stack.pop();
                    int x2 =  stack.pop();
                    stack.push(x2-x1);
                }

                if(Objects.equals(tokens[i], "*")){
                    int x1 = stack.pop();
                    int x2 =  stack.pop();
                    stack.push(x2*x1);
                }

                if(Objects.equals(tokens[i], "/")){
                    int x1 = stack.pop();
                    int x2 =  stack.pop();
                    stack.push(x2/x1);
                }
            }
        }
        return stack.peek();
    }
}

package leetcodeProblems.Greedy;

public class ValidParanthesisString {

    public static boolean checkValidString(String s) {
        int min =0;
        int max =0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                min += 1;
                max += 1;
            }

           else if(ch == ')'){
                min -= 1;
                max -= 1;
            }
            else {
                min -= 1;
                max += 1;

            }

            if(min < 0){
                min =0;
            }

            if(max <0){
                return false;
            }
        }

        return (min == 0);
    }


    public static void main(String[] args){
        String s = "(";
        checkValidString(s);
    }
}

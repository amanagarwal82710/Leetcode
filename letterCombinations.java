package leetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {

   public static void solve(int indx, String digits, StringBuilder temp, Map<Character, String> map, List<String> result){
       if(indx>= digits.length()){
           result.add(temp.toString());
           return;
       }

       char ch = digits.charAt(indx);
       String s = map.get(ch);
       for(int i=0; i<s.length(); i++){
           temp.append(s.charAt(i));
           solve(indx+1,digits,temp,map, result);
           temp.deleteCharAt(temp.length()-1);
       }
   }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        List<String> result = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        solve(0, digits, temp, mp, result);

        return result;
    }

    public static void main(String[] args){
        String s = "23";
        List<String> list = letterCombinations(s);
        System.out.println(list);
    }
}

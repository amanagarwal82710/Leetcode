package leetcodeProblems.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringCompression2 {

    public int getLengthOfOptimalCompression(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count =1;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else {
                sb.append(s.charAt(i-1));
                if(count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
            i++;
        }
        sb.append(s.charAt(i-1));
        if(count>1){
            sb.append(count);
        }

        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }

        String str = sb.toString();
        int j=0;
        while(j<str.length()){
            if(!Character.isDigit(str.charAt(j+1)) && k>0){
                sb.deleteCharAt(j);
                k -=1;
                j += 1;
            }
            else{
                j+= 2;
            }
        }

        if(k> 1 && Character.isLetter(sb.toString().charAt(sb.length()-1))){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
//        if()




        return sb.length();
    }
}

package leetcodeProblems.Strings;

import java.util.Arrays;

public class StringCompression1 {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        int count =1;
        int i=1;
        while(i<chars.length){
            if(chars[i] == chars[i-1]){
                count++;
            }
            else {
                sb.append(chars[i - 1]);
                if(count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
            i++;
        }
        sb.append(chars[i-1]);
        if(count>1){
            sb.append(count);
        }
        for(int j=0; j<sb.toString().length(); j++){
            if(chars[j] != sb.toString().charAt(j)){
                chars[j] = sb.toString().charAt(j);
            }
        }
        return sb.toString().length();
    }
}

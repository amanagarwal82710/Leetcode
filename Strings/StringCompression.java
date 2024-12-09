package leetcodeProblems.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public int compress(char[] chars) {
        int ans =0;


        for(int i=0; i< chars.length; i++){
            char letter = chars[i];
            int count =0;
            while (i<chars.length && chars[i] == letter){
                ++count;
                ++i;
            }
            chars[ans++] = letter;
            if(count>1){
                String s = String.valueOf(count);
                for(char c: s.toCharArray()){
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}

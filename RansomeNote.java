package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mag = new HashMap<>();
        for( char c: magazine.toCharArray()){
            mag.put(c, mag.getOrDefault(c,0)+1);
        }

        for(char c: ransomNote.toCharArray()){
            if(mag.containsKey(c)) {
                if (mag.get(c) == 1) {
                    mag.remove(c);
                }
                else if(mag.get(c) > 1) {
                    mag.put(c, mag.getOrDefault(c, 0) - 1);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return true;
    }


}

package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i)) && !map.containsKey(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
            }
            else {
                if(map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
                if(map.containsKey(t.charAt(i))){
                    if (map.get(t.charAt(i)) != s.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

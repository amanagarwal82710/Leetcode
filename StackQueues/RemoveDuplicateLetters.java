package leetcodeProblems.StackQueues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        StringBuilder newS = new StringBuilder();

        for(int i=0; i<n; i++){
            map.put(s.charAt(i),i);
        }

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                continue;
            }
            while (newS.length() > 0 && c < newS.charAt(newS.length()-1) && map.get(newS.charAt(newS.length()-1)) > i){
                set.remove(newS.charAt(newS.length()-1));
                newS.deleteCharAt(newS.charAt(newS.length()-1));
            }

            set.add(c);
            newS.append(c);
        }

        return newS.toString();
    }
}

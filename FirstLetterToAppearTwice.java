package leetcodeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        for(char c: s.toCharArray()){
            if(!hashSet.contains(c)){
                hashSet.add(c);
            }
            else{
                return c;
            }
        }

        return 0;
    }
}

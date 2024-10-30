package leetcodeProblems.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class SubstringsContainingABC {

    public int numberOfSubstrings(String s) {
        int cnt =0;

       Map<Character,Integer> map = new HashMap<>();
       map.put('a',-1);
       map.put('b',-1);
       map.put('c',-1);
       for(int i=0; i<s.length(); i++){
           if(map.get('a') != -1 && map.get('b') != -1 && map.get('c') != -1){
               cnt += 1 + Math.min(Math.min(map.get('a'),map.get('b')),map.get('c'));
           }
           map.put(s.charAt(i),i);
       }

        return cnt;
    }
}

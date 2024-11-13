package leetcodeProblems.Greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
       int cnt =0;
       int i=0;
       int j=0;
       while (i < s.length && j< g.length){
           if(s[i] >= g[j]){
               cnt++;
               i++;j++;
           }
           else {
               j++;
           }
       }
        return cnt;
    }
}

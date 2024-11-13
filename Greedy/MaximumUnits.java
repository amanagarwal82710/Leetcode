package leetcodeProblems.Greedy;

import java.util.Arrays;

public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int res=0;
        int count =0;
        for(int[] t: boxTypes){
            count = Math.min(t[0],truckSize);
            res += count*t[1];
            truckSize -= count;
        }

        return res;
    }
}

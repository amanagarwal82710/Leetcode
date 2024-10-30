package leetcodeProblems;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int n= ratings.length;
        int total = 0;
      int[] leftCandy = new int[ratings.length];
      int[] rightCandy = new int[ratings.length];
        Arrays.fill(leftCandy,1);
        Arrays.fill(rightCandy, 1);

        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                leftCandy[i] = leftCandy[i-1] + 1;
            }
        }

        for(int i=n-2; i>= 0; i--){
            if(ratings[i] > ratings[i+1]){
                rightCandy[i] = rightCandy[i+1] + 1;
            }
        }

        for(int i=0; i<n; i++){
            total += Math.max(leftCandy[i], rightCandy[i]);
        }
        return total;
    }
}

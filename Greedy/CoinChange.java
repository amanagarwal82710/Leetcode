package leetcodeProblems.Greedy;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count =0;
        if(amount == 0){
            return 0;
        }

      for(int i=coins.length-1; i>=0; i--){
          while (coins[i] <= amount){
              count++;
              amount -= coins[i];
          }
      }
        return count>0 ? count:-1;
    }
}

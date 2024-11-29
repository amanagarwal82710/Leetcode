package leetcodeProblems.Array;

public class SellStocks {

    public int maxProfit(int[] prices) {
       int max =0;
       int n = prices.length;
       int buyPrice = prices[0];

       for(int i=1; i<n; i++){
           if(buyPrice > prices[i]){
               buyPrice = prices[i];
           }

           max = Math.max(max , prices[i]-buyPrice);
       }
        return max;
    }
}

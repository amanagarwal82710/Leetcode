package leetcodeProblems.Array;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i=2; i*i<n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int cnt =0;
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                cnt++;
            }
        }


        return cnt;
    }
}

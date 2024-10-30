package leetcodeProblems.BinarySearch;

public class MinimumBouqets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int max = 0;
        int min =0;
        if(m*k > n){
            return -1;
        }

        for(int i: bloomDay){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int low = min;
        int high = max;
        while (low <= high){
            int mid = (low+high)/2;
            if(possible(mid,bloomDay,m,k)){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return  low;



    }

    private boolean possible(int mid, int[] bloomDay, int m, int k) {
        int noOfBoq= 0;
        int n = bloomDay.length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i] <= mid){
                cnt ++;
            }
            else {
                noOfBoq += cnt/k;
                cnt = 0;
            }
        }
        noOfBoq += cnt/k;
        return noOfBoq>=m;
    }
}

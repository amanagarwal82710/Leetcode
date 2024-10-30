package leetcodeProblems.SlidingWindowAndTwoPointer;

public class MaxPointsCards {

    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int max =Integer.MIN_VALUE ;
        int n = cardPoints.length;
        int rIndex = n-1;
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        max = leftSum;
        for(int i=k-1; i>=0; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rIndex];
            max = Math.max(max,(leftSum+rightSum));

        }
        return max;
    }
}

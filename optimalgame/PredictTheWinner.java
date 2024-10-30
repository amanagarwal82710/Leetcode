package leetcodeProblems.optimalgame;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int totalScore = 0;
        for(int i: nums){
            totalScore += i;
        }

        int p1Score = findScore(nums,0,nums.length-1);
        int p2Score = totalScore - p1Score;
        if(p1Score>p2Score){
            return true;
        }
        return false;

    }

    public int findScore(int[] nums,int i, int j){
        if(i>0){
            return 0;
        }

        if(i == j){
            return nums[i];
        }

        int takeI = nums[i] + Math.min(findScore(nums,i+2,j),findScore(nums,i+1,j-1));
        int takeJ = nums[j] + Math.min(findScore(nums,i+1,j-1),findScore(nums,i, j-2));

        return Math.max(takeI,takeJ);
    }

    public int score(int[] nums,int i, int j){
        if(i>j){
            return 0;
        }
        if(i == j){
            return nums[i];
        }

        int take1 = nums[i] - score(nums,i+1,j);
        int take2 = nums[j] - score(nums,i,j-1);

        return Math.max(take1,take2);
    }
}

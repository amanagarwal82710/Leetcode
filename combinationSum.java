package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> set = new ArrayList<>();
        func(candidates,target,set,0,0);
        return list;

    }

    public void func(int[] candidates, int target,  List<Integer> set, int currSum, int start){
        if(start >= candidates.length || currSum > target){
            return;
        }

        if(currSum == target){
            list.add(new ArrayList<>(set));
            return;
        }
        for(int i= start; i<candidates.length; i++){
            set.add(candidates[i]);
            func(candidates,target,set,currSum+candidates[i],i);
            set.remove(set.size()-1);
        }
    }
}

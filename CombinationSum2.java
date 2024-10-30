package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates,target,list,set,0,0);
        return list;

    }

    public static void func(int[] candidates, int target, List<List<Integer>> list, List<Integer> set, int currSum, int indx){
        if(currSum > target){
            return;
        }

        if(currSum == target){
            list.add(new ArrayList<>(set));
            return;
        }

        for(int i= indx; i<candidates.length; i++){
            if(i>indx && candidates[i] == candidates[i-1]){
                continue;
            }
            set.add(candidates[i]);
            func(candidates,target,list,set,currSum+candidates[i],i+1);
            set.remove(set.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = {10,1,2,7,6,1,5};
        int k = 8;
        List<List<Integer>> list = combinationSum2(nums,k);
        System.out.println(list);

    }
}

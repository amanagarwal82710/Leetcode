package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length];
        func(nums,list,set,booleans);
        return list;
    }

    public void func(int[] nums, List<List<Integer>> list, List<Integer> set, boolean[] booleans){
        if(set.size() == nums.length && !list.contains(set)){
            list.add(new ArrayList<>(set));
            return;
        }
        for(int i= 0; i<nums.length; i++){
            if(booleans[i]){
                continue;
            }
            booleans[i] = true;
            set.add(nums[i]);
            func(nums,list,set,booleans);
            booleans[i] = false;
            set.remove(set.size()-1);
        }
    }
}

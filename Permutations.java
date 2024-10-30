package leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Func(res,path,nums);
        return res;
    }

    public static void Func(List<List<Integer>> list, List<Integer> path, int[] nums){
        if(path.size() == nums.length){
            list.add(new ArrayList<>(path));
        }
        for(int i=0; i<nums.length; i++){
            if(path.contains(nums[i])){
                continue;
            }

            path.add(nums[i]);
            Func(list,path,nums);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(list);
    }
}

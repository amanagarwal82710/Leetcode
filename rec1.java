package leetcodeProblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class rec1 {

//    Input:
//    regions = [
//            ["Earth","North America","South America"],
//            ["North America","United States","Canada"],
//            ["United States","New York","Boston"],
//            ["Canada","Ontario","Quebec"],
//            ["South America","Brazil"]
//            ],
//    region1 = "Quebec",
//    region2 = "New York"
//
//    Output: "North America"


    public String findCommonRegion(List<List<String>> regions, String region1, String region2){
        Map<String, String> map = new HashMap<>();

        for(List<String> list: regions){
            for(int i= list.size()-1; i>= 0; i--){
                map.put(list.get(i), list.get(0));
            }
        }
        String s = map.get(region1);





    }
PriorityQueue<Integer> pq;

    public void findKthLargest(int[] nums, int k){

       pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }

    }

    public void add(int val){
        if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
    }


}

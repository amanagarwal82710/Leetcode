//package leetcodeProblems;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Stack;
//
//public class Dsa {
//
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMaxHeight = new int[n];
//        int[] rightMaxHeight = new int[n];
//        leftMaxHeight[0] = height[0];
//        for(int i=1; i<n; i++){
//            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1], height[i]);
//        }
//        rightMaxHeight[n-1]= height[n-1];
//        for(int i= n-2; i>=0; i--){
//            rightMaxHeight[i] = Math.max(rightMaxHeight[i+1],height[i]);
//        }
//        int max_height = 0;
//        for(int i=0; i<n; i++){
//            max_height += (Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i]);
//        }
//
//        return max_height;
//    }
//
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int n=nums.length;
//        for(int i=0; i<n; i++){
//            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//        }
//        for(int i=0; i<n; i++){
//            if(map.get(nums[i]) == 1){
//                return nums[i];
//            }
//        }
//
//        return n;
//    }
//
//    public int[] countBits(int n) {
//        int[] ans = new int[n+1];
//        ans[0] = 0;
//        for(int i=1; i<= n; i++){
//            String binary = Integer.toBinaryString(i);
//            int count = countOnes(binary);
//            ans[i] = count;
//        }
//
//
//        return ans;
//    }
//
//    public int countOnes(String nums){
//        int count =0;
//        for(int i=0; i<nums.length(); i++){
//            if(nums.charAt(i) == '1'){
//                count++;
//            }
//        }
//
//        return count;
//    }
//    public int search(int[] nums, int target) {
//        int low =0;
//        int high = nums.length-1;
//        while (low<= high){
//            int mid = (low+high)/2;
//            if(nums[mid] == target){
//                return mid;
//            }
//           else if(target < nums[mid]){
//                high = mid-1;
//            }
//            else {
//                low = mid+1;
//            }
//        }
//
//        return -1;
//    }
//
//    static int findFloor(long arr[], int n, long x) {
//        long low =0;
//        long high = n-1;
//        while(low <= high){
//            long mid = (low+high)/2;
//            if(arr[(int) mid] == x){
//                return (int) mid;
//            } else if (arr[(int) mid] > x) {
//                high = mid-1;
//
//            }
//            else {
//                low = mid+1;
//            }
//        }
//        return (int) low;
//    }
//
//    public int mySqrt(int x) {
//        int ans = 0;
//        int low = 0;
//        int high = x;
//
//        while (low <= high){
//            int mid = (low+high)/2;
//
//            if(mid*mid == x){
//              ans = mid;
//            } else if (mid*mid > x) {
//                low = mid+1;
//
//            }
//            else {
//                high = mid-1;
//            }
//        }
//
//        return ans;
//    }
//    class pair{
//        int count;
//        char ch;
//
//        pair(int count, char ch){
//            this.ch = ch;
//            this.count = count;
//        }
//    }
//
//
//    public String frequencySort(String s) {
//        StringBuilder newString = new StringBuilder();
//
//        Map<Character, Integer> map = new HashMap<>();
//        PriorityQueue<pair> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i=0; i<s.length(); i++){
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
//        }
//
//        for(int i=0; i<s.length(); i++){
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                priorityQueue.add(new pair(entry.getValue(), entry.getKey()));
//            }
//        }
//
//        while (!priorityQueue.isEmpty()){
//            int count = priorityQueue.peek().count;
//            char ch = priorityQueue.peek().ch;
//            priorityQueue.poll();
//            for(int i=0; i< count; i++){
//                newString.append(ch);
//            }
//        }
//        return newString.toString();
//    }
//
//    public static int maxArea(int[] height) {
//        int currentHeight =0;
//        int maxStore =0;
//        int n = height.length;
//        int left = 0;
//        int right = n-1;
//        while (left < right){
//            if(height[left] > height[right]){
//                currentHeight = height[right];
//            }
//            else {
//                currentHeight = height[left];
//            }
//             maxStore = Math.max(maxStore,currentHeight * (right-left));
//
//            left++;
//        }
//
//        return maxStore;
//    }
//
//    public int findFirstOccurence(int[] nums, int k){
//        int low =0;
//        int high = nums.length-1;
//        int ans = -1;
//        while (low <= high){
//            int mid= (low+high)/2;
//
//            if(nums[mid] == k){
//                ans = mid;
//                high = mid-1;
//            }
//
//            else if (k > nums[mid]){
//                low = mid+1;
//            }
//            else {
//                high = mid-1;
//            }
//        }
//        return ans;
//    }
//
//    public int findLastOccurence(int[] nums, int k){
//        int low =0;
//        int high = nums.length-1;
//        int ans = -1;
//        while (low <= high){
//            int mid= (low+high)/2;
//
//            if(nums[mid] == k){
//                ans = mid;
//                low = mid+1;
//            }
//
//            else if (k > nums[mid]){
//                low = mid+1;
//            }
//            else {
//                high = mid-1;
//            }
//        }
//        return ans;
//    }
//
//    public int[] searchRange(int[] nums, int target){
//        int start = findFirstOccurence(nums , target);
//        int end = findLastOccurence(nums , target);
//        int[] res = new int[]{start,end};
//        return res;
//    }
//
//    public boolean isAnagram(String s, String t) {
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<s.length(); i++){
//           map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
//        }
//
//        for(int i=0; i<t.length(); i++){
//            if(map.containsKey(t.charAt(i))){
//               map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
//               if(map.get(t.charAt(i)) == 0){
//                   map.remove(t.charAt(i));
//               }
//            }
//        }
//
//
//        return map.isEmpty();
//    }
//
//    public static int[][] merge(int[][] intervals) {
//        if(intervals.length <= 1){
//            return intervals;
//        }
//        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
//        List<int[]> newList = new ArrayList<>();
//        int[] newInterval = intervals[0];
//        newList.add(newInterval);
//
//        for(int[] interval: intervals){
//            if(interval[0] < newInterval[1]){
//                newInterval[1] = Math.max(interval[1], newInterval[1]);
//            }
//            else {
//               newInterval = interval;
//               newList.add(newInterval);
//            }
//        }
//        return newList.toArray(new int[newList.size()][]);
//    }
//
//    public int countSeniors(String[] details) {
//        int count =0;
//        for(int i=0; i<details.length; i++){
//            if(details[i].charAt(11) > 6 && details[i].charAt(12) > 0){
//                count++;
//            }
//        }
//
//        return count;
//    }
//    public static String largestNumber(String[] arr)
//    {
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i=0; i<arr.length; i++){
//            stringBuilder.append(arr[i]);
//        }
//        int x = Integer.parseInt(String.valueOf(stringBuilder));
//
//
//        return null;
//    }
//
//    public String removeDuplicates(String s) {
//        Stack<Character> stack = new Stack<>();
//        stack.push(s.charAt(0));
//        for(int i=1; i<s.length(); i++){
//            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
//                stack.pop();
//            }
//            else {
//                stack.push(s.charAt(i));
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for(char a: stack){
//            sb.append(a);
//        }
//
//        return sb.toString();
//    }
//
//    public String removeConsecutiveCharacter(String S){
//        StringBuilder sb = new StringBuilder();
//        for(int i=1; i< S.length(); i++){
//            if(S.charAt(i) == S.charAt(i-1)){
//                sb.append(i);
//            }
//        }
//
//    }
//
//    public static void main(String[] args){
//        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] result = merge(nums);
//        System.out.println(result);
//    }
//
//}

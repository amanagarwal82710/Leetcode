package leetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class twoSum {
    public static int[] twoSum(int nums[], int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(target-nums[i], i);
            }
            else{
                return new int[]{i, map.get(nums[i])};
            }

        }
//            for(int j=i+1; j< nums.length; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
        return nums;
    }
    public static int buyAndSellStocks(int[] prices){
        int i =0;
        int count = 0;
        for(int j=1; j< prices.length; j++){
            if(prices[j] - prices[i] > 0 ){
                if(prices[j] - prices[i] > count) {
                    count = prices[j] - prices[i];

                }
            }
            else {
                i = j;
            }
        }
        return count;
    }

    public int findKthLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<k; i++){
            priorityQueue.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            if(priorityQueue.peek() < nums[i]){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }

        return priorityQueue.peek();
    }

    public int search1(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] < nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target> mid  && target <= nums[high]){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }


        return low;
    }

    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length -1;
        int mid =0;
        while(low <= high){
            mid = (low+high)/2;

            if(nums[mid] > nums[high]){
                low = mid;
            }
            else{
                high = mid;
            }


        }

        return nums[mid];
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            else {
                return true;
            }

        }

        return false;
    }

//    [-2,1,-3,4,-1,2,1,-5,4]
public static int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
        int currentSum = 0;
        for (int j = i; j < nums.length; j++) {
            currentSum += nums[j];
            maxSum = Math.max(maxSum, currentSum);
        }
    }

    return maxSum;
}

public static int maxSubArrayOptimized(int[] nums){
        int max_sum= nums[0];
        int curr_sum = nums[0];
        for(int i=1; i< nums.length; i++){
            curr_sum = Math.max(nums[i], curr_sum+ nums[i]);
            max_sum = Math.max(max_sum , curr_sum);
        }
        return max_sum;
}

public static int productSubArray(int[] nums){
        int max_product = Integer.MIN_VALUE;
        for(int i=0; i< nums.length; i++){
            int product =1;
            for (int j=i; j< nums.length; j++){
                product = Math.multiplyExact(product, nums[j]);
                max_product = Math.max(max_product, product);
            }
        }
        return max_product;
}

public static int maxProductArray(int[] nums ){
        int max_prod = nums[0];
        int left_prod = 1;
        int right_prod =1;
        for(int i=0; i< nums.length; i++){
            left_prod = left_prod == 0 ? 1: left_prod;
            right_prod = right_prod == 0? 1: right_prod;
            left_prod *= nums[i];
            right_prod *= nums[nums.length-1-i];

            max_prod = Math.max(max_prod, Math.max(left_prod, right_prod));
        }
        return  max_prod;
}
public static int minSortedRotated(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
}
public static int search(int[] nums, int target){
        for(int i=0; i< nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
}
public static List<List<Integer>> threeSum(int[] nums){
    List<List<Integer>> result = new ArrayList<>();
    Set<Set<Integer>> sets = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k = j+1; k< nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        int sum = nums[i] + nums[j] + nums[k];
                        List<Integer> triplet = new ArrayList<>();
                    }
                }
            }
        }
        return result;
}

public static List<List<Integer>> threeSumOptimized(int[] nums){
        if(nums == null || nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length -1;
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left = left +1;
                right -= 1;
            } else if (sum<0) {
                left += 1;

            }
            else {
                right -= 1;
            }
        }
        return new ArrayList<>(result);
}

public static int longestSubString(String s){
        int a_pointer =0;
        int b_pointer =0;
        int maxSum = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while(b_pointer < s.length()){
            if(!hashSet.contains(s.charAt(b_pointer))){
                hashSet.add(s.charAt(b_pointer));
                maxSum = Math.max(hashSet.size(), maxSum);
                b_pointer ++;
            }
            else {
                hashSet.remove(s.charAt(b_pointer));
                a_pointer ++;
            }
        }
    return maxSum;
}

public static int[] twoS(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(target-nums[i] , i);
            }
            else return new int[]{map.get(nums[i]) , i};
        }

    return nums;
}

public static  int stock(int[] prices){
        int count =0;
        int i =0;
        for(int j=1; j<prices.length; j++){
            if(prices[j] - prices[i] > 0){
                count = Math.max(count, prices[j] - prices[i]);
            }
           else if(j == prices.length - 1){
                i = i+1;
                j = i+1;
            }
        }
    return count;
}

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int product =1;
        for(int i=0; i<nums.length; i++){
            product = Math.multiplyExact(product, nums[i]);
        }
        for(int j =0; j< nums.length; j++){
            result[j] = product/nums[j];
        }
        return result;
    }

    public static int maxProfit(int[] prices) {
        int i =0; int profit =0;
        for(int j=1; j< prices.length; j++){
            if(prices[j] - prices[i] > 0){
                profit = profit + prices[j] - prices[i];
                i = i+1;
            }
            else{
                i =j;
            }
        }

        return profit;
    }

    public static boolean jumpGame(int[] jump){
        int j = 0;
        for(int i=0; i< jump.length-1; i++){
            if(j < i + jump[i]){
                j = i + jump[i];
            }
        }
        if(j == jump.length-1 ){
            return true;
        }
        return false;
    }

    public static int removeDuplicates2(int[] nums){
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

    public static List<String> fizzBuzz(int n){
        List<String> stringList = new ArrayList<>(n);
        for(int i=1; i<=n; i++){
            if(i%3 == 0){
                stringList.add(i, "fizz");
            } else if (i%5 == 0) {
                stringList.add(i,"buzz");

            }
            else {
                stringList.add(i, String.valueOf(i+1));
            }
        }
        return stringList;
    }

//    public static int mostWordsFound(String[] sentences) {
//        int count =0;
//        for(int i=0; i< sentences.length; i++){
//           count = Math.max(count, sentences[i].s);
//        }
//
//        return count;
//    }

    public String reverseString(String s) {
        s = s.trim();
        char[] charArr = s.toCharArray();
        int low = 0;
        int high = s.length()-1;

        while (low < high){
            char temp = charArr[low];
            charArr[low] = charArr[high];
            charArr[high] = temp;
            low ++;
            high --;
        }
        return Arrays.toString(charArr);
    }

    public static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }

    public static int strStr(String haystack, String needle) {
        int n =needle.length();
        for(int i=0; i<=haystack.length()-n; i++){
            String str = haystack.substring(i,(i+n));
            if(str.equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static int mostWordsFound(String[] sentences) {
        int length =0;
        for(int i=0; i< sentences.length; i++){
             length = Math.max(length, sentences[i].split("\\s+").length);
        }


        return length;
    }

    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                nums[j] = nums[i];
                j++;
            }
            while(j<nums.length){
                nums[j] = 0;
                j++;
            }
        }

    }

    public static int pivotIndex(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }

        int leftSum =0;
        for(int i=0; i< nums.length; i++){
            sum = sum - nums[i];
            if(leftSum == sum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }

        return -1;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n= nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        int cur =1;
        for(int i=0; i< nums.length; i++){
            ans[i] = Math.multiplyExact(ans[i],cur);
            cur = cur*nums[i];
        }
        for(int i=n-1; i>=0; i++){
            ans[i] = Math.multiplyExact(ans[i],cur);
            cur = cur*nums[i];
        }

        return ans;
    }
//[2,0,2,1,1,0]
    public static void sortColors(int[] nums) {
       int[] colors = new int[3];
       int count =0;
       for(int i=0; i< nums.length; i++){
           colors[nums[i]]++;
       }
       int counter =0;
       for(int j=0; j<3; j++){
           while(colors[nums[j]] > 0){
               nums[counter] = nums[j];
               counter++;
           }
       }

    }


    public int distributeCandies(int[] candyType) {
        Map<Integer, Boolean> map = new HashMap<>();
        int count =0;
        for(int i=0; i<candyType.length; i++){
            if(!map.containsKey(candyType[i])){
                map.put(candyType[i], true);
                count += 1;
            }
        }

        return count;
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder nStr = new StringBuilder();
        for(int i=0; i<s.length(); i++){
           if(!map.containsKey(s.charAt(i))){
               map.put(s.charAt(i) ,1);
               nStr.append(s.charAt(i));
           }
        }

        return nStr.toString();
    }

//    public boolean isPalindrome(String s) {
//        char[] ch = s.toCharArray();
//
//        return false;
//    }

    public int missingNumber(int[] nums) {
        int i=0;
        int n=nums.length;
        while (i<n){
            int currenIndex = nums[i];
            if(nums[i] < n && nums[i] != i){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[currenIndex] = temp;
            }
            else{
                i++;
            }
        }

        for(int j=0; j<n; j++){
            if(j != nums[j]){
                return j;
            }
        }

        return n;
    }

//    public int[] findErrorNums(int[] nums) {
//        int i=0;
//        int n=nums.length;
//        while (i<n){
//            int currenIndex = nums[i]-1;
//            if(nums[i] != nums[currenIndex]){
//                int temp = nums[i];
//                nums[i] = nums[currenIndex];
//                nums[currenIndex] = temp;
//            }
//            else{
//                i++;
//            }
//        }
//
//        for(int j=0; j<n; j++){
//            if(j != nums[j]){
//               return new int[]{j,nums[j};
//            }
//        }
//
//        return new int[]{n};
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        int n= nums.length;
        int i=0;
        while(i<n){
            int ci = nums[i]-1;
            if(nums[i] != nums[ci]){
                int temp = nums[i];
                nums[i] = nums[ci];
                nums[ci] = temp;
            }
            else {
                i++;
            }
        }
        for(i=0; i<n; i++){
            if(nums[i] != i+1){
                integerList.add(nums[i]);
            }
        }

        return integerList;
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n= nums.length;
        int count =1;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], count);
            }
            else{
                map.put(nums[i], (map.get(nums[i])+1));
            }
        }
        for(int i =0; i<n; i++){
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }

        return count;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingList = new ArrayList<>();
        int n= nums.length;
        int i=0;
        while(i<n){
            int currentIndex = nums[i]-1;
            if(nums[i] !=nums[currentIndex]){
                int temp = nums[i];
                nums[i] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
            else {
                i++;
            }
        }
        for(i=0; i<n; i++){
            if(nums[i] != i+1){
                missingList.add(i+1);
            }
        }

        return missingList;
    }


    public static void rotateArray(int[] nums, int k){
        int n= nums.length;
        k = k%n;
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);

    }

    public static void reverseArray(int[] nums, int start, int end){
        while(start< end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else {
               return nums[i];
            }
        }

        return n;
    }
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count =0;
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j= i+1; j<n-1; j++){
                if(Math.abs(arr[i] -arr[j]) >= a ){
                    for(int k=i+2; k<n; k++){
                        if(Math.abs(arr[j]-arr[k]) >=b && Math.abs(arr[i]-arr[k]) >=c){
                            count ++;
                        }
                    }
                }
            }
        }

        return count;
    }

//    Input: arr = [2,3,4,7,11], k = 5
//    Output: 9
//    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//    Example 2:
//
//    Input: arr = [1,2,3,4], k = 2
//    Output: 6
//    Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
//[5,7,7,8,8,10], target = 8
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int mid = n/2;
        if(target< nums[mid]){
            for(int i=0; i<mid; i++){
                if(nums[i] == target && nums[i+1] == target){
                    return new int[]{i,i+1};
                } else if (nums[i] == target) {
                    return new int[]{i,i};
                }
            }

        }
        else{
            for(int j=mid; j<n; j++){
                if(nums[j] == target){
                    return new int[]{j,j+1};
                }
            }
        }

        return new int[]{-1,-1};
    }
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//    Example 2:
//
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1

//    public int searchInsert(int[] nums, int target) {
//        int n =nums.length;
//        int left =0;
//        int right = n-1;
//        int mid = left + (right-left)/2;
//        while(left<right){
//            if(nums[mid] < target){
//                left = mid+1;
//            } else if (nums[mid] > target) {
//                right =mid -1;
//            }
//            else {
//                if (nums[mid] == target){
//                    return mid;
//                }
//            }
//        }
//
//    }


    public int longestConsecutive(int[] nums){
        int n = nums.length;
        int count =0;
        int currSum =0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(nums[i+1] - nums[i] == 1){
                count += 1;
                currSum = Math.max(currSum, count);
            }
            else {
                count=0;
            }
        }
        return currSum;
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1= strs[0];
        String s2 = strs[strs.length-1];
        int i=0;
        while (i < s1.length() && i < s2.length()){
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        return s1.substring(0,i);

    }

    public int findUnsortedSubarray(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        ans = nums.clone();
        Arrays.sort(ans);
        int end =0;
        int start = ans.length-1;
        for(int i=0; i<n; i++){
            if(nums[i] != ans[i]){
                start = Math.min(start,i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end-start+1 : 0);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i=0;
        while (i<n){
            if(digits[i] != 9){
                digits[i] = digits[i]+1;
                return digits;
            }

            digits[i] = 0;
        }
        int[] ans = new int[n+1];
        ans[0] =1;
        return ans;
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max =0;
        int zeroCount =0;
        int oneCount =0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(nums[i] == 0){
                    zeroCount++;
                }
                else {
                    oneCount++;
                }
                if(zeroCount == oneCount){
                    max = Math.max(max,j-i+1);
                }
            }
        }

        return max;
    }

    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,-1);
        int sum =0;
        int max =0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                sum -= 1;
            }
            else {
                sum += 1;
            }
            if(map.containsKey(sum)){
                max = Math.max(max,i-map.get(sum));
            }
            else {
                map.put(sum,i);
            }
        }
        return max;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Map<Integer, Integer> map = new HashMap<>();
        while (k>0){
        int min =nums[0];
        for(int i=0; i<k; i++){
            min =Math.min(min, nums[i]);
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }

        }
        if(map.containsKey(min)){
           int j = map.get(min);
           nums[j] = min*multiplier;
           k--;
        }
        }


        return nums;
    }
    public int[] commonElement(int[] arr1, int[] arr2, int[] arr3){
        List<Integer> ans = new ArrayList<>();
        int x=0;
        int y=0;
        int z=0;
        while(x<arr1.length && y<arr2.length && z<arr3.length){
            if(arr1[x] == arr2[y] && arr2[y] == arr3[z]){
                ans.add(arr1[x]);
                x++;
                y++;
                z++;
            } else if (arr1[x] > arr2[y]) {
                y++;
            } else if (arr2[y] > arr3[z]) {
                z++;

            }
            else {
                x++;
            }

        }
        return arr1;
    }

    public static int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            sum = sum+nums[i];
            count += map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum ,0)+1);
        }

        return count;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] ans = new int[nums.length];
        ans= nums.clone();
        Arrays.sort(ans);
        return ans[nums.length-k];


    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum =0;
        Map<Integer, Integer> map = new HashMap<>();
        if(k ==0){
        boolean zero = false;
         // zero cases
        for(int i=1; i<n; i++){
            if(nums[i] == 0 && nums[i-1] == 0){
                zero =true;
            }
        }
        return zero;
            }
        map.put(0,-1); // to handle empty array cases
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum%k)){
                if(i - (map.get(prefixSum%k))> 1){
                    return true;
                }
            }
            map.put(prefixSum%k,i);
        }
        return false;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int n= nums.length;
        int remainder =0;
        int prefixSum =0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++){
            prefixSum = prefixSum+nums[i];
            remainder = prefixSum%k;
            if(remainder<0){
                remainder = remainder+k;
            }
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }

        return count;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for (int j=0; j<i; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }


    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        int k=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[i][j] = original[k];
                k++;
            }
        }

        return res;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp =image[i][j];
                image[i][j] = image[i][n-j-1];
                image[i][n-j-1]= temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(image[i][j] == 0){
                    image[i][j] = 1;
                }
                else {
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }
    public static String removeDigit(String number, char digit) {
        int index = 0,n=number.length();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                index = i;
                if(i<n-1 && digit < number.charAt(i+1)) break;
            }
        }
        number = number.substring(0, index) + number.substring(index+1);
        return number;

    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if(r*c != row*col){
            return mat;
        }
        int sr = 0;
        int sc = 0;
        int[][] ans = new int[r][c];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(sc == c){
                    sr++;
                    sc =0;
                }
                ans[sr][sc] = mat[i][j];
                sc++;
            }
        }

        return ans;
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        for(int rowIndex: rowList){
            makeRowZero(matrix, rowIndex);
        }

        for(int colIndex: colList){
            makeColZero(matrix, colIndex);
        }
    }

    private void makeRowZero(int [][] mat, int rowIndex){
        for(int j=0; j<mat[0].length; j++ ){
            mat[rowIndex][j] = 0;
        }
    }

    private void makeColZero(int [][] mat, int colIndex){
        for(int i=0; i<mat.length; i++ ){
            mat[i][colIndex] = 0;
        }
    }

    public static boolean isPalindrome(String s) {
       int start = 0;
       int last = s.length() -1;
       while(start < last){
           if(!Character.isLetterOrDigit(s.charAt(start))){
               start++;
           } else if (!Character.isLetterOrDigit(s.charAt(last))) {
               last--;
           }
           else {
               if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))){
                   return false;
               }
               start ++;
               last--;
           }
       }
        return true;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            if(!map.containsKey(numbers[i])){
                map.put(target-numbers[i], i);
            }
            else{
                int index = map.get(numbers[i]);
                return new int[]{index+1,i+1};
            }
        }
        return new int[0];
    }
    public void toBinary(int N) {
        List<Integer> ans = new ArrayList<>();
        while(N>0){
            ans.add(N%2);
            N= N/2;
        }
        Collections.reverse(ans);
        for(int i: ans){
            System.out.println(i);
        }
    }

    public int hammingWeight(int n) {
        List<Integer> ans = new ArrayList<>();
        while(n>0){
            ans.add(n%2);
            n= n/2;
        }

        return n;
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        int start =0;
        int end = n-1;
        while (start <= end) {
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return checkPalindrome(s,start+1,end) || checkPalindrome(s,start,end-1);
            }
        }

        return true;
    }

    public boolean checkPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end --;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public int[] singleNumber2(int[] nums) {
        int x=0;
        int y=0;
        int xor =0;
        for(int i=0; i<nums.length; i++) {
            xor = xor ^ nums[i];
        }
           int lastSetBit = xor & (~(xor-1));

           for(int i=0; i<nums.length; i++){
               if((nums[i] & lastSetBit) == 0){
                   x = x^nums[i];
               }
               else{
                   y = y^nums[i];
               }

        }
           return new int[]{x,y};

    }

    public int majorityElement(int[] nums) {
        int count =0;
        int candidate =0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count++;
            }
            else {
                count--;
            }
        }
        return count;
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Integer[] ans = new Integer[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        Arrays.sort(ans, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (Objects.equals(map.get(a), map.get(b))) {
                    return b - a;
                }
                return map.get(a) - map.get(b);

            }
        });

        for(int i=0; i<nums.length; i++){
            nums[i] = ans[i];
        }
        return nums;
    }

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char bracket: ch){
            if(bracket == '('){
                stack.push(')');
            } else if (bracket == '{') {
                stack.push('}');
            } else if (bracket == '[') {
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop() != bracket) {
                    return false;
                }
            }
        }
        return true;
    }

    int getInversionCount(int[] array) {
        int n =array.length;
        int[] ans = Arrays.copyOf(array, n);
        Arrays.sort(ans);
        int count =0;
        int i=0;
        int j=0;
        while (i<n){
            if(array[i] != ans[j] && array[i+1] - array[i] == 1){
                j++;
                count += 1;
            }
            else {
                j=0;
                i++;
            }
        }
        return count;
    }


    public boolean isPowerOfTwo(int n) {
        int quo = n/2;

        return (n%2 == 0 && quo%2 == 0);

    }

    public static double findMaxAverage(int[] nums, int k) {
        int n =nums.length;
        int sum =0;
        for(int i=0; i<k; i++){
            sum = sum + nums[i];
        }
        int max_sum = sum;
        int start_index =0;
        int end_index = k;
        while (end_index < n){
            sum -= nums[start_index];
            start_index++;
            sum += nums[end_index];
            end_index++;

            max_sum = Math.max(max_sum, sum);
        }
        return (double) max_sum/k;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int sum =0;
        for(int i=0; i<k; i++){
            if(nums[i+1] != nums[i]){
                sum += nums[i];
            }
        }

        int max_sum = sum;
        int start_index =0;
        int end_index =k;
        while(end_index<nums.length){
            if(nums[start_index+1] != nums[start_index] && nums[end_index-1] != nums[end_index]){
                sum -= nums[start_index];
                sum += nums[end_index];
            }
            end_index++;
            start_index++;
            max_sum = Math.max(max_sum , sum);
        }

        return max_sum;
    }



    public static void main(String[] args) {
       int[] nums = {1,5,4,2,9,9,9};
       double res = maximumSubarraySum(nums,3);
       System.out.println(res);


    }
}

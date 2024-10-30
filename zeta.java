package leetcodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class zeta {

    public int[] moveZeroes(int [] nums){
        Arrays.sort(nums);
        return nums;
    }

    public static int[] moveZeroes1(int [] nums){
        int n= nums.length;
        int j=n-1;
        for(int i=n-1; i>=0; i--){
            if(nums[i] != 0){
               nums[j] = nums[i];
                j--;
            }
        }
        while(j >=0){
            nums[j] = 0;
            j--;
        }
        return nums;
    }
    public static boolean longestString(String s, String[] str){
        Map<String , Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        int max =0;
        for(int i=0; i<str.length; i++){
            map.put(str[i], str[i].length());
        }
        for(int i=0; i<str.length; i++){
            max = Math.max(max, str[i].length());
        }
        String longestString = "";

        for(int i=0; i<str.length; i++){
            if(str.length == max){
                longestString = str[i];
            }
        }
        for(char c: s.toCharArray()){
            map1.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: longestString.toCharArray()){
           if(!map1.containsKey(c)){
               return false;
           }
        }


        return map1.isEmpty();
    }

//    public String longestPalindrome(String s) {
//        int l =0;
//        int r = s.length() -1;
//        StringBuilder stringBuilder = new StringBuilder();
//        while (l<=r){
//            if(s.charAt(l)!=s.charAt(r)){
//                l++;
//                r--;
//            }
//            else{
//                stringBuilder.
//            }
//        }
//
//    }


    public static void main(String[] args){
        int[] nums= {1,0,2,0,3,0};
        System.out.println(Arrays.toString(moveZeroes1(nums)));
    }
}

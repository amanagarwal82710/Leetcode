//package leetcodeProblems;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
//public class happyNumber {
//
//    public int[] isHappy(int n) {
//
////        map.put(1,1);
////        map.put(2,2);
////        map.put(3,1);
////        map.put(4,7);
////        map.put(6,7);
////        map.put(5,3);
////
////        [1,2,3,4,6,5]
//
//        Payment payment;
//
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//        HashSet<Integer> hashSet = new HashSet<>();
//
//
//        for(int i=0; i<map.size(); i++){
//            int x = map.get(i);
//            if(!hashSet.contains(x)){
//                hashSet.add(x);
//            }
//            Object[] y = hashSet.toArray();
//            Arrays.sort(y);
//        }
//
//
//
//        int slow = n;
//       int fast = n;
//       do{
//           slow = square(slow);
//           fast = square(square(fast));
//       }
//       while (slow != fast);
//
//       return slow == 1;
//    }
//
//
//
//    public static void main(String[] args) {
//    }
//
//    public int square(int n){
//        int ans =0;
//        while (n > 0){
//            int rem = n%10;
//            ans += rem*rem;
//            n= n/10;
//        }
//
//        return ans;
//    }
//
//}

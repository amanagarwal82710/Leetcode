package leetcodeProblems.StackQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWIndowMaximum {

   public static int[] solve(int[]  input,int k){
       int n= input.length;
       int[] ans = new int[n-k+1];
       Deque<Integer> deque = new ArrayDeque<>();
       int j = 0;
       for(int i=0; i<n; i++){
           if(!deque.isEmpty() && deque.peek() == i-k){
               deque.poll();
           }
           while (!deque.isEmpty() && input[deque.peekLast()] < input[i]){
               deque.pollLast();
           }
           deque.offer(i);

           if(i >= k-1){
               ans[j] = input[deque.peek()];
               j++;
           }
       }

       return ans;
   }
}

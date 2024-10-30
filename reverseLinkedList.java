package leetcodeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class reverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode preNode = null;

        while (curr != null){
            ListNode node = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr.next = node;
        }

        head = preNode;

        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preNode = dummy;
        ListNode currNode = head;
        for(int i=0; i<left-1; i++){
            preNode = preNode.next;
            currNode = currNode.next;
        }

        ListNode preNodee = null;
        ListNode subListNode = currNode;

        for(int i=0; i<= right-left; i++){
            ListNode newNode = currNode.next;
            currNode.next = preNodee;
            preNodee = currNode;
            currNode = newNode;
        }

        preNode.next = preNodee;
        subListNode.next = currNode;

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0,head);
       ListNode res = dummy;

       for(int i=0; i<n; i++){
           head = head.next;
       }

       while (head != null){
           head = head.next;
           res = res.next;
       }

       res.next = res.next.next;

       return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode currentNode = head;
        while (currentNode != null){
            map.put(currentNode.val, map.getOrDefault(currentNode.val, 0)+1);
            currentNode = currentNode.next;
        }

        currentNode = head;
        while (currentNode != null){
            if(map.get(currentNode.val) == 1){
                break;
            }
            else {
                currentNode = currentNode.next;
            }
        }

        while (currentNode != null && currentNode.next != null){
            if(map.get(currentNode.next.val) != 1){
                currentNode.next= currentNode.next.next;
            }
            else {
                currentNode = currentNode.next;
            }
        }
//        ListNode curr = head;
//        hashSet.add(curr.val);
//        while (curr != null && curr.next != null){
//            if(hashSet.contains(curr.next.val)){
//                curr.next = curr.next.next;
//            }
//            else {
//                hashSet.add(curr.next.val);
//                curr = curr.next;
//            }
//        }

        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode prev = head;
        ListNode temp = prev.next;

        while (temp!= null){
            if(prev.val == temp.val){
                temp = temp.next;
                continue;
            }

            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        return head;
    }

}

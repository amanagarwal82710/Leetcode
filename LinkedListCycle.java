package leetcodeProblems;
import org.w3c.dom.Node;

import java.util.*;
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curr = head;
        while (curr != null){
            if(hashSet.contains(curr)){
                return true;
            }
            else {
                hashSet.add(curr);
                curr = curr.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create the linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Connect the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle: connect the last node to the second node (position 1)
        fourth.next = second;

        // Test the hasCycle1 method
        boolean result = hasCycle1(head);

        // Output the result
        System.out.println("Does the linked list have a cycle? " + result);  // Expected output: true
    }
}

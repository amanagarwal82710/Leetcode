package leetcodeProblems;

import leetcodeProblems.ListNode;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = new ListNode(0,head);
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}

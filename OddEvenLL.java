package leetcodeProblems;

public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // Return early for empty list or single-node list
        }
        ListNode curr = head;
        ListNode newHead = head.next;
        ListNode newCurr = newHead;
        while (newCurr != null && newCurr.next != null){
            curr.next = newCurr.next;
            curr = curr.next;

            newCurr.next = curr.next;
            newCurr = newCurr.next;

        }

        curr.next = newHead;
        return head;
    }
}

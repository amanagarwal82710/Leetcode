package leetcodeProblems;

public class Cycle2 {

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while (slow != head){
                    head = head.next;
                    slow= slow.next;
                }
                return slow;
            }
        }

        return null;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length =0;
        ListNode curr = head;
        while (curr.next != null){
            length++;
        }

        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast && length%2 != 0){
                return slow;
            }
        }

        return slow.next;
    }
}

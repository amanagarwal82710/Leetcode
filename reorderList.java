package leetcodeProblems;

public class reorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;

        while (slow.next != null && fast.next != null && fast.next.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = null;
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null){
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }

        ListNode mergeHead = new ListNode(-1);
        ListNode it = mergeHead;
        ListNode it1 = head;
        ListNode it2 = prev;

        while (it1 != null && it2 != null){
            ListNode for1 = it1.next;
            it.next = it1;
            it1 = for1;

            it = it.next;

            ListNode for2 = it2.next;
            it.next = it2;
            it2 = for2;

            it = it.next;
        }

        head = mergeHead.next;
        return;


    }
}

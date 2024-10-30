package leetcodeProblems;

public class partitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallPtr = small;
        ListNode largePtr = large;

        while (head != null){
            if(head.val < x){
                smallPtr.next = head;
                smallPtr = smallPtr.next;
            }
            else {
                largePtr.next = head;
                largePtr= largePtr.next;
            }
        }

        smallPtr.next = large.next;
        largePtr.next = null;

        return small.next;
    }
}

package leetcodeProblems;

public class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {}

    public ListNode(int val, ListNode next){ this.val = val; this.next = next; }

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

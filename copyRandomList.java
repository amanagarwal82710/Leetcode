package leetcodeProblems;

public class copyRandomList {

    public ListNode copyRandomList(ListNode head) {

        // introduce a new node between every node


        ListNode curr = head;

        while (curr != null){
            ListNode node = new ListNode(head.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        // in the every  middle node we introduced point the random pointers also

        curr = head;
        while (curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
                curr = curr.next.next;
            }
        }

        // separate both the lists

        curr = head;
        ListNode newHead =  curr.next;
        ListNode newCurr = newHead;
        while (curr != null){
            curr.next = newCurr.next;
            curr = curr.next;
            if(curr != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }

}

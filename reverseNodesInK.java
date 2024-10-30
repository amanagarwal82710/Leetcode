package leetcodeProblems;

public class reverseNodesInK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int len =0;
        while (curr != null){
            len ++;
            curr = curr.next;
        }
        ListNode preNode = null;
        curr = head;
        if(len-k >= k){
            for(int i=0; i<k; i++){
                ListNode node = curr.next;
                curr.next = preNode;
                preNode = curr;
                curr = node;
            }
        }

        return curr;
    }

}

package leetcodeProblems;

public class rotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;  // No need to rotate if list is empty, has one element, or k is zero
        }

        // Step 1: Calculate the length of the linked list
        ListNode curr = head;
        int length = 1;  // Start with length 1 because curr is already at head
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Handle the case where k is larger than the length of the list
        k = k % length;
        if (k == 0) {
            return head;  // No rotation needed if k is a multiple of the list length
        }

        // Step 3: Make the list circular by connecting the last node to the head
        curr.next = head;  // curr is now at the last node, so we link it back to head

        // Step 4: Find the node where the list should be broken
        ListNode node1 = null;
        for (int i = 0; i < length - k ; i++) {  // Move to the node before the new head
            node1 = node1.next;
        }

        // Step 5: Break the list and set the new head
        ListNode newHead = node1.next;  // The new head is k nodes from the end
        node1.next = null;  // Break the link

        return newHead;  // Return the new head of the rotated list
    }
}

package leetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class intersectionOftwoLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode curr1 = headA;
//        Map<ListNode, Boolean> map = new HashMap<>();
//        while (curr1 != null){
//            map.put(curr1, true);
//            curr1 = curr1.next;
//        }
//
//        while (headB != null){
//            if(map.containsKey(headB)){
//                return headB;
//            }
//            else {
//                headB = headB.next;
//            }
//        }
//
//        return curr1;
//    }

        ListNode aNode = headA;
        ListNode bNode = headB;
        int AC = 0, BC =0 ;
        while(aNode != null){
            AC++;
            aNode = aNode.next;
        }
        while(bNode != null){
            BC++;
            bNode = bNode.next;
        }

        while (AC > BC){
            AC --;
            headA = headA.next;
        }

        while (BC > AC){
            BC --;
            headB = headB.next;
        }

        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }}

package leetCode.question;

import leetCode.dataStructure.ListNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class interviewQuestion0207 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        if (headA == headB) return headA;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while (headA != null){
            stack.add(headA);
            headA = headA.next;
        }

        ListNode temp = null;
        boolean flag = false;
        while (headB != null){
            if (stack.contains(headB)){
                if (!flag){
                    temp = headB;
                    flag = true;
                }
            }else flag = false;
            headB = headB.next;
        }
        return temp;
    }



    /*public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        if (headA == headB) return headA;
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        ListNode temp = null;
        while (headB != null){
            if (set.contains(headB)){
                temp = headB;
                break;
            }
            headB = headB.next;
        }
        return temp;
    }*/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);

        node12.setNext(node3);

        ListNode intersectionNode = getIntersectionNode(node1, node12);
        intersectionNode.printListNode(intersectionNode);

    }
}

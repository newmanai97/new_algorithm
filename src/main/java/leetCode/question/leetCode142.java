package leetCode.question;

import leetCode.dataStructure.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class leetCode142 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        HashSet<ListNode> set = new LinkedHashSet<>();
        while (head != null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);

        ListNode listNode = detectCycle(node1);
        System.out.println(listNode.getVal());
    }
}

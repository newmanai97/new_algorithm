package leetCode.question;

import leetCode.dataStructure.ListNode;

public class leetCode206 {
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(0);
        while (head != null){
            ListNode cur = head;
            head = head.getNext();
            cur.setNext(null);
            if (newHead.getNext() != null){
                cur.setNext(newHead.getNext());
            }
            newHead.setNext(cur);
        }
        return newHead.getNext();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode node = reverseList(node1);
        while (node != null){
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }
}

package leetCode.question;

import javafx.scene.shape.VLineTo;
import leetCode.dataStructure.ListNode;

import java.util.List;

public class leetCode203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode newhead = head;
        ListNode prev = head;
        while (head != null){
            if (head.getVal() == val){
                if (prev == head){
                    newhead = head.getNext();
                    prev = head.getNext();
                }else {
                    prev.setNext(head.getNext());
                }
            }else {
                prev = head;
            }
            head = head.getNext();
        }
        return newhead;
    }
//    public static ListNode removeElements(ListNode head, int val) {
//        if (head == null){
//            return null;
//        }
//        head.setNext(removeElements(head.getNext(), val));
//        return head.getVal() == val ? head.getNext(): head;
//    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode nullnode = new ListNode();

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        ListNode node = removeElements(node1, 7);
        while (node != null){
            System.out.println(node.getVal());
            node = node.getNext();
        }

    }
}

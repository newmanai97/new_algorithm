package leetCode.question;

import leetCode.dataStructure.ListNode;
import sun.misc.FpUtils;

import java.util.List;

public class leetCode24 {

    /*public static ListNode swapPairs(ListNode head) {
        if(head == null || head.getNext() ==null) return head;

        ListNode newHead = new ListNode(0);
        ListNode newHeadCur = newHead;
        ListNode cur = head;

        ListNode pre = null;
        int falg = 1;
        while (cur != null){
            ListNode temp = cur;
            cur = cur.getNext();
            temp.setNext(null);

            if (falg % 2 != 0){
                pre = temp;
                falg++;
            }else {
                newHeadCur.setNext(temp);
                temp.setNext(pre);
                pre = null;
                falg = 1;
                newHeadCur = newHeadCur.getNext().getNext();
            }
        }
        if (pre != null){
            newHeadCur.setNext(pre);
        }
        return newHead.getNext();
    }*/

    /*public static ListNode swapPairs(ListNode head) {
        if(head == null || head.getNext() ==null) return head;

        ListNode newHead = new ListNode(0);
        newHead.setNext(head);
        ListNode temp = newHead;
        while (temp.getNext() != null && temp.getNext().getNext() != null){
            ListNode pre = temp.getNext();
            ListNode fow = temp.getNext().getNext();
            temp.setNext(fow);
            pre.setNext(fow.getNext());
            fow.setNext(pre);
            temp = pre;
        }
        return newHead.getNext();
    }*/

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.getNext() ==null)
            return head;

        ListNode temp = head.getNext();
        ListNode res = swapPairs(temp.getNext());
        temp.setNext(head);
        head.setNext(res);
        return temp;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode node = swapPairs(node1);
        while (node != null){
            System.out.println(node.getVal());
            node = node.getNext();
        }
    }
}

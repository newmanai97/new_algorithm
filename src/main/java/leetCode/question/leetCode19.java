package leetCode.question;

import leetCode.dataStructure.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class leetCode19 {

//    static int sum = 0;
//    static int maxSum = 0;
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) return head;
//        if (head.next == null) {
//            if (n == 1) head = null;
//            return head;
//        }
//        sum++;
//        maxSum = Math.max(sum, maxSum);
//        removeNthFromEnd(head.next,n);
//        sum--;
//        if (maxSum- sum == n){
//            head.next = head.next.next;
//        }
//        return head;
//    }

    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode tempNode = new ListNode(0, head);
        ListNode temp = tempNode;
        int listLength = getListLength(head);
        for (int i = 1; i <  listLength - n +1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return tempNode.next;
    }

    public static int getListLength(ListNode head){
        if (head == null)
            return 0;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }*/

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode tempNode = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = tempNode;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i){
            stack.pop();
        }
        ListNode peek = stack.peek();
        peek.next = peek.next.next;
        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        ListNode listNode = removeNthFromEnd(node1, 1);
        System.out.println(listNode);
    }
}

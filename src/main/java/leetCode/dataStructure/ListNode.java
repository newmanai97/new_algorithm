package leetCode.dataStructure;

/*
Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void printListNode(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

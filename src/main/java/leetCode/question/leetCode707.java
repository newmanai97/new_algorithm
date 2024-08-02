package leetCode.question;

import leetCode.dataStructure.ListNode;
import leetCode.dataStructure.MyLinkedList;

import java.util.List;

public class leetCode707 {
    private int size;

    private ListNode head;


    public leetCode707() {
        size = 0;
        head =  new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size || head.getNext() == null){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++){
            cur = cur.getNext();
        }
        return cur.getVal();
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size){
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.getNext();
        }
        ListNode newNode = new ListNode(val);
        newNode.setNext(pre.getNext());
        pre.setNext(newNode);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || head.getNext() == null){
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.getNext();
        }
        pre.setNext(pre.getNext().getNext());
        size--;
    }

    public void printLinkedList(){
        ListNode cur = head;
        for (int i = 0; i < size; i++){
            cur = cur.getNext();
            System.out.println(cur.getVal());
        }
    }

    public static void main(String[] args) {
        leetCode707 myLinkedList = new leetCode707();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        myLinkedList.get(3);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.get(0);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.get(0);


        myLinkedList.printLinkedList();
    }
}

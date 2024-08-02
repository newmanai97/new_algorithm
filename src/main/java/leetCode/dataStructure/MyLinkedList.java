package leetCode.dataStructure;

import java.util.List;

public class MyLinkedList {
    private int size;

    private ListNode head;


    public MyLinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {
        if (size == 0){
            return -1;
        }
        if (head == null){
            return -1;
        }
        if(index >= size || index < 0){
            return -1;
        }
        ListNode cur = head;
        if (index == 0) return cur.getVal();
        for (int i = 0; i < index; i++){
            cur = cur.getNext();
        }
        return cur.getVal();
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if (size == 0){
            head = newHead;
        }else {
            newHead.setNext(head);
            head = newHead;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        if (size == 0){
            head = newTail;
        }else{
            ListNode cur = head;
            for (int i = 0; i < size -1; i++){
                cur = cur.getNext();
            }
            cur.setNext(newTail);
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0)return;
        ListNode newNode = new ListNode(val);
        if (index == 0){
            newNode.setNext(head);
            head = newNode;
        }
        ListNode cur = head.getNext();
        ListNode pre = head;
        for (int i = 1; i < index; i++){
            cur = cur.getNext();
            pre = pre.getNext();
        }

        pre.setNext(newNode);
        newNode.setNext(cur);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size == 0){
            return;
        }
        if (index >= size || index < 0)return;
        if (index == 0){
            head = head.getNext();
            return;
        }
        ListNode cur = head.getNext();
        ListNode pre = head;
        for (int i = 1; i < index; i++){
            cur = cur.getNext();
            pre = pre.getNext();
        }
        pre.setNext(cur.getNext());
        size--;
    }

    public void printLinkedList(){
        ListNode cur = head;
        for (int i = 0; i < size; i++){
            System.out.println(cur.getVal());
            cur = cur.getNext();
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
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



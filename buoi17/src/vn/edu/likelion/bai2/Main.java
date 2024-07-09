package vn.edu.likelion.bai2;

public class Main {
    public static int size(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
    public static ListNode listNodeMiddle(ListNode head){
        int size = size(head);
        ListNode temp = head;
        for( int i=0 ; i<size/2 ; i++ ){
            temp = temp.next;

        }
        return temp;
    }
    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println("Middle element of linkedList is: " + listNodeMiddle(listNode1).val);

    }
}

package linkedlist.single.collection;

import linkedlist.single.Node;

public class Check {
    public static boolean isPallindrom(Node head){
        if(head==null || head.next==null) 
        {
            return true;
        }
        Node middle = Find.getMiddle(head);
        System.out.println(middle.val);
        Node revhead = Arrange.reverse(middle.next);
        middle.next = revhead;
        Node temp = head;
        Node temp2  = revhead;
        while(temp!=revhead){
            if(temp.val!=temp2.val){
                return false;
            }
            temp  = temp.next;
            temp2 = temp2.next;
        }
        
        return true;

    }


    public static boolean hasLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}

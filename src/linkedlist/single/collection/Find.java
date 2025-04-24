package linkedlist.single.collection;

import linkedlist.single.Node;

public class Find {
        public static Node getMiddle(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        Node prev = null;
    
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }       
        return prev;
        }
        public static Node Middle(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
    
        while (fast.next!= null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }       
        return slow;
        }
        public static Node search(Node head,int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == value) {
                return temp;  // Return the node if found
            }
            temp = temp.next;
        }
        System.out.println("Value " + value + " not found in the list.");
        return null;  // Return null if not found
        }


        public static Node LoopStart(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                    while(slow!=fast){
                        slow= slow.next;
                        fast = fast.next;
                    }
                    return slow;
            }
        }
        return null;
    }


    // get intersection

    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA==null || headB==null) return null;
        Node t1 = headA;
        Node t2 = headB;
        // if(t1==t2) return t1;
        while(t1!=t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1==t2){
                    return t1;
            }
            if(t1==null){
                t1 = headB;
            }
            if(t2 == null)
            {
                t2 = headA;
            }
        }
        return t1;
    }

    public static Node binarySearch(Node head,int target){
        if(head == null || head.val == target){
            return head;
        }       
        Node last = null;
        Node start = head;
        while(start!=last){
            Node middle = Find.Middle(start);
            if(middle.val == target){
                return middle;
            }
            else if(middle.val<target){
                start = middle.next;
            }
            else{
                last= middle;
            }
        }
        return start;
    }
}

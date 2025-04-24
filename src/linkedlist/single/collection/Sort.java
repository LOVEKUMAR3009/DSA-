package linkedlist.single.collection;

import linkedlist.single.Node;

public class Sort {
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;
    
        // Step 1: Split the list into two halves
        Node mid = Find.getMiddle(head);
        Node rightHead = mid.next;
        mid.next = null; // break the list
    
        // Step 2: Sort each half
        Node left = sortList(head);
        Node right = sortList(rightHead);
    
        // Step 3: Merge sorted halves
        return mergeTwoLists(left, right);
      }
    
      // Find middle node (safe split)
      
    
      // Merge two sorted lists
      public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;
    
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
    
        // Append remaining nodes
        if (l1 != null) tail.next = l1;
        else tail.next = l2;
    
        return dummy.next;
      }
}

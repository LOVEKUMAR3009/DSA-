package linkedlist.single;

import linkedlist.single.function.RemoveDuplicate;

public class SingleList implements LinkedListInterface {
  Node head;
      /********************************* insert at end*****************************************/
  // insert using data
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
        head = newNode;
        return;
    }
    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;
    return;
  }


    // insert by given node
    public void insertAtEnd(Node newNode) {
      if (head == null) {
          head = newNode;
          return;
      }
      Node temp = head;
      while (temp.next != null) {
          temp = temp.next;
      }
      temp.next = newNode;
      return;
    }


    
  public void insertBeforeTail(int data) {
    Node newNode = new Node(data);

    // If list is empty or has only one node
    if (head == null || head.next == null) {
        insertAtEnd(data); // or insertAtBeginning(data)
        return;
    }

    Node temp = head;

    // Traverse to the node just before the last
    while (temp.next != null && temp.next.next != null) {
        temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }
  public void insertBeforeTail(Node newNode) {

    // If list is empty or has only one node
    if (head == null || head.next == null) {
        insertAtEnd(newNode); // or insertAtBeginning(data)
        return;
    }

    Node temp = head;

    // Traverse to the node just before the last
    while (temp.next != null && temp.next.next != null) {
        temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }


    /********************************* insert at beginning*****************************************/
    public void insertAtBeginning(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    }

    
     
    public void insertAtBeginning(Node newNode) {
      newNode.next = head;
      head = newNode;
    }


    public void insertAfterHead(int data) {
      if (head == null) {
          head = new Node(data); // If list is empty, make it head
          return;
      }

      Node newNode = new Node(data);
      newNode.next = head.next;
      head.next = newNode;
    }



    public void insertAfterHead(Node newNode) {
      if (head == null) {
          head = newNode; // If list is empty, make it head
          return;
      }
      newNode.next = head.next;
      head.next = newNode;
    }


/*****************************************insert at a particular place*********************************************/

  // 0 based indexing when data is given
  public void insertAtPosition(int data, int position) {
    Node newNode = new Node(data);

    // Insert at beginning or if head is null
    if (position <= 0 || head == null) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;
    int index = 0;

    // Traverse to the node just before the desired position
    while (temp != null && index < position - 1) {
        temp = temp.next;
        index++;
    }

    // If position is beyond list length, insert at end
    if (temp == null) {
        System.out.println("Position out of bounds. Inserting at the end.");
        insertAtEnd(data);
        return;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }
  public void insertAtPosition(Node newNode, int position) {

    // Insert at beginning or if head is null
    if (position <= 0 || head == null) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;
    int index = 0;

    // Traverse to the node just before the desired position
    while (temp != null && index < position - 1) {
        temp = temp.next;
        index++;
    }

    // If position is beyond list length, insert at end
    if (temp == null) {
        System.out.println("Position out of bounds. Inserting at the end.");
        insertAtEnd(newNode);
        return;
    }

    newNode.next = temp.next;
    temp.next = newNode;
  }


  /*******************************************deletion ********************************************* */


    // delete the given node from the list
    public void deleteNode(Node node) {
      if (head == null) {
        System.out.println("List is empty");
      }
      else if (head == node) {
        head = head.next;
      }
      else {
        Node current = head;
        while(current.next!=null){
          if(current.next==node){
            current.next=current.next.next;
            return;
          }
          current=current.next;
        }
        System.out.println("node is not present in the list");
      }
    }
      
    // Delete the node at the specified position ,0 based indexing
    public void deleteAtPosition(int position) {
      if (head == null) {
          System.out.println("List is empty. Nothing to delete.");
          return;
      }

      // If the position is 0, we are deleting the head node
      if (position == 0) {
          head = head.next;
          return;
      }

      Node temp = head;
      int index = 0;

      // Traverse to the node just before the one to be deleted
      while (temp != null && index < position - 1) {
          temp = temp.next;
          index++;
      }

      // If position is out of bounds, we can't delete
      if (temp == null || temp.next == null) {
          System.out.println("Position out of bounds. Cannot delete.");
          return;
      }

      // Delete the node at the given position
      temp.next = temp.next.next;
  }

  public void deleteFirstNode() {
    if (head == null) {
        System.out.println("List is empty. Nothing to delete.");
        return;
    }

    head = head.next; // Move head to the next node
  }


  public void deleteLastNode() {
    if (head == null) {
        System.out.println("List is empty. Nothing to delete.");
        return;
    }

    if (head.next == null) {
        head = null; // Only one node in the list
        return;
    }

    Node temp = head;

    // Traverse to the second last node
    while (temp.next.next != null) {
        temp = temp.next;
    }

    temp.next = null; // Remove reference to last node
  }



/************************************************searching operation***************************************** */


  public Node search(int value) {
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


/***********************************sorting of list***************************************************** */
  public Node sortList(Node head) {
    if (head == null || head.next == null) return head;

    // Step 1: Split the list into two halves
    Node mid = getMiddle(head);
    Node rightHead = mid.next;
    mid.next = null; // break the list

    // Step 2: Sort each half
    Node left = sortList(head);
    Node right = sortList(rightHead);

    // Step 3: Merge sorted halves
    return mergeTwoLists(left, right);
  }

  // Find middle node (safe split)
  private Node getMiddle(Node head) {
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

  // Merge two sorted lists
  public Node mergeTwoLists(Node l1, Node l2) {
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


  public void removeDuplicates() {
    Node current = head;
    while (current != null && current.next != null) {
        if (current.val == current.next.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
  }


  /******************************************************check operation ************************************* */


    public boolean hasLoop() {
      Node slow = head, fast = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if (slow == fast) return true;
      }
      return false;
    }
    public Node LoopStart() {
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

    public Node getIntersectionNode(Node headA, Node headB) {
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

  /******************************************basics of linked list******************************************/
  // length of the node
  public int length() {
    int count = 0;
    Node temp = head;
    while (temp != null) {
        count++;
        temp = temp.next;
    }
    return count;
  }


  // reverse the list

  public void reverse() {
    Node prev = null;
    Node current = head;
    while (current != null) {
        Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
  }

  // display all the node
  public void display() {
    Node loopcheck = LoopStart();
    Node temp = head;
    if(loopcheck!=null){
      while (temp != loopcheck) {
        System.out.print(temp.val + " -> ");
        temp = temp.next;
      }
      System.err.print(temp.val+" -> ");
      temp = temp.next;
      while (temp != loopcheck) {
          System.out.print(temp.val + " -> ");
          temp = temp.next;
      }
      System.out.println("null");
      System.out.print("loopstart at ");
      System.out.println(loopcheck.val);
   
    }
    else{
      while (temp != loopcheck) {
        System.out.print(temp.val + " -> ");
        temp = temp.next;
      }
      System.out.println("null");
    }
   
  }


  public void clear() {
    head = null;
  }

  public Node middleNode() {
    if(head == null ) return head;
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next !=null){
    slow = slow.next;
    fast = fast.next.next;
    }
    return slow ;
  }


  // Merge Sort for Linked List


  public static void main(String[] args) {
    Node newnNode = new Node(23);
    SingleList list = new SingleList();
    SingleList list2 = new SingleList();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);
    // list.insertAtEnd(3);
    // list.insertAtEnd(4);
    list.insertAtEnd(4);
    list.insertAtEnd(5);
    list.insertAtEnd(6);
    // RemoveDuplicate.deleteDuplicates(list.head);
    RemoveDuplicate.reorderList(list.head);

 
    // list.display();
    // list2.display();
    // System.out.println(list.getIntersectionNode(list.head, list2.head).val);
    // System.out.println(list.hasLoop());
  }

}

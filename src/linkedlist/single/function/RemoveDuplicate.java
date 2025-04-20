package linkedlist.single.function;

import linkedlist.single.Node;

public class RemoveDuplicate {
  public static void main(String[] args) {
    
  }
  public static Node deleteDuplicates(Node head) {
    if(head == null || head.next == null) return head;
    Node dummyNode = new Node();
    dummyNode.next = head;
    Node temp = head;
    Node prev = dummyNode;
    while(temp!=null && temp.next!=null){
          if(temp.val!=temp.next.val){
            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }else{
            int data = temp.val;
            Node nextNode = temp.next;
            while(nextNode!=null && nextNode.val==data){
                nextNode = nextNode.next;
            }
            // prev.next = nextNode;
            // prev = nextNode;
            temp = nextNode;
        }
        
    
    }
    prev.next = temp;
    display(dummyNode.next);
    return dummyNode.next;
}


public static void display(Node head){
  Node temp = head;
  while(temp!=null){
    System.out.print(temp.val+" ");
    temp = temp.next;
  }
}


public Node partition(Node head, int x) {
  Node small = new Node();
  Node smalltemp = small;
  Node equal = new Node();
  Node equaltemp = equal;
  Node great = new Node();
  Node greattemp = great;

  Node temp = head;
  while(temp!=null){
        if(temp.val==x){
            Node tempNode = new Node(temp.val);
            equaltemp.next = tempNode;
            equaltemp = tempNode;
        }else if(temp.val>x){
            Node tempNode = new Node(temp.val);
            greattemp.next = tempNode;
            greattemp = tempNode;
        }else{
            Node tempNode = new Node(temp.val);
            smalltemp.next = tempNode;
            smalltemp = tempNode;
        }
      temp = temp.next;
  }
  if(small.next!=null){
      if(equal.next!=null){
          if(great.next!=null){
              smalltemp.next = equal.next;
              equaltemp.next = great.next;
              return small.next;
          }else{
              smalltemp.next = equal.next;
              return small.next;
          }
      }else{
          if(great.next!=null){
              smalltemp.next = great.next;
              return smalltemp.next;
          }else{
              return smalltemp.next;
          }
      }
  }else{
      if(equal.next!=null){
          if(great.next!=null){
              equaltemp.next = great.next;
              return equal.next;
          }else{
              return equal.next;
          }
      }else{
          if(great.next!=null){
              return great.next;
          }else{
              return null;
          }
      }
  }
}

public static void reorderList(Node head) {
    Node mid = middleNode(head);
    Node rev = reverseList(mid.next);
    mid.next = rev;
    display(head);

}
 public static Node middleNode(Node head) {
         if(head == null ||head.next==null) return head;
    Node slow = head;
    Node fast = head;
    while(fast.next!=null && fast.next.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow ;
    }

    public static Node reverseList(Node head) {
        if(head == null || head.next == null)return head ;
        Node prev = null;
        Node mover = head ;
        while(mover !=null){
        Node front = mover.next;
        mover.next = prev ;
        prev = mover ;
        mover = front ;
        }
        
        return prev;
    }
}

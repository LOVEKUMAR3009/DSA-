package linkedlist.single;

public class Node {
    public int val;
    public Node next;
    public Node(){
      
    }
    public Node(int val) {
       this.val = val; 
    }
    Node(int val,Node next) {
      this.val = val;
      this.next = next; 
    }
}

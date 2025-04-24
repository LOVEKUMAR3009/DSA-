package linkedlist.single.collection;

import linkedlist.single.Node;
public class Arrange {
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void insert(Node head){
        if(head == null || head.next == null){
            return ;
        }
        Node dummy = new Node();
        dummy.next  = head;
        Node prev  = dummy;
        Node tillsort = head;
        Node temp = head.next;
        while(temp!=null){
            // IF THE NEXT  NODE IS GREATER THEN THE SORTED LINKEDLIST TILL SORETED
            if(temp.val>tillsort.val){
                tillsort = temp;
                temp  = temp.next;
            }
            else{
                //STORE THE NEXT NODE
                Node nextNode = temp.next;
                // TRAVERSE IN THE SORTED SECTION TILL THE NODE VALUE IS GREATER THE TEMP NODE VALUE
                Node acctualpostion= prev.next;
                while(acctualpostion!=null){
                    if(acctualpostion.val>temp.val){
                        break;
                    }
                    prev = acctualpostion;
                    acctualpostion = acctualpostion.next;
                }
                temp.next = acctualpostion;
                prev.next = temp;
                tillsort.next = nextNode;
                temp = nextNode;
            
            }
        }

        display(dummy.next);

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




    public static void reorderList(Node head) {
        Node mid = Find.getMiddle(head);
        Node rev = reverseList(mid.next);
        mid.next = rev;
        display(head);
    
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


    // sort the linked list
    
    
    
      public static Node removeDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
      }
    


    // end of the sorting 

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
      }

      public void display2(Node head){
        if(head==null) return;
        Node temp = head;
        while (temp != null) {
          System.out.print(temp.val + " -> ");
          temp = temp.next;
        }
        System.out.println("null");
      }



      // day 4 recursive solution
      public static Node deleteEvenValue(Node head){

        if(head==null) return head;
        head.next = deleteEvenValue(head.next);
        if(head.val%2==0){
            return head.next;
        }
        else{
            return head;
        }
      }

      public static Node deleteEvenValue2(Node head){
        if(head==null){
            return head;
        }
        Node temp = head;
        while(temp!=null && temp.val%2==0){
            temp = temp.next;
        }
        if(temp==null){
            return null;
        }
        head = temp;
        Node odd = head;
        temp = temp.next;
        while(temp!=null){
            if(temp.val%2==0){
                temp = temp.next;
            }else{
                System.out.println(temp.val);
                odd.next = temp;
                odd = temp;
                temp = temp.next;
            }
        }
        display(head);
        return head;
      }
}

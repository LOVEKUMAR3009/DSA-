package linkedlist.single.collection;
import linkedlist.single.Node;
import linkedlist.single.SingleList;

public class Extra {

// sum of two linkedlist

    public static Node sumOfList(Node head1 ,Node head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        Node revhead1 = Arrange.reverse(head1);
        Node revhead2 = Arrange.reverse(head2);
        SingleList ans = new SingleList();
        int carry = 0;
        Node temp1 = revhead1;
        Node temp2 = revhead2;
        while(temp1!=null && temp2!=null){
            int data = temp1.val+temp2.val+carry;
            if(data>=10){
                data = data%10;
                carry = 1;
            }
            ans.insertAtBeginning(data);
            temp1 = temp1.next;
            temp2 = temp2.next;

        }
        while(temp1!=null){
            int data = temp1.val+carry;
            if(data>=10){
                data = data%10;
                carry = 1;
            }
            ans.insertAtBeginning(data);
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            int data = temp2.val+carry;
            if(data>=10){
                data = data%10;
                carry = 1;
            }
            ans.insertAtBeginning(data);
            temp2 = temp2.next;
        }
        
        if(carry==1){
            ans.insertAtBeginning(1);
        }
        return ans.head;
    }
}

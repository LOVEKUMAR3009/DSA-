package linkedlist.single;

import linkedlist.single.collection.Arrange;
import linkedlist.single.collection.Sort;

public class TestList {
        public static void main(String[] args) {
        SingleList list = new SingleList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(10);
        list.insertAtEnd(5);
        list.insertAtEnd(7);
        list.insertAtEnd(8);

        // Merge sort the list
    

        // Display original list with loop check
        list.display();
    }
}

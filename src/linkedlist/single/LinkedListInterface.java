package linkedlist.single;

public interface LinkedListInterface {
    
    // Insert operations
    void insertAtEnd(int data);
    void insertAtEnd(Node newNode);
    
    void insertAtBeginning(int data);
    void insertAtBeginning(Node newNode);
    
    void insertAfterHead(int data);
    void insertAfterHead(Node newNode);
    
    void insertBeforeTail(int data);
    void insertBeforeTail(Node newNode);
    
    void insertAtPosition(int data, int position);
    void insertAtPosition(Node newNode, int position);
    
    // Deletion operations
    void deleteNode(Node node);
    void deleteAtPosition(int position);
    void deleteFirstNode();
    void deleteLastNode();
    
    // Search
    Node search(int value);
    
    // Sorting and duplicates
    Node sortList(Node head);
    Node mergeTwoLists(Node l1, Node l2);
    void removeDuplicates();
    
    // Checks
    boolean hasLoop();
    Node LoopStart();
    Node getIntersectionNode(Node l1,Node l2);
    
    // Utility
    int length();
    void reverse();
    void display();
    void clear();
    Node middleNode();
}

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
    // Node search(int value);
    
    // Sorting and duplicates
    
    // Checks
    
    // Utility
    int length();
    void display();
    void clear();
}

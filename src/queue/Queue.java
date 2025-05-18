package queue;
import java.util.NoSuchElementException;

public class Queue<T> {
    private int size=0;
    private Node<T> head;
    private Node<T> tail;

    public int size(){
        return size;
    }
    private static class Node<T> {
        private T val;
        private Node<T> next;
    
        Node(T val){
            this.val =val;
            this.next = null;
        }
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if(tail ==null){
            head = newNode;
            tail  = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public T dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, cannot dequeue.");
        }
        T temp = head.val;
        head = head.next;
        if(head ==null){
            tail = null;
        }
        size--;
        return temp;
    }
    public T peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException("Queue is empty, cannot peek.");
        }
        return head.val;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
}

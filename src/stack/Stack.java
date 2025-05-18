package stack;

import java.util.EmptyStackException;

public class Stack<T>{
    private Node<T> head;
    private int size=0;

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
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T temp = head.val;
        head = head.next;
        size--;
        return temp;
    }

    public void push(T data){
        Node<T> newNode = new Node(data);
        size++;
        newNode.next = head;
        head = newNode;
    }
    public T  peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
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
    public void clear() {
        head = null;  
        size = 0;
    }
    
}

package trees.avl;

public class Node {
  int data;
  int height;
  Node left;
  Node right;
  
  Node(int data){
    this.data = data;
    this.height = 1;
  }
}

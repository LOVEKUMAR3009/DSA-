package trees.avl;

public interface AVLInterface {
  
  public int height(Node root);
  int getBalance(Node root);
  Node insert(Node root,int key);
  Node delete(Node root,int key);
  Node leftRotate(Node root);
  Node rightRotate(Node root);
}

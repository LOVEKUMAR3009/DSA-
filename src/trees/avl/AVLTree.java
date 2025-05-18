package trees.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.sound.sampled.Line;

public class AVLTree implements AVLInterface {
  private Node root;
  AVLTree(){
    this.root = null;
  }

  /***********************************************utility function*********************************************** */
  
  @Override
  public int height(Node root) {
    if (root == null){
      return 0;
    }
    return root.height;  
  }
  
  @Override
  public int getBalance(Node root) {   
    if (root == null) {
      return 0;
    }
    return height(root.left) - height(root.right);
  }
  
  
  @Override
  public Node insert(Node root,int key) {
    if (root == null){
      root = new Node(key);
      return root;
    }
    if (key < root.data)
        root.left = insert(root.left, key);
    else if (key > root.data)
        root.right = insert(root.right, key);
    else
        return root; // Duplicate keys not allowed

    // Update height
    root.height = 1 + Math.max(height(root.left), height(root.right));
    // Check balance
    int balance = getBalance(root);

    // Left Left Case and the second check to specify if we have to perfomr single or double rotation
    if (balance > 1 && getBalance(root.left)>=0)
        return rightRotate(root);

    // Right Right Case
    if (balance < -1 && getBalance(root.right)<=0)
        return leftRotate(root);

    // Left Right Case
    if (balance > 1 && getBalance(root.left)<0) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // Right Left Case
    if (balance < -1 && getBalance(root.right)>0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
  }
  //method overloading
  public Node insert(int key) {
    this.root = insert(this.root, key);  // FIX: update class-level root
    return this.root;
  }

  public Node delete(int key){
    root = delete(root, key);
    return root;
  }



  
  @Override
  public Node delete(Node root, int key) {
    // Step 1: Perform standard BST delete
    if (root == null) return null;

    if (key < root.data) {
        root.left = delete(root.left, key);
    } else if (key > root.data) {
        root.right = delete(root.right, key);
    } else {
        // Node to be deleted found
        if (root.left == null || root.right == null) {

            root = (root.left != null) ? root.left : root.right;
        } 
        else {
            // Node with two children
            Node successor = getSuccessor(root);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
    }

    if (root == null) return null; // Just return if tree has only one node

    // Step 2: Update height
    root.height = 1 + Math.max(height(root.left), height(root.right));

    // Step 3: Get balance factor
    int balance = getBalance(root);

    // Step 4: Balance the tree with AVL rotations

    // Left Left Case
    if (balance > 1 && getBalance(root.left) >= 0)
        return rightRotate(root);

    // Left Right Case
    if (balance > 1 && getBalance(root.left) < 0) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    // Right Right Case
    if (balance < -1 && getBalance(root.right) <= 0)
        return leftRotate(root);

    // Right Left Case
    if (balance < -1 && getBalance(root.right) > 0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
  }

  private Node getSuccessor(Node root) {
    Node current = root.right;
    while (current.left != null) {
        current = current.left;
    }
    return current;
  }
  @Override
  public Node leftRotate(Node root) {
    Node temp = root.right;
    Node tempLeft = temp.left;
    temp.left = root;
    root.right = tempLeft;
    root.height = Math.max(height(root.left), height(root.right)) + 1;
    temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
    return temp;

  }
  
  @Override
  public Node rightRotate(Node root) {
    Node temp = root.left;
    Node tempRight = temp.right;
    temp.right = root;
    root.left = tempRight;
    root.height = Math.max(height(root.left), height(root.right)) + 1;
    temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
    return temp;
  }

   public List<Integer> inOrder(Node root){
    ArrayList<Integer> ans = new ArrayList<>();
    if(root == null){
      return ans;
    }
     ans.addAll(inOrder(root.left));
    ans .add(root.data);
    ans.addAll(inOrder(root.right));
    return ans;
  }

  public static void main(String[]args){
    AVLTree tree = new AVLTree();
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.insert(35);
    tree.delete(40);
    tree.display();
    // tree.insert(45);
    List<Integer> result =  tree.inOrder(tree.root);
    // System.out.println();
    // System.out.println(result);
    
  }



  public void display(){
    if(root == null) return;
    Queue<Node > q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while(!q.isEmpty()){
      Node temp = q.poll();
      if(temp == null){
        if(q.isEmpty()){
          break;
        }
        System.out.println();
        q.add(null);
      }
      else {
        System.out.print(temp.data + " ");
        if(temp.left!=null){
          q.add(temp.left);
        }
        if(temp.right!=null){
          q.add(temp.right);
        }
      }
    }
  }
}

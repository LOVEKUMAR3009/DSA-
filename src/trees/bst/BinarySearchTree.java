package trees.bst;

import java.util.ArrayList;

public class BinarySearchTree {
  Node root;
  BinarySearchTree(int data){
    this.root = new Node(data);
  }
  BinarySearchTree(){
    this.root = null;
  }
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    Node root = null;
    // bst.addNode(root,10);
    // bst.addNode(root,20);
    // bst.addNode(root,30);
    // bst.addNode(root,40);
    // bst.preOrder(root);
    System.out.println();
    
     ArrayList<Integer> ans =bst.inOrder(root);System.out.println(ans);
    // bst.postOrder(root);
    // System.out.println(root.left.data);
  }

  public void addNode(Node node,int data){

    if(node.data == data) return ;
    else if(node.data <data){
      if(node.right!=null){

        addNode(node.right,data);
      }
      else{
        Node node1 = new Node(data);
        node.right = node1;
      }
    }
    else if(node.data>data ){
      if(node.left!=null){

        addNode(node.left, data);
      }
      else{
        Node node1 = new Node(data);
        node.left = node1;
      }
    }
  }

  public void preOrder(Node root){
    if(root == null){
      return ;
    }
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);

  }
  public ArrayList<Integer> inOrder(Node root){
    ArrayList<Integer> ans = new ArrayList<>();
    if(root == null){
      return ans;
    }
     ans.addAll(inOrder(root.left));
    ans .add(root.data);
    ans.addAll(inOrder(root.right));
    return ans;

  }
  public void postOrder(Node root){
    if(root == null){
      return ;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data+" ");

  }
  
}

package trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
  Node root;
  BinarySearchTree(int data){
    this.root = new Node(data);
  }
  BinarySearchTree(){
    this.root = null;
  }

  // insert in the binary search tree
  private Node insert(Node root,int data){
      if(root==null){
        root = new Node(data);
        return root;
      }
      if(root.data==data){
        return root;
      }
      else if(data<root.data){
        root.left = insert(root.left, data);
      }
      else{
        root.right = insert(root.right, data);
      }
      return root;
  }
  public Node insert(int data){
    root = insert(root, data);
    return root;
  }

  // delete in the binary serach tree

  public Node findInOrderSuccessor(Node rootNode){
    Node current = rootNode.right;
    while(current.left!=null){
      current = root.left;
    }
    return current;
  }
  public Node delete(Node root,int data){
    if(root  == null){
      return null;
    }
    if(root.data ==data){
      if(root.left==null && root.right==null){
        root = null;
        return root;
      }
      else if(root.left==null){
        root = root.right;
        return root;
      }else if(root.right==null){
        root = root.left;
        return root;
      }
      Node inorderSuccessor = findInOrderSuccessor(root);
      root.data = inorderSuccessor.data;
      root.right = delete(root.right, inorderSuccessor.data);
      return root;
    }
    else if(root.data<data){
      root.right = delete(root.right, data);
    }
    else{
      root.left = delete(root.left, data);
    }
    return root;
  }

  public Node delete(int data){
    root = delete(root,data);
    return root;
  }

  // four traversal traversal 
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
  public  void  levelOrder(){
    Queue<Node> q = new LinkedList<>();
    if(root==null){
      return ;
    }
    q.add(root);
    while(!q.isEmpty()){
      Node temp = q.poll();
      System.out.print(temp.data+" ");
      if(temp.left!=null){
        q.add(temp.left);
      }
      if(temp.right!=null){
        q.add(temp.right);
      }
    }

  }
    public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(10);
    bst.insert(20);
    bst.insert(30);
    bst.insert(40);
    bst.delete(30);
    bst.postOrder(bst.root);
    System.out.println();
    bst.preOrder(bst.root);
    System.out.println();

    System.out.println();
    bst.levelOrder();
    System.out.println();
    
    ArrayList<Integer> ans =bst.inOrder(bst.root);
    System.out.println(ans);
  }
  
}

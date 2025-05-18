package trees.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    Node root;
    
        // this recursive function is not opitmal as it can make tree left skewed 
        // public Node insert(Node root, int value) {
        //     if (root == null) {
        //         root = new  Node(value);
        //         return root;
        //     }
        //     if(root.left==null){
        //         root.left = new Node(value);
        //     }
        //     else if(root.right == null){
        //         root.right = new Node(value);
        //     }
        //     else {
        //         insert(root.left, value);
        //     }
        //     return root;          
        // }

        public void insert( int value) {
            if (root == null) {
                root = new Node(value);
                return ;
            }
            Queue <Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.left == null){
                    temp.left = new Node(value);
                    return ;
                }
                else{
                    q.add(temp.left);
                }
                 if(temp.right==null){
                    temp.right = new Node(value);
                    return;
                }else {
                    q.add(temp.right);
                }
            }
        }

        public void inorder(Node root,List<Integer>list) {
            if(root==null){
                return ;
            }
            inorder(root.left,list);
            list.add(root.data);
            inorder(root.right,list);
        }
        public void preorder(Node root,List<Integer>list) {
            if(root==null){
                return ;
            }
            list.add(root.data);
            preorder(root.left,list);
            preorder(root.right,list);
        }
        public void postorder(Node root) {
            if(root==null){
                return ;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public void delete(int target) {
            Node targetNode = search(target);
            if (targetNode == null) {
                System.out.println("Target not found");
            }
            else if (targetNode.left == null && targetNode.right == null) {
                targetNode = null;
                return ;
            }
            
            Node rightmostNode = deepest();
            if(rightmostNode!=null){
                targetNode.data = rightmostNode.data; 
                deleteDeepest(rightmostNode);           
            }
            
        }

        public void deleteDeepest(Node node) {
            if(root==null)return ;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                if (temp.left == node) {
                    temp.left =null;
                    return;
                }
                else if (temp.right == node) {
                    temp.right = null;
                    return;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }

        public Node deepest(){
            if(root==null)return null;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.poll();
                if(q.isEmpty()){
                    return temp;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            return null;
        }

        public Node search(int target){
            if(root==null){
                return null ;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.data==target){
                    return temp ;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            return null;

        }
        public static void main(String[]args){
            BinaryTree tree = new BinaryTree();
            tree.insert( 5);
            tree.insert( 10);
            tree.insert( 15);
            tree.insert( 25);
            tree.insert( 35);
            tree.insert( 54);
            tree.insert( 55);
            List<Integer> inorder = new ArrayList<>();
            List<Integer> preorder = new ArrayList<>();
            tree.inorder(tree.root, inorder);
            tree.preorder(tree.root, preorder);
            System.out.println(inorder);
            System.out.println();
            System.out.println(preorder);

            Deserialization deserialization = new Deserialization();
            Node rootnode = deserialization.construct(preorder, inorder);
            BinaryTree tree2 = new BinaryTree();
            tree2.root = rootnode;
             List<Integer> inorder2 = new ArrayList<>();
            List<Integer> preorder2 = new ArrayList<>();
            tree2.inorder(tree2.root, inorder2);
            tree2.preorder(tree2.root, preorder2);
            System.out.println(inorder2);
            System.out.println();
            System.out.println(preorder2);

            
            
        }


}

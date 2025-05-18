package trees.binarytree;

import java.util.List;

public class Deserialization {
    
    int preorderIndex = 0;
    public Node construct(List<Integer>preorder,List<Integer>inorder){
         return build(preorder,inorder,0,inorder.size()-1);
    }

    public  Node build(List<Integer>preorder,List<Integer>inorder,int left,int right){
        if(left>right) return null;

        int val = preorder.get(preorderIndex);
        Node root = new Node(val);
        preorderIndex++;
        if(left==right) return root;

        int index =  search(inorder,val,left,right);
        if(index!=-1){
            root.left = build(preorder,inorder,left,index-1);
            root.right = build(preorder,inorder,index+1,right);
        }else{
            System.out.println("not correct input because they don't have same data");
        }
        return root;
    }
    public int search(List<Integer>inorder,int value,int left,int right){
        for (int i = left; i <= right; i++) {
            if (inorder.get(i).equals(value)) return i;
        }
        return -1;
    }
}

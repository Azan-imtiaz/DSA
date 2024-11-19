package Practise;

class Node{
    int data;
    Node left;
    Node right;
    Node(int _data){
        data=_data;
        left=null;
        right=null;
    }
}
class BinaryTree{
    public static Node buildTree(Node root,int data){
        if(root==null){
            Node newNode=new Node(data);
            return newNode;
        }
       else if(root.left==null){
            return buildTree(root.left, data);

        }
       else if(root.right==null){
            return buildTree(root.right, data);
        }

        
        return root;

    }
}
public class Pract {
    public static void main(String[] args) {
        
    }
}

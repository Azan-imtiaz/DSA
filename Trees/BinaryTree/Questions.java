package Trees.BinaryTree;

import javax.swing.tree.TreeNode;

public class Questions {

    public static int Count_Node(Node root) {
        if (root == null) {
            return 0;
        }
        int left_Count = Count_Node(root.left);
        int right_Count = Count_Node(root.right);

        return left_Count + right_Count + 1;

    }

    public static int Sum_Of_Node(Node root) {
        if (root == null) {
            return 0;
        }

        int left_sum = Sum_Of_Node(root.left);
        int right_sum = Sum_Of_Node(root.right);

        return left_sum + right_sum + root.data;

    }

    public static int height_of_tree(Node root){
        if(root==null){
            return 0;
        }
        int left_height=height_of_tree(root.left);
        int right_height=height_of_tree(root.right);
        int height=Math.max(left_height, right_height)+1;
       
        return height;
    }


public static int calculate_diameter(Node root){
    if(root==null){
        return 0;
    }
    int diam1=calculate_diameter(root.left);
    int diam2=calculate_diameter(root.right);
    int diam3=height_of_tree(root.left)+height_of_tree(root.right)+1;
    return Math.max(diam3,Math.max(diam1, diam2));
}


static class Info {
int diam;
int ht;
Info(int ht,int diam){
    this.ht=ht;
    this.diam=diam;
}
    
}


public static Info calculate_diameter2(Node root){
    if(root==null){
      return  new Info(0, 0);
    }
    
    Info left=calculate_diameter2(root.left);
    Info right=calculate_diameter2(root.right);
    int myHeight=Math.max(left.ht, right.ht)+1;

    int diam1=left.diam;
    int diam2=right.diam;
    int diam3=left.ht+right.ht+1;

    int myDiam=Math.max(Math.max(diam1,diam2),diam3);

     Info  n=new Info(myHeight, myDiam);
     return n;



}

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Build Tree PreOrder
        Node root = BinaryTree.buildTree(nodes);
        System.out.println();

        // Question 1
        // Count Number of Node
        // Approach we will calculate x(node in left sub tree)+ y(node in right sub
        // tree)+ 1(for root)
        // Time complexity 0(N)

        int count = Count_Node(root);
        System.out.println("Total Node =" + count);
        System.out.println();

        // Question 2
        // Sum of Node
        // Approach we will calculate x(Sum of left sub tree)+ y(Sum of right sub tree
        // tree)+ some value (of root)
        // Time complexity 0(N)

        int sum = Sum_Of_Node(root);
        System.out.println("Total Sum of Nodes =" + sum);
        System.out.println();

        // Question 3
        // height of Node
        // Approach we will calculate x(height of left sub tree)+ y(height of right sub
        // tree
        // tree) phir enmy cy jo be max ha usmy +1 krdo root ky lea
        // Time complexity 0(N)

        int height = height_of_tree(root);
        System.out.println("Total height of tree =" + height);
        System.out.println();


        // Question 4
        // Diameter of Tree(Number of Nodes in the longest path btw any 2 nodes)
        //Case 1 diameter pass through root node
        //case 2 diameter  not pass through root node
        //Approach 1 O(N^2)
        // longest oath can exist in left subtree or in right subtree   or by combining left sub tree+right subtree+1(for root)

        int diameter = calculate_diameter(root);
        System.out.println("Diameter of  tree =" + diameter);
        System.out.println();
  
        //Approach 2
        //Diameter and height sath he hr node ky calculate kr leni ha
        //time complexity 0(n)

      int  diameter2 = calculate_diameter2(root).diam;
        System.out.println("Diameter of  tree =" + diameter2);
        System.out.println();
  
       //sub tree of another tree on leatcode
//        class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         // If subRoot is null, it is always a subtree
//         if (subRoot == null) return true;
//         // If root is null and subRoot is not, subRoot can't be a subtree
//         if (root == null) return false;

//         // Check if the current nodes are equal and if the subtrees are identical
//         if (isSameTree(root, subRoot)) {
//             return true;
//         }

//         // Otherwise, check the left and right subtrees of the root
//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }

//     // Helper method to check if two trees are the same
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if (p == null && q == null) return true; // Both are null
//         if (p == null || q == null) return false; // One is null, one is not
//         if (p.val != q.val) return false; // Values differ

//         // Check recursively for both left and right subtrees
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//     }
// }

  
    }

}

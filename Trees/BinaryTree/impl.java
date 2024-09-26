package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {

        this.data = data;
        this.left = null;
        this.right = null;

    }
}

class BinaryTree {
    static int idx = -1;

    // Build Tree Preorder
    public static Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    // PreOrder Traversal
    public static void PreOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);

    }

    // inOrder Traversal
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // postOrder Traversal
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    //LevelOrder Traversal
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);  // Null acts as a marker for the end of each level
        
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if (curNode == null) {
                System.out.println();  // Move to the next line for the next level
                if (q.isEmpty()) {
                    break;  // If queue is empty, traversal is complete
                } else {
                    q.add(null);  // Add null to mark the end of the next level
                }
            } else {
                System.out.print(curNode.data + " ");  // Print the current node's data
                
                if (curNode.left != null) {
                    q.add(curNode.left);  // Add left child to the queue
                }
                if (curNode.right != null) {
                    q.add(curNode.right);  // Add right child to the queue
                }
            }
        }
    }
    
    
}

public class impl {
    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Build Tree PreOrder
        Node root = BinaryTree.buildTree(nodes);
        System.out.println();

        // PreOrder Traversal(Root-> Left sub tree -> right sub tree) time complexity
        // 0(N)
        BinaryTree.PreOrderTraversal(root);
        System.out.println();

        // inOrder Traversal(Left sub tree-> root -> right sub tree) time complexity
        // 0(N)
        BinaryTree.inOrderTraversal(root);
        System.out.println();
        
        // postOrder Traversal(Left sub tree-> right sub tree -> root ) time complexity
        // 0(N)
        BinaryTree.postOrderTraversal(root);
        System.out.println();

        // levelOrder Traversal( ) time complexity
        // 0(N)
        BinaryTree.levelOrderTraversal(root);
        System.out.println();


      


    }

}

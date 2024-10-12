package Trees.BST;

import java.util.Scanner;

public class Bst {
    // Node class definition
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null; // Initialize left and right pointers to null
            right = null;
        }
    }

    // Method to build the BST
    public static Node BuildBstTree(Node root, int val) {
        if (root == null) {
            // Create a new node if the root is null
            return new Node(val); // Use the value passed as the parameter
        }

        // Recursively insert the value into the left or right subtree
        if (val < root.data) {
            root.left = BuildBstTree(root.left, val);
        } else if (val > root.data) {
            root.right = BuildBstTree(root.right, val);
        }
        // Return the unchanged root pointer
        return root;
    }

    // Method to perform an in-order traversal of the BST (to print values)
    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        }

        else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }

    }
    public static Node deleteNode(Node root, int val) {
        if (root == null) {
            return null;
        }
    
        if (root.data > val) {
            root.left = deleteNode(root.left, val);  // Recur for left subtree
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);  // Recur for right subtree
        } else {  // root.data == val, this is the node to be deleted
    
            // Case 1: No child (Leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
    
            // Case 2: One child (either left or right)
            if (root.left == null) {
                return root.right;  // Return the right child directly
            }
            if (root.right == null) {
                return root.left;  // Return the left child directly
            }
    
            // Case 3: Two children
            // Find inorder successor (smallest in the right subtree)
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;  // Replace root's data with inorder successor's data
            root.right = deleteNode(root.right, IS.data);  // Delete the inorder successor
        }
    
        return root;
    }
    
    // Helper function to find the inorder successor
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    

    // Main method to run the program
    public static void main(String[] args) {
        int arr[] = { 5, 1, 3, 4, 2, 7 }; // Array of values to insert into the BST
        Node root = null; // Initialize the root of the BST

        // Insert each value into the BST
        for (int value : arr) {
            root = BuildBstTree(root, value);
        }

        // Print the in-order traversal of the BST
        System.out.println("In-order Traversal of the BST:");
        inOrderTraversal(root); // Output should be sorted order

        System.out.println("Enter the Key to search : ");

        Scanner sc = new Scanner(System.in);
        int Key = sc.nextInt();
        boolean result = search(root, Key);
        System.out.println(result);

        //take value from user to delete 
        System.out.println("Enter the Value to delete : ");

               int valToDelete = sc.nextInt();


      Node rootAfterDelete=deleteNode(root,valToDelete);
    inOrderTraversal(rootAfterDelete);


        sc.close();
    }
}

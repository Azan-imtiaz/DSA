package Trees.BST;

import static Trees.BST.Bst.BuildBstTree;
import static Trees.BST.Bst.inOrderTraversal;

import java.util.ArrayList;

import Trees.BST.Bst.Node; // Regular import for Node class

public class QuestionsBst2 {

    // Answer Questions No 1 - Print values in the given range [X, Y]
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return; // Base case: if the root is null, just return
        }

        // If root's data is within the range [X, Y], print it
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y); // Traverse left subtree
            System.out.println(root.data); // Print the root's data
            printInRange(root.right, X, Y); // Traverse right subtree
        }
        // If root's data is less than X, look in the right subtree
        else if (root.data < X) {
            printInRange(root.right, X, Y);
        }
        // If root's data is greater than Y, look in the left subtree
        else if (root.data > Y) {
            printInRange(root.left, X, Y);
        }
    }

    // Answer for Question #1 - Print root to leaf node paths
    public static void rootToLeafNodePathsPrint(Node root, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.data); // Add the current node to the path

        // Check if it is a leaf node
        if (root.left == null && root.right == null) {
            printPath(path); // Print the path when a leaf is reached
        } else {
            // If not a leaf, traverse the left and right subtrees
            rootToLeafNodePathsPrint(root.left, path);
            rootToLeafNodePathsPrint(root.right, path);
        }
        path.remove(path.size() - 1); // Remove the current node before backtracking
    }

    // Print the current path from root to leaf
    public static void printPath(ArrayList<Integer> path) {
        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> "); // Arrow to indicate path direction
            }
        }
        System.out.println(); // Move to the next line after printing the path
    }

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

        // Answer for Question #1 - Print values in the range [6, 10]
        System.out.println("Values in range [6, 10]:");
        printInRange(root, 6, 10);

        // Answer for Question #2 - Print root to leaf paths
        System.out.println("Root to Leaf Paths:");
        rootToLeafNodePathsPrint(root, new ArrayList<Integer>());
    }
}

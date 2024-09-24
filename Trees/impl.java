package Trees;

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

    
}

public class impl {
    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Build Tree PreOrder
        Node root = BinaryTree.buildTree(nodes);
        System.out.println();

        // PreOrder Traversal(Root-> Left sub tree -> right sub tree) timw complexity
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


    }

}

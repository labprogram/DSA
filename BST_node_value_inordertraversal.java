// Write a Java program to create a binary search tree (BST) and implement the functions to insert a node, search for a value, and perform an in-order traversal.
// Save the file as BinarySearchTree.java

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null || root.data == data)
            return root != null;
        if (root.data < data)
            return searchRec(root.right, data);
        return searchRec(root.left, data);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice, value;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node");
            System.out.println("2. Search for a value");
            System.out.println("3. In-order traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println("Value inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    value = scanner.nextInt();
                    if (bst.search(value))
                        System.out.println("Value found in the BST.");
                    else
                        System.out.println("Value not found in the BST.");
                    break;
                case 3:
                    System.out.print("In-order traversal of the BST: ");
                    bst.inOrder();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}

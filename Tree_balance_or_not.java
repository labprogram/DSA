// Write a Java program to check whether tree is balanced or not.
// Save the file as BalanceTree.java

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    private int height(Node node) {
        if (node == null) 
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int balanceFactor(Node node) {
        if (node == null) 
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return leftHeight - rightHeight;
    }

    public void checkBalanceFactor() {
        if (checkBalanceFactor(root)) 
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    private boolean checkBalanceFactor(Node node) {
        if (node == null) 
            return true;
        int balanceFactor = balanceFactor(node);
        if (Math.abs(balanceFactor) > 1) 
            return false;
        return checkBalanceFactor(node.left) && checkBalanceFactor(node.right);
    }

    public void constructTree() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data for the root node: ");
        int data = sc.nextInt();
        root = new Node(data);
        constructTree(root, sc);
        sc.close();
    }

    private void constructTree(Node node, Scanner sc) {
        System.out.print("Enter the left child data of " + node.data + " (Enter -1 if no left child): ");
        int leftData = sc.nextInt();
        if (leftData != -1) {
            node.left = new Node(leftData);
            constructTree(node.left, sc);
        }
        System.out.print("Enter the right child data of " + node.data + " (Enter -1 if no right child): ");
        int rightData = sc.nextInt();
        if (rightData != -1) {
            node.right = new Node(rightData);
            constructTree(node.right, sc);
        }
    }
}

public class BalanceTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        tree.constructTree();
        tree.checkBalanceFactor();
        sc.close();
    }
}

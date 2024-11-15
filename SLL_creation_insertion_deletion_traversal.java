// Write a Java program that uses functions to perform the creation, insertion, and deletion and traversal operations on singly linked list.
// Save the file as SinglyLinkedList.java

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void insertAfterNode(int prevData, int data) {
        Node temp = head;
        while (temp != null && temp.data != prevData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("The given previous node is not present in the list.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Data inserted after " + prevData);
    }

    public void deleteByKey(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Key not found in the list.");
            return;
        }
        prev.next = temp.next;
    }

    public void traverse() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.print("Traversing the list: ");
            while (temp != null) {
                System.out.print(temp.data + "--->");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }

    public void createFromList(int[] values) {
        for (int value : values) {
            insertAtEnd(value);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, prevData;
        int[] values;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create list from array");
            System.out.println("2. Insert at beginning");
            System.out.println("3. Insert at end");
            System.out.println("4. Insert after node");
            System.out.println("5. Delete by key");
            System.out.println("6. Traverse");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    values = new int[n];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        values[i] = scanner.nextInt();
                    }
                    list.createFromList(values);
                    System.out.println("List created.");
                    break;
                case 2:
                    System.out.print("Enter data to insert at beginning: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    System.out.println("Data inserted at beginning.");
                    break;
                case 3:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    System.out.println("Data inserted at end.");
                    break;
                case 4:
                    System.out.print("Enter the previous node's data after which to insert: ");
                    prevData = scanner.nextInt();
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAfterNode(prevData, data);
                    break;
                case 5:
                    System.out.print("Enter the key to delete: ");
                    data = scanner.nextInt();
                    list.deleteByKey(data);
                    System.out.println("Node with key " + data + " deleted.");
                    break;
                case 6:
                    list.traverse();
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


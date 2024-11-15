// Write a java program to design a Circular Queue data structure and implement the enqueue() and dequeue() operations using an array.
// Save the file as CircularQueue.java

import java.util.Scanner;

class CircularQueue {
    private int[] queue;
    private int front, rear, size, n;

    public CircularQueue(int n) {
        this.n = n;
        queue = new int[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element: " + element);
            return;
        }
        rear = (rear + 1) % n;
        queue[rear] = element;
        size++;
        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % n;
        size--;
        System.out.println("Dequeued element: " + element);
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front Index -> " + front);
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % n] + " ");
        }
        System.out.println();
        System.out.println("Rear Index -> " + rear);
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the circular queue: ");
        int n = sc.nextInt();
        CircularQueue CQ = new CircularQueue(n);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = sc.nextInt();
                    CQ.enqueue(element);
                    break;
                case 2:
                    CQ.dequeue();
                    break;
                case 3:
                    CQ.display();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

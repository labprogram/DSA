// Write a java program to design a queue data structure and implement the enqueue() and dequeue() operations using an array.
// Save the file as QueueDemo.java

import java.util.*;

class Queue {
    int Q[];
    int front, rear, n;

    Queue(int n) {
        this.n = n;
        Q = new int[n];
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        return rear == n - 1;
    }

    boolean isEmpty() {
        return front == -1 || front > rear;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) front = 0;
            rear++;
            Q[rear] = element;
            System.out.println("Inserted element into Queue is:" + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = Q[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return element;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Elements in the Queue -> ");
            System.out.println("Front index-> " + front);
            for (int i = front; i <= rear; i++) System.out.print(Q[i] + " ");
            System.out.println("\nRear index-> " + rear);
        }
    }
}

class QueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the queue:");
        int n = sc.nextInt();
        char c = 'y';
        Queue q = new Queue(n);
        System.out.println("Queue Operations:");
        System.out.print("\n 1.Enqueue \n 2.Dequeue \n 3.Display\n");
        do {
            System.out.print("Enter your Choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the Queue Element:");
                    int ele = sc.nextInt();
                    q.enQueue(ele);
                    break;
                case 2:
                    System.out.println(q.deQueue() + " is deleted from the Queue");
                    break;
                case 3:
                    q.display();
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.print("Do you want to continue(y/n):");
            c = sc.next().charAt(0);
        } while (c != 'n');
    }
}

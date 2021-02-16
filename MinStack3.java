// I actually saw this solution in leetcode discussion section, and found it to be very brilliant
// Here I am creating a new class Node which has a value, current min, and a pointer to the next node
// Everytime you push an element into the stack, you update the min value if the node is not empty

// Time Complexity : O(1) for all the operations 
// Space Complexity : 

public class MinStack3 {

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack3() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
        MinStack1 s3 = new MinStack1();
        s3.push(5);
        s3.push(12);
        System.out.println("Current top of stack : " + s3.top());
        System.out.println("Current min element in the stack : " + s3.getMin());
        s3.push(1);
        s3.push(0);
        s3.pop();
        System.out.println("Current top of stack : " + s3.top());
        System.out.println("Current min element in the stack : " + s3.getMin());
    }
}

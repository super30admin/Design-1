//We are going to use LinkedList to store every new element at the head of the list and connecting the current root to the new node
//which would become the new root, we will also store the min value with every node,
//and if the min node is removed, the root.next.minSoFar will be the next min value
//Time Complexity: O(1) for all operations
//Space Complexity: O(1)
//Did the code run successfully in leetcode: yes
public class MinStack {

    private Node root;
    private Integer min;

    /**
     * Linked List
     */
    public static class Node {
        Node next;
        int data;
        int minSoFar;

        Node(int data, int minSoFar, Node next) {
            this.data = data;
            this.next = next;
            this.minSoFar = minSoFar;
        }
    }

    //Constructor for MinStack
    public MinStack() {

    }

    //pushes an element onto the top of the stack i.e. at the head of the list
    //and sets the min value if val < min
    public void push(int val) {
        int minSoFar;
        if (this.min == null || val < this.min) {
            minSoFar = val;
            this.min = val;
        }
        else minSoFar = this.min;

        if (this.root == null) {
            this.root = new Node(val, minSoFar, null);
        } else {
            this.root = new Node(val, minSoFar, this.root);
        }
    }

    //removes the top of the stack i.e. the head of the linked list
    //if the popped element is the root element,
    //set the root.next.minSoFar as the min value
    public void pop() {
        final Node pop = this.root;
        if (pop.data == this.min) {
            if (this.root.next == null) this.min = null;
            else this.min = this.root.next.minSoFar;
        }
        this.root = this.root.next;
    }

    //returns the value at the head of linked list
    public int top() {
        return this.root.data;
    }

    //returns min
    public int getMin() {
        return this.min;
    }

    public static void main(String[] args) {
        final MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}

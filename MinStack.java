
public class MinStack {
    int min = 2147483647;
    int insertionCount = 0;
    StackNode head;
    StackNode minNode = new StackNode(2147483647);

    static class StackNode {
        StackNode previousMin;
        int val;
        StackNode previouNode;

        StackNode(int data) {
            val = data;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if (insertionCount < 10) {
            StackNode objNode = new StackNode(val);
            StackNode temp;
            if (insertionCount == 0) {
                head = objNode;
            } else {
                temp = head;
                head = objNode;
                head.previouNode = temp;
            }

            if (val <= minNode.val) {
                head.previousMin = minNode;
                minNode = head;
            }
            insertionCount++;
        } else
            System.out.println("Stack is full");
    }

    public void pop() {
        if (insertionCount > 0) {
            System.out.println(head.val);
            if (head.val == minNode.val) {
                minNode = minNode.previousMin;
            }
            head = head.previouNode;
            insertionCount--;
        } else
            System.out.println("Nothing to pop");
    }

    public boolean isEmpty() {
        if (insertionCount <= 0)
            return true;
        else
            return false;

    }

    public boolean isFull() {
        if (insertionCount >= 10)
            return true;
        else
            return false;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minNode.val;
    }

    public static void main(String[] args) {
        MinStack objMinStack = new MinStack();
        objMinStack.push(22);
        objMinStack.push(2);
        objMinStack.push(1);
        System.out.println(objMinStack.getMin());
        objMinStack.pop();
        objMinStack.push(2);
        objMinStack.push(23);
        objMinStack.push(5);
        objMinStack.push(-22);
        objMinStack.push(-22);
        objMinStack.push(-5);
        objMinStack.pop();
        objMinStack.pop();
        objMinStack.push(-5);

        System.out.println(objMinStack.getMin());

    }
}

import java.util.LinkedList;

public class SplStack {

    LinkedList<Node> linkedList;

    public SplStack() {
        linkedList = new LinkedList<>();
    }

    public void push(int val) {
        int min;
        if (linkedList.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, getMin());
        }
        linkedList.addFirst(new Node(val, min));
    }

    public void pop() {
        linkedList.removeFirst();
    }

    public int top() {
        return linkedList.getFirst().data;
    }

    public int getMin() {
        return linkedList.getFirst().min;
    }

    class Node {
        int data;
        int min;

        Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    // stack class implements stack functionality as LIFO
    Stack<Integer> stack;

    // Priority queue stores data in ascending order which helps to get min data at O(1)
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public MinStack() {
        stack = new Stack<>();
    }
    
    // TC of stack push is O(1) and TC priority queue is O(n) as data swapping might happen
    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }
    
    // TC of stack push is O(1) and TC priority queue is O(n) as data swapping might happen
    public void pop() {
        int element = stack.pop();
        pq.remove(element);
    }
    
    // TC is O(1)
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    // TC is O(1)
    public int getMin() {
        return pq.peek();
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(3);
        minStack.push(5);
        minStack.push(1);
        minStack.push(5);
        minStack.pop();
        System.out.printf("min 1 %d", minStack.getMin());
    }
}
// Time Complexity :    O(1) for all operations
// Space Complexity :   O(n)
//  Yes, It's run successfully
// No I don't face any problem.



import java.util.ArrayList;
import java.util.Stack;

public class MinStack155LeetCode {

    public static void main(String[] args) {
//		MinStack1 minStack = new MinStack1();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println(minStack.getMin());
//		minStack.pop(); // return 0
//		System.out.println(minStack.top());
//
//		System.out.println(minStack.getMin());// return -2



//		MinStack2 minStack = new MinStack2();
//		minStack.push(512);
//		minStack.push(-1024);
//		minStack.push(-1024);
//		minStack.push(512);
//		//System.out.println(minStack.getMin());
//		minStack.pop(); // return 0
//
//		System.out.println(minStack.getMin());
//		minStack.pop();
//		System.out.println(minStack.getMin());
//		minStack.pop();
//		//System.out.println(minStack.top());
//
//		System.out.println(minStack.getMin());// return -2

        MinStack3 minStack = new MinStack3();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        //System.out.println(minStack.getMin());
        minStack.pop(); // return 0
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        //System.out.println(minStack.top());
        System.out.println(minStack.getMin());// return -2
        minStack.pop();
        System.out.println(minStack.getMin());// return -2
    }

}

class MinStack3 {

    //one stack approach O(1) time complexity for all
    Stack<Integer> elementStack;
    int min;

    public MinStack3() {
        elementStack = new Stack<Integer>();
    }

    public void push(int val) {
        if(elementStack.isEmpty()) {
            min = val;
            elementStack.push(val);
        }
        else {
            if(val<=min) {
                elementStack.push(min);
                min=val;
                elementStack.push(val);
            }
            else {
                elementStack.push(val);
            }
        }

    }

    public void pop() {
        System.out.println("Capacity"+elementStack.size());
        if(top()==min) {
            if(elementStack.size()==1) {
                elementStack.pop();
            }
            else {
                elementStack.pop();
                min = elementStack.peek();
                elementStack.pop();
            }
        }
        else {
            elementStack.pop();
        }

    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack2 {

    //two stack approach O(1) time complexity for all
    Stack<Integer> elementStack;
    Stack<Integer> minStack;

    public MinStack2() {
        elementStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        if(minStack.isEmpty()) {
            minStack.push(val);
        }
        else {
            if(val<=minStack.peek()) {
                minStack.push(val);
            }
        }
        elementStack.push(val);
    }

    public void pop() {
        //System.out.println(minStack.peek() == elementStack.peek());
        if(minStack.peek().equals(elementStack.peek())) {
            minStack.pop();
        }
        elementStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */






class MinStack1 {
    // brute force approach O(n) time complexity in pop
    int top = -1;
    int min = Integer.MAX_VALUE;

    ArrayList<Integer> list = new ArrayList<Integer>();
    public MinStack1() {

    }

    public void push(int val) {
        if(val <min) {
            min = val;
        }
        list.add(++top, val);
    }

    public void pop() {

        if(top() == min) {
            min = Integer.MAX_VALUE;
            int tempTop = top-1;
            while(tempTop!=-1) {
                if(list.get(tempTop) < min ) {
                    min = list.get(tempTop);
                }
                tempTop--;
            }
        }
        list.remove(top--);
    }

    public int top() {
        return list.get(top);

    }

    public int getMin() {
        return min;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

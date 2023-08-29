import java.util.Stack;

class MinStack {
    //variable declaration
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;

    //Constructor
    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
        min=Integer.MAX_VALUE;   //to give infinity value
        minStack.push(min);  //Time complexity is linear time i.e O(1)
    }

    public void push(int val) {
        if (val<=min){  //condn to check if the val is smaller than the min
            min=val;
        }
        s.push(val);
        minStack.push(min);
    }

    public void pop() {
        s.pop(); //pop the top element
        minStack.pop(); //pop the top element from minStack
        min=minStack.peek();

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack ms= new MinStack();
        ms.push(3);
        ms.push(5);
        ms.push(2);
        ms.push(7);

        System.out.println("Top element: " + ms.top());
        System.out.println("Minimum element: " + ms.getMin());

        ms.pop();
        System.out.println("Top element after pop: " + ms.top());
        System.out.println("Minimum element after pop: " + ms.getMin());
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
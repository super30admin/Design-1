import java.util.Stack;

class MinStack2 {
    Stack<Integer> s;
    int min;

    public MinStack2() {
        s= new Stack<>();
        min = Integer. MAX_VALUE;
    }

    public void push(int val) {
        if(val<=min)
        {
            s.push(min);
            min=val;
        }
        s.push(val);
    }

    public void pop() {
        int popped=s.pop();
        if(popped==min){
            min=s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin()); // ans=1
        minStack.pop();
        System.out.println(minStack.top());    // ans=2
        System.out.println(minStack.getMin()); // ans=2
    }
}
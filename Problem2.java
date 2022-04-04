import java.util.Stack;

class MinStack{
    int minValue;
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack(){
        minValue = Integer.MAX_VALUE;
        stack = new Stack<>();
        min = new Stack<>();
        min.push(minValue);
    }
    

    public void push(int val){
        if(val <= minValue){
            minValue = val;
        }
        stack.push(val);
        min.push(minValue);
    }

    public void pop(){
        stack.pop();
        min.pop();
        minValue = min.peek();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
    }
}
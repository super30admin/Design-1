import java.util.Stack;

public class MinStack {
    private int min;
    private Stack<Integer>stack;

    MinStack(){
        min= Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int val){
        //if the value is lesser than min, push the min value, assign the min value with val and also push the val to stack.
        if(val<=min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }

    public void pop(){
        //if the value popped is min value, assign the min with with next popped value (as it is next min)
        if(stack.pop()==min)
        {
            min = stack.pop();
        }
    }

    public int getMin(){
        return min;
    }

    public int top(){
        return stack.peek();
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Min: "+obj.getMin());
        obj.pop();
        System.out.println("Min: "+obj.top());
        System.out.println("Min: "+obj.getMin());
    }

}
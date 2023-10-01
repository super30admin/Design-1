import java.util.Stack;

// the solution is such that i will have one stack taking input and the other keeping track of the minimum elements
// stack 1 -> 1,2,3,4,5,6,7,4,3,6
// stack 2 -> 1,1,1,1,1,1,1,1,1,1
//time complexity for all : O(1)
//space complexity for all: O(1)

public class MinStackImplement {
    //operations are push, pop, top and getMin
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int min;

    public MinStackImplement(){
        this.min = Integer.MAX_VALUE;
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
        this.stack2.push(min);
    }
    
    public void push(int val) {
       this.min = Math.min(val, min);
       stack1.push(val);
       stack2.push(min);
    }
    
    public void pop() {
        stack1.pop();  
        stack2.pop();
        this.min = stack2.peek();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String args[])
    {
        MinStackImplement minStackImplement = new MinStackImplement();

        minStackImplement.push(1);
        minStackImplement.push(1);
        minStackImplement.push(3);
        minStackImplement.push(-5);

        System.out.println("Min" + minStackImplement.getMin());
        System.out.println("Top" + minStackImplement.top());

        minStackImplement.pop();

        System.out.println("Min" + minStackImplement.getMin());
        System.out.println("Top" + minStackImplement.top());
        
    }

}

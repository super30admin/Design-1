import java.util.Stack;

public class SpecialStack {

    /** initialize your data structure here. */
    private int count;
    private static int MAX = 10000;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> specialStack;
    
    public SpecialStack() {
       specialStack = new Stack<>();
        
    }
    
    public void push(int x) {
        if(isFull()){
            System.out.println("Stack is overflow");
            return;
        }
        if(isEmpty()){
            min = Integer.MAX_VALUE;
            specialStack.push(min);
             count++;
        }
        else if(min >= x){
            specialStack.push(min);
             count++;
        }
        specialStack.push(x);
        min = Math.min(min,x);
        count++;
    }
    
    public int pop() {
        if(isEmpty()){
            return 0;
        }
        int result = specialStack.pop();
        if(result <= min){
            min = specialStack.pop();  
            count--;
        }
        count--;
        return result;
    }
    
    public int top() {
        return specialStack.peek();
    }
    
    public int getMin() {
        return min;
    }
    
    public boolean isEmpty(){
        if(count <= 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(count >= MAX){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        SpecialStack obj = new SpecialStack();
        obj.push(5);
        obj.push(-1);
        System.out.println("Current minimum " +obj.getMin());
        obj.push(4);
        System.out.println("Current minimum " +obj.getMin());
        System.out.println(obj.pop() + " Popped from the stack");
        System.out.println("Current minimum " +obj.getMin());
        System.out.println(obj.pop() + " Popped from the stack");
        System.out.println("Current minimum " +obj.getMin());
        
    }
} 
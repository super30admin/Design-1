import java.util.Stack;

public class MinStack {
    
Stack<Integer> minstack;
    int min;
    public MinStack() {
        this.minstack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        
        if(val<=min)
            {
                //minstack.push(min);
                min = val;
            }
            minstack.push(val);
    }
    
    public void pop() {
        if(minstack.pop() == min)
            min = minstack.pop();
    }
    
    public int top() {
        return minstack.peek();
    }
    
    public int getMin() {
        return min;
    }

   
public static void main(String[] args) {
     
 //Your MinStack object will be instantiated and called as such:
    MinStack obj = new MinStack();
    obj.push(4);
    //System.out.println("min is "+obj.getMin()+ "top is "+obj.top());
    obj.minstack.forEach(System.out::println);
    System.out.println("*");
    obj.push(5);
    // System.out.println("min is "+obj.getMin()+ "top is "+obj.top());
      obj.minstack.forEach(System.out::println);
       System.out.println("*");
    obj.push(3);
    /// System.out.println("min is "+obj.getMin()+ "top is "+obj.top());
     obj.minstack.forEach(System.out::println);
      System.out.println("*");
    obj.pop();
   //  System.out.println("min is "+obj.getMin()+ "top is "+obj.top());
     obj.minstack.forEach(System.out::println);
      System.out.println("*");
    int param_3 = obj.top();
    int param_4 = obj.getMin();
 
}
}



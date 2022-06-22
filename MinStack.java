import java.util.Stack;

public class MinStack {
 Stack<Integer> stack= new Stack();
 Stack<Integer> min_stack= new Stack();

public void push(int val){

 if(min_stack.isEmpty() || val< min_stack.peek()){
  min_stack.push(val);
 }
  stack.push(val);
}
public void pop(){

 if(stack.peek().equals(min_stack.peek())){
    min_stack.pop();
 }
  stack.pop();
}
public int top() {
   return stack.peek();

}
public int getMin() {
   return min_stack.peek();

}

 }

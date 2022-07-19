// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.Stack;
import java.util.*;
import java.io.*;
class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> aux;
    
public MinStack() {
    s=new Stack<>();
    aux=new Stack<>();
}

public void push(int val) {
     s.push(val);
    if(aux.isEmpty()){
        aux.push(val);
    }
    else if(aux.peek() >= val){
        aux.push(val);
    }
}

public int pop() {
    if (s.isEmpty()){
        System.out.println("Stack is empty");
        System.exit(-1);
    }
    int top = s.pop();
    if(top == aux.peek()){
        aux.pop();
    }
    return top;

}

public int top() {
            return s.peek();

}

public int getMin() {
    if(aux.isEmpty()){
        System.out.println("Stack underflow!");
        System.exit(-1);
    }
    return aux.peek();
}
/**
* Your MinStack object will be instantiated and called as such:
* MinStack* obj = new MinStack();
* obj->push(val);
* obj->pop();
* int param_3 = obj->top();
* int param_4 = obj->getMin();
*/
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(val);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/
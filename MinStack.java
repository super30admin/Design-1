import java.util.*;
public class MinStack {

    int minEle;
    Stack<Integer> s;

    public MinStack() {
        minEle = Integer.MAX_VALUE;
        s = new Stack<Integer>();
        
    }
    
    public void push(int val) {

        if(s.isEmpty()) {
     	    minEle = val;
            s.push(val);
            return;
            
     	} else if(val < minEle) {
     	    s.push(2*val - minEle);
     	    minEle = val;
     	} else {
            s.push(val);
         } 
    }
    
    public void pop() {
      if(s.isEmpty()) return;

      int top = s.peek();
      s.pop();

	  if(top < minEle) {
	       minEle = 2*minEle - top;
	       return;
	  } 
      
    }
    
    public int top() {

        if(s.isEmpty()) return -1;

        int top = s.peek();

        return (top < minEle) ? minEle : top;
        
    }
    
    public int getMin() {
      
      if(s.isEmpty()) return -1;
	  return minEle;
    }
    
}

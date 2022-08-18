// Time Complexity : push -O(1), pop-O(1), top-O(1) , Min-O(1)
// Space Complexity : O(n+m) where n is no. of item, m is no. of unique min 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

//1:1 mapping 

class MinStack1 {
    Stack<Integer> data;
    Stack<Integer> minst; 
    int min;

    public MinStack() {
        data = new Stack<>();
        minst = new Stack<>();
        min = Integer.MAX_VALUE; 
        minst.push(min);
    }
    
    public void push(int val) {
        data.push(val);
        if( val < min ){
            min = val;
        }
        minst.push(min);
    }
    
    public void pop() {
        data.pop();
        minst.pop();
        min = minst.peek();
    }
    
    public int top() {
         return data.peek();
    }
    
    public int getMin() {
        return min;
    }
}

// 1 stack only 
class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
        data = new Stack<>();
        min = Integer.MAX_VALUE; 
        data.push(min);
    }
    
    public void push(int val) {
        if (val <= min){
            data.push(min);
            min= val;
        }
        data.push(val); 
    }
    
    public void pop() {
      
        if (min == data.peek()){
            data.pop();
            min= data.peek();
        }
          data.pop();  
    }
    
    public int top() {
         return data.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
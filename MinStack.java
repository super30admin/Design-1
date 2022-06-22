/**Time Complexity :
    O(n)
// Space Complexity :
    we are using 2 stacks hence O(n^2)
// Did this code successfully run on Leetcode :
     Accepted but not submitted
// Any problem you faced while coding this :   
     Got emptystack exception while peeking the minStack top element. Solved it using condition to check if not empty.
// Your code here along with comments explaining your approach**/

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;
    int min;

    //Initializing stack
    public MinStack() {
        s=new Stack<Integer>();
        minS=new Stack<Integer>();
        min=Integer.MAX_VALUE;
        
    }
    
    //if min value is greater than value to push then push the new value to minStack.
    public void push(int val) {
        s.push(val);
        if(min>val){
            min=val;
            minS.push(min);
        }
        
        
    }


    //remove the min element from minStack and assign top element as min element. conditions to avoid empty stack exception.
    public void pop() {
         if(!s.isEmpty()){
            s.pop();
        }
        
        if(!minS.isEmpty()){
             minS.pop();
        }
       
        if(!minS.isEmpty()){
          min=minS.peek();  
        }
        
        
    }


    //to get the top elemnt in stack
    public int top() {
        return s.peek();
        
    }

    //to get the min element which is the top of minStack
    public int getMin() {
          if(!minS.isEmpty()){
          return minS.peek(); 
        }
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// Time Complexity : O(1) for push, POP O(1) auxilary tending to O(1)
// Space Complexity : O(n) as taking another stack to implement the Queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : While Popping the Queue item one return statement is compulsary cannot keep in the if, else condition


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
        
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }               
        return out.pop();
    }
//No need to write else just do return out.pop() always as given no wrong function will take place;
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
     if(in.isEmpty() && out.isEmpty()){
         return true;
     }else{
         return false;
     }   
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

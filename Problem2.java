import java.util.Stack;

//Time Complexity : 
	/*
	 * push(): O(1)
	 * peek(): O(N)
	 * pop(): O(N)
	 */
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : later optimised the code 


//Your code here along with comments explaining your approach
/*
* Need to store popped elements from primary stack
* to reverse the order of elements and function as queue
* in secondary stack
* 
*/

class MyQueue {

    Stack<Integer> st1;
    //Using stack 2 for temporary storing of elements
    Stack<Integer> st2 = new Stack<>();
    
    public MyQueue() {
       st1 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
            //transfer elements from st1 --> st2
            while(!st1.empty()){
                st2.push(st1.pop()); 
            } 
        }
        return (Integer) st2.pop();   
    }
    
    public int peek() {
        if(st2.isEmpty()){
            //transfer elements from st1 --> st2
            while(!st1.empty()){
                st2.push(st1.pop()); 
            } 
        }
        return (Integer) st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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
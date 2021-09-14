import java.util.Arrays;

// Time Complexity : O(1) for all the methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class MyHashMap {
    
    int map[];

   /** Initialize your data structure here. */
   public MyHashMap() {
       // Keeping the constrains in mind we make a large array.
       map = new int[1000001];
       Arrays.fill(map, -1);
   }
   
   /** value will always be non-negative. */
   public void put(int key, int value) {
          map[key] = value;          // Rather than using a for loop to initialize the array we 
   }
   
   /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
   public int get(int key) {
       
       return map[key];
   }
   
   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
   public void remove(int key) {
         map[key] = -1;
   }
}

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/


// Time Complexity : O(1) for all the methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk;
    Stack<Integer> mnstk;
    
    public MinStack() {
        stk = new Stack<>();
        mnstk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.empty() || val <= mnstk.peek()) {  //if stack is empty and value is less than the min_value
            mnstk.push(val);
        }
        stk.push(val);
    }
    
    public void pop() {
         if(stk.peek().equals(mnstk.peek())) {    // Checking if the value of both stacks are same
            mnstk.pop();                      
         }
            
        stk.pop();
    }
    
    public int top() {
         return stk.peek(); //returns the topstack
    }
    
    public int getMin() {
        return mnstk.peek(); //returns the minstack
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
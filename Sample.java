//Problem_1

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I encountered a lot of runtime errors but each time
// I run the code, it shows accepted but when I submit it, I get a runtime error.


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */
    int [] hashMap = null;
    
    public MyHashMap() {
        hashMap = new int[1000001]; //Initialize a new integer array to the size given
        Arrays.fill(hashMap, -1); //updates the array to -1
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap[key] = value; //Updates the map at that particular index to the value
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap[key]; //returns the map at that particular index
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        put(key, -1); //passes -1 to the key because we don't need to return
                    // any value to a void function.
    }
}

//NB: key is the same as the index

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 //Problem_2

 // Time Complexity :O(1) - constant because stack is used
// Space Complexity : O(n)- n is the number of element that would be added to the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : A lot. I thought it was going 
//to be easy but I struggled a lot both with the syntax and algorithm
//implementation.

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    int minimumValue;
        
    /** Constructor */
    public MinStack() {
        this.stack = new Stack<>();
        minimumValue = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) { //Adds element to the list
       if(val <= minimumValue){ //Checks if the value in the stack 
           //and the value in the supporting stack is less than or              cequal to each other
           stack.push(minimumValue); //moves the stack to the                                              // supporting stack if it is less than the value at the top 
           minimumValue = val; 
       }
        stack.push(val);
    }
    
    public void pop() { //Deletes elements from the top of the list
        if(stack.pop() == minimumValue) {
            minimumValue = stack.pop(); //Removes the top value from the stack. If the stack and supporting stack have the same value at the top, they are both removved.
            
        }
    }
    
    public int top() { //gets the top element
        return stack.peek();
    }
    
    public int getMin() { //gets the minimum value in the stack
        return minimumValue;
        
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

//NB: For stack, the most recent element goes to the top of the list.
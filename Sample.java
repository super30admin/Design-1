// Problem -1

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyHashMap {
    List<List<Integer>> list = new ArrayList<>(); // created a list of lists to store the key value pairs
    /** Initialize your data structure here. */
    public MyHashMap() {
       
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       
        for(int i=0; i< list.size(); i++) // looping through the outer list of key-value pairs
        {
            if(list.get(i).get(0) == key) // checking if the any value of keys in the list matches the key i.e element at key already present, so need to update it
            {  
                list.remove(i); // if matches removed the pair from the list
                break; // and exit the loop
            }

        }
            List<Integer> l = new ArrayList<>(); // created a new inner list
            l.add(key); // inserted key and value
            l.add(value);
            list.add(l); // added the list as one element to the outer list
       
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) { 
        
        for(int i=0; i< list.size(); i++) // looping through the outer list of key-value pairs
        {
            if(list.get(i).get(0) == key) // checking if the any value of keys in the list matches the key i.e element present
            {
               return list.get(i).get(1); // return the value at the key
            }
        }
        
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
          for(int i=0; i< list.size(); i++) // looping through the outer list of key-value pairs
        {
              if(list.get(i).get(0) == key)  // checking if the any value of keys in the list matches the key i.e element found
            {
                  list.remove(i); // remove the pair from the list
                  break; // exit the loop
            }
         }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


 //Problem - 2
 // Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Problem encountered when using stack.peek == min.peek() in the pop method. Got resolved using equals but unable to figure out why


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack = new Stack<>(); // created one stack for stack operations
    Stack<Integer> min = new Stack<>(); // created second stack for returning min element of stack
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        
        stack.push(x); // pushing element in stack
        if(min.isEmpty() || x <= min.peek()) // if min stack is either empty or the value inserted in stack is less than the least value encountered till now
            min.push(x); // push it to min stack
            
    }
    
    public void pop() {
       
       
        if(!min.isEmpty() && stack.peek().equals( min.peek())) // if min stack is not empty and value to be popped is present in the min stack
            min.pop(); // pop value from min stack
        
        if(!stack.isEmpty()) // if stack is not empty
            stack.pop(); // pop the topmost element
            
    }
    
    public int top() {
        
        if(!stack.isEmpty()) // is stack is not empty
             return stack.peek(); // return topmost element
      return -1; // if no element present returning -1
    }
    
    public int getMin() {
        if(!min.isEmpty()) // if stack is not empty
            return min.peek(); // return the least element of stack denoted by top of min stack
        return -1; // else if no element present return -1
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
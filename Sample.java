// Time Complexity : O(N)
// Space Complexity : O(N) and 47.1 mb on leetcode
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : optimise the time complexity


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    int a[]; // an array
    int top; // top index of the stack 
    public MinStack() {
        a= new int[1000000];
        top=-1; // initially initialised top to -1 since there are no elements in the stack    
    }
    
    public void push(int val) {
         a[++top]= val; //add an element to the stack and increment the top 
    }
    
    public void pop() {
        top--; //decrement the top to point to the second last element
    }
    
    public int top() {
        return a[top]; //show the latest first element 
    }
    
    public int getMin() {
        int min= a[top]; //calculate the min by looping around the array and checking for the smallest element 
        for(int i=0;i<top;i++)
        {
            if(a[i]<min)
            {
                min=a[i];
            }
        }
        return min; //return the min element found
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


// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : NO
// Any problem you faced while coding this : yes I don't know how to implement a hashmap

class MyHashMap {

    /** Initialize your data structure here. */
    public MyHashMap() {
            int value;
            int key;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
            MyHashMap obj = new MyHashMap();
        obj.key=key;
        obj.value=value; 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
         if(obj.present(key)) //if key is present in the key 
        {
            return obj.value; //return corresponding value
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
          if(key.present)
        {
            this.key=null;
            this.value= null; 
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
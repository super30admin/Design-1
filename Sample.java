// Time Complexity : Push - O(1), Pop -> O(1), Min -> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : not sure about the space complexity as this is what we have to return so will this stack space be included in the space complexity.


// Your code here along with comments explaining your approach

/* 
    While pushing elements onto stack we keep track of the min element.
 */
class MinStack {
    Stack<int[]> stack;
    public MinStack() {
       stack = new Stack<>(); 
    }
    
    public void push(int x) {
       if(stack.isEmpty()){
            stack.push(new int[]{x,x});
        }else{
            stack.push(new int[]{x,Math.min(x,stack.peek()[1])});
        } 
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}


// Time Complexity : Add - O(1), Remove -> O(1), Get -> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : not sure about the space complexity as this is what we have to return so will this stack space be included in the space complexity.


// Your code here along with comments explaining your approach

/* 
    Initialize an array to hold elements
 */
class MyHashMap {
    int[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000000];
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key < 0 || key > 1000000)
            return -1;
        else
            return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}
 

// Time Complexity : O(N) as it uses contains method
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Time complexity is not O(1) for all operations


// Your code here along with comments explaining your approach
/**
 * This code makes use of two linked lists one for storing keys and other for values. Values are mapped on the basis
 * of index for the keys in keys linked list.
 */
import java.util.*;

class MyHashMap {
    List<Integer> keys;
    List<Integer> values;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(keys.contains(key)) {
            values.set(keys.indexOf(key), value);
        }
        else {
            keys.add(key);
            values.add(value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(!keys.contains(key)) {
            return -1;
        }
        else {
            return values.get(keys.indexOf(key));
        }
    }
    
    public void remove(int key) {
        if(keys.contains(key)) {
            int i = keys.indexOf(key);
            values.remove(i);
            keys.remove(i);
        }
    }
}


// Time Complexity : O(1) for push, pop, top and getMin
// Space Complexity : O(N) which is stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * This code makes use of stack of integer array of size 2. First element in array is element to be pushed and 
 * second element is lowest value till that element in stack.
 */

class MinStack {

    /** initialize your data structure here. */
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty())
            stack.push(new int[]{x, x});
        else {
            int min = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, min)});
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




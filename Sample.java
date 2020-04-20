// Time Complexity : O(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not understand how the leetcode soluction is better. And its timecomplexity. current runtime: Runtime: 25 ms, faster than 32.71%


// Your code here along with comments explaining your approach
// Create an array of upperbound 10000. If a key is 2 with value 5. It will be stored like this [][][5][]...[n]
class MyHashMap {
    int[] store;
    boolean[] seen;
    /** Initialize your data structure here. */
    public MyHashMap() {

        store = new int[100000];
        seen = new boolean[100000];
    }

    /** value will always be non-negative. */
    /**
     *
     * @param key will act as a specfic index of the store array
     * @param value stored at the key address
     */
    public void put(int key, int value) {

        this.store[key] = value;
        this.seen[key] = true;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */


    public int get(int key) {
        int val;
        if(this.seen[key]){
            val = this.store[key];
        }else{
            val = -1;
        }
        return val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        this.store[key] = -1;
        this.seen[key] = false;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

//Question two:
//Runtime: Runtime: 4 ms, faster than 89.68% of Java online submissions for Min Stack.
import java.util.*;
class MinStack {

    public class pair {
        int min;
        int val;

        pair(int val, int min) {
            this.val = val;
            this.min=min;
        }
    }

    /** initialize your data structure here. */
    Stack<pair> s;

    public MinStack() {
        s= new Stack<pair>();
    }

    public void push(int x) {
        if(s.isEmpty()){
            s.push(new pair(x,x));
        }else{
            int currentMin= s.peek().min;
            if(currentMin < x){
                s.push(new pair(x,currentMin));
            }else{
                s.push(new pair(x,x));
            }
        }
    }

    public void pop() {
        if(!s.isEmpty()){
            s.pop();
        }
    }

    public int top() {
        if(!s.isEmpty()){
            return s.peek().val;
        }
        return -1;
    }

    public int getMin() {
        return s.peek().min;

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

// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I used an extremely brute force approach by iterating arrays. But then realized, the below approach. I had first initialized the size incorrectly.


// Your code here along with comments explaining your approach

class MyHashMap {

   int[] arr;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
       arr = new int[1000001];
       Arrays.fill(arr, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
	}
    
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}

// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Ran for one case but failed on a few edge cases. Hence, wrong answer
// Any problem you faced while coding this : At first, my approach was related to only the current minimum element. Was stuck on getting the previous minimum. Had to refer to a solution, it got through one case but missed on a few edge cases. Hence,it is the wrong answer


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
            stack.push(x);
        }
        else if(x<min){
            int temp = 2*x-min;
            stack.push(temp);
            min = x;
        }
        else{
            stack.push(x);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int temp = top();
            if(temp<min){
                min = 2*min - temp;
            } 
            stack.pop();
        }       
    }
    
    public int top() {
        return stack.peek();   
    }
    
    public int getMin() {
        return min;
    }
}
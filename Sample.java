//Problem 1
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {

    /** Initialize your data structure here. 
        Initialized an array for creating the HashMap
    */
    
    /** Space complexity is the size of the array
        Time Complexity is also the size of the array as we iterate and fill the             array, TIme Complexity of all the methods are O(1)
    */
    int array[];      
    public MyHashMap() {
        array = new int[1000001];   // Defined the size of array as per constraints
        Arrays.fill(array, -1);     // Filled the whole array with -1
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        array[key] = value;         // Put the value in the index of the array
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return array[key];          // Return the value at that index
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        array[key] = -1;           // replace the value at that index by -1
    }
}

//Problem 2 : Approach 1 using stack
// Time Complexity : O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    /** Space Complexity is 2N 
        Time Complexity is O(1)
    */
    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack();
    Stack<Integer> minimums = new Stack();
    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if(minimums.isEmpty() || minimums.peek() >= val){
            minimums.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minimums.peek())){
            minimums.pop();
        }
      stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return minimums.peek();
    }
}
//Problem 2 : Approach 1 using priority queue
//     Stack<Integer> stack = new Stack();
//     PriorityQueue<Integer> pq = new PriorityQueue();
    
//     public void push(int val) {
//         stack.push(val);
//         pq.add(val);
//     }
    
//     public void pop() {
//         int temp = stack.peek();
//         stack.pop();
//         pq.remove(temp);
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         int temp = pq.poll();
//         pq.add(temp);
//         return temp;
//     }
// }

//Design-1 Implementing Hash Map
// Time Complexity :O(1) for put,get , remove operation
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I have implemented using bruteforce approach. I faced issue optimizing the code using LinkedList
class MyHashMap {
    int arr[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr=new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key]=value+1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key]-1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key]=0;
    }
}

// Your code here along with comments explaining your approach

//Design-2 Min Stack
// Time Complexity :O(1) as push,pop,top,getMin functions will take O(1) time
// Space Complexity :O(n) as i am using 2 stacks and worst case we will be storing all the elements in stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No problem after understanding the question i got idea of using 2 stacks.


// Your code here along with comments explaining your approach
class MinStack {
    //creating final and Min stack
    Stack<Integer> st;
    Stack<Integer> MinSt;//It will store the min elements

    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<>();
        MinSt=new Stack<>();
    }

    public void push(int val) {
        st.push(val);//pushing the element into final stack
        if(MinSt.isEmpty()) MinSt.push(val);//pusing into Min stack
        else if(val<=MinSt.peek()) MinSt.push(val);

    }

    public void pop() {
        int a=st.peek();
        if(!st.isEmpty()) st.pop();
        if(!MinSt.isEmpty()&&MinSt.peek()==a) MinSt.pop();

    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return MinSt.peek();

    }
}
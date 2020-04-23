// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Point{
    int key,value;
    Point(int key,int value){
        this.key=key;
        this.value=value;
    }
}

class MyHashMap {
    
    List<List<Point>> list;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new LinkedList<>(); 
        for(int index=0;index<10000;index++)
            list.add(new LinkedList<Point>());
    }
    
    public int exists(int key,int index) {
        
        List<Point> tmpList = list.get(index);
        int pos = 0;
        for(Point p:tmpList){
    
            if(p.key==key)
                return pos;
            pos++;
        }
        
        return -1;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int newKey=key%10000;
        int pos = exists(key,newKey);
        
        if(pos!=-1){
            list.get(newKey).set(pos, new Point(key,value));
        }else{
            list.get(newKey).add(new Point(key,value));
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int newKey=key%10000;
        int pos = exists(key,newKey); 
        if(pos!=-1)
            return list.get(newKey).get(pos).value;
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
       int newKey=key%10000;
        int pos = exists(key,newKey); 
        // Point p = list.get(newKey).get(pos);
            
        if(pos!=-1)
            list.get(newKey).remove(pos);
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Time Complexity : Each of the operation will be O(1)
// Space Complexity : Each of the operation will be O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

 class MinStack {
    int min;
    Stack<Integer> st;
    /** initialize your data structure here. */
    public MinStack() {
        min=Integer.MAX_VALUE;
        st= new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x<=min){
            st.push(min);
            min=x;
            st.push(x);
        }else{
            st.push(x);
        }
    }
    
    public void pop() {
        if(st.pop()==min)
            min=st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
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

//HASH MAP
// Time Complexity : best case for get,put,remove is O(1) worst case is O(n)
// Space Complexity :Big-oh(n), the growth is linear with increase in entries
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Didnt understand how to decide on what the size of my table should be.


// Your code here along with comments explaining your approach
class MyHashMap {
     private int size= 1024;
     private Node[] table = new Node[size];
       public class Node{
        public int key;
        public int value;
        public Node next;
        public Node( int key ,int value)
        {
            this.key=key;
            this.value=value;
        }
       }
    /** Initialize your data structure here. */
    public MyHashMap() {
         
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash= Objects.hashCode(key);
        int index= hash & (size-1);
        Node p;
        if((p=table[index])==null)
        {
            table[index]=new Node(key,value);
        }
        else if(p.key==key)
            p.value=value;
        else
        {
            Node pre;
            do{
                pre=p;
                p=p.next;
            
            }while(p!=null&& p.key!=key);
            if(p==null)
                pre.next=new Node(key,value);
            else
                p.value=value;
                
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash= Objects.hashCode(key);
        int index= hash &(size-1);
        Node p= table[index];
        while(p!=null && p.key!=key)
            p=p.next;
        return p== null ? -1: p.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = Objects.hashCode(key);
        int pos = hash & (size - 1);
        Node p = table[pos];
        if (p == null) {
            return;
        }

        if (p.key == key) {
            table[pos] = p.next;
        } else {
            Node pre;
            do {
                pre = p;
                p = p.next;
            } while (p != null && p.key != key);

            if (p != null) {
                pre.next = p.next;
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

//MIN STACK
// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No, did this from what I got from the class


// Your code here along with comments explaining your approach

class MinStack {
    
    private Stack<Integer> stack;
    private Integer min;    
    /** initialize your data structure here. */
    public MinStack() {
        stack =new Stack();
        min= Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min)
        {
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int popped= stack.pop();
        if(popped==min)
        {
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
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

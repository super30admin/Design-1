import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
//Implementation of Hashmap
//Time Complexity - O(1)
//Space Complexity - O(N)
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    
    LinkedList<Entry>[] bucket;
    final int SIZE = 1000; 
    
    //entry class
    class Entry{
            int key;
            int val;
            public Entry(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
   
    public MyHashMap() {
        bucket = new LinkedList[SIZE];
        for (int i = 0;i<bucket.length;i++)
            bucket[i] = new LinkedList<Entry>();
    }
    
    
    public void put(int key, int value) {
        int index = getHash(key);
        LinkedList<Entry> entryLink = bucket[index]; 
        // if the key is available then remove it // same as update
        if (get(key) != -1) remove(key);   
        //Else
        Entry entry = new Entry(key, value); 
        entryLink.add(entry);    
    }
    
// Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key 
    public int get(int key) {
        int index = getHash(key);
        LinkedList<Entry> entryLink = bucket[index]; 
        Iterator<Entry> it = entryLink.iterator();
        while(it.hasNext()){
           Entry entry = it.next();
           if(entry.key == key) return entry.val;
        }
        return -1;
    }
    
// Removes the mapping of the specified value key if this map contains a mapping for the key 
    public void remove(int key) {
        int index = getHash(key);
        LinkedList<Entry> entryLink = bucket[index]; 
        Iterator<Entry> it = entryLink.iterator();
        while(it.hasNext()){
           Entry entry = it.next();
           if(entry.key == key) it.remove();
        }
    }
//Hash function
    public int getHash(int key){
        return key % SIZE;
    }
}
//Minimum in the stack implementation
    //Time Complexity - O(1)
    //Space Complexity - O(N)
    //Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    class MinStack{
        //Create two stacks 
        //stk--> which contains all elements pushed
        //minstk--> minmum valued elements 
        Stack<Integer> stk;
        Stack<Integer> minstk;

        MinStack(){
            stk = new Stack<>();
            minstk = new Stack<>();
        }

        public void push(int val){
            //if minstk is empty condition if its firstt element 
            //or if the val enter is less than the element in minstk which contains minimum
            //then push it in minstk
            if(minstk.isEmpty() || val <=getMin()){
                minstk.push(val);
            }
            //push in stk
            stk.push(val);
        }
        public void pop(){
            //If the top element of minstk = getMin(), is equal to top element of stk then pop from minstk
            if(stk.peek()==getMin()){
                minstk.pop();
            }
            //pop from stk
            stk.pop();
        }
        public int top(){
            return stk.peek();
        }
        public int getMin(){
            return minstk.peek();
        }

    }
        class Main{
            public static void main(String args[]){
                MyHashMap map = new MyHashMap();
                map.put(10,12);
                map.put(20,11);
                map.remove(20);
               int a = map.get(10);
               System.out.println(a);
               MinStack stk = new MinStack();
               stk.push(10);
               stk.push(20);
               stk.push(30);
               stk.pop();
               int topelement =stk.top();
               int minelement = stk.getMin();
               System.out.println(topelement);
               System.out.println(minelement);
            }
        }
    

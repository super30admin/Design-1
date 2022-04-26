import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I could not do the decrease of capacity by 20% when elements were removed
// Your code here along with comments explaining your approach
class MyHashSet {
    // New Linkedlist
     LinkedList<Integer>[] list;
    //Hashtable size
     int capacity;
    //factor to increase the size of the table if more entries
     double factor;
    //keep on counter
    int counter=0;
    public MyHashSet() {
    //Given 10^4 is max => squareroot of it is 100 
      capacity=100;
    //If 80% of the capacity(table) is filled to check it useing factor
      factor = 0.80;
    //Initialize list
        list = new LinkedList[capacity];
   }
     
    public void add(int key) {
//If element already exists just return because hashset doesnt contain duplicates
        if(contains(key)){
            return;
        }
        //If 80% of the table is filled then increase the capacity by twice
        if(factor * capacity == counter){
            counter = 0;
            capacity = capacity *2;
            //create a new linkedlist copylist which will hold the elements entered till now
             LinkedList<Integer>[] copylist = list;
            //now increase the size of list with new capacity
                list = new LinkedList[capacity];
            //copy all elements from copylist to list with new capacity
                for (int i = 0; i < copylist.length; i++) {
                    LinkedList<Integer> list1 = copylist[i];
                    //if the list has few elements then add the elements next to it
                    if (list1 != null) {
                        for (int val : list1)
                            this.add(val);
                    }
                }
        }
        
        int hash = key % capacity;
        //Find the hash function using mod and if there is no element
            if (list[hash] == null)
                //create new linkedlist
                list[hash] = new LinkedList<>();
            //add the key
            list[hash].add(key);
           //increase the counter
            ++counter;
    }
    
    public void remove(int key) {
        //first find the hash function
        int hash = key % capacity;
    //create a new list2 which will contain the linkedlist present in that hashindex
            LinkedList<Integer> list2 = list[hash];
        //if the list2 is not null then iterate and if it has the key remove it
            if (list2 != null) {
                Iterator<Integer> iterator = list2.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() == key) {
                        iterator.remove();
                        //decrease counter
                        --counter;
                    }
                }
            }
    }
    
    public boolean contains(int key) {
        //first find the hash function
        int hash = key % capacity;
    //create a new list2 which will contain the linkedlist present in that hashindex
            LinkedList<Integer> list2 = list[hash];
            if (list2 != null) {
                //iterate and if key is present return true
                for (int k : list2)
                    if (k == key)
                        return true;
            }
        //return false
            return false;
        }
    }
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
                MyHashSet set = new MyHashSet();
                set.add(10);
                set.add(20);
                set.remove(20);
               boolean c = set.contains(20);
               System.out.println(c);
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
    

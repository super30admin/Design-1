// Time Complexity :O(n) for array initialization  insertion and deletion O(1)
// Space Complexity :O(n) worst case if array includes 1000000 unique key values.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : I was able to think only array approch



// Your code here along with comments explaining your approach
import java.util.Arrays;
class MyHashMap {
    int MAX_KEYVALUE=1000000;
    int mymap[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
        mymap=new int[MAX_KEYVALUE];
        Arrays.fill(mymap, -1);
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        mymap[key]=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int value= mymap[key];
        if(value>=0)
        {
             System.out.println("Key "+ key+" Value: "+ value);
            return value;
        }
        else
            return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    
        int tempValue=mymap[key];
        if(tempValue>=0)
        {
            mymap[key]=-1;
        }
        
    }
}



// Time Complexity : push O(1) deleteion o(n) pop O(1)
// Space Complexity : O(n) for N nodes
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  Thinking how to calulate minvalue


class MinStack {
    
    Node top;
    Node root;
    //Node min;
    
    long min=Long.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        root=null;
        top=null;
        
    }
    
    public void push(int x) {
        
        Node newNode;
        
        if(top!=null){
            // Node temp=top;
            // top.next=newNode;
            // top=newNode;
            // if(temp.data< x)
            //     min=newNode;
            if(x < min)
            {
              
              
              newNode=new Node(((1L*2 * x) - min));
              top.next=newNode;
              top=newNode;
              min=(long)x;
             
            }
            else
            {  
                newNode=new Node((long)x);
                top.next=newNode;
                top=newNode;
                
            }
                        
        }
        else{
         System.out.println("Push "+ x);
        min=(long)x;
        newNode=new Node(x);
        root=newNode;
        top=newNode;
            
        }
        
       
    
    }
    
    public void pop() {
        
        if(top!=null)
        {
            
            long tempMin=top.data;
            
            
                
            Node temp=root;
            while(temp.next!=top && temp.next!=null)
            {
                
                temp=temp.next;
            }
            if(root==top){
                root=null;
                top=null;
                temp=null;
                
            }else{
                temp.next=null;
                top=temp;
            
            }
           
            if(tempMin<min)
            {

                min=((2*min)-tempMin);

                
            }


        }
        if(top==null)
        min = Long.MAX_VALUE;
        
    }
    
    public int top() {
        if(top!=null)
        {
            long peek=top.data;
            if (peek < min)
			return (int) min;
		else
			return (int) peek;
        }
            
        return -1;
        
    }
    
    public int getMin() {

            //System.out.println("getMin "+min);
            return (int)min;

        
    }
    
    class Node{
        long data;
        Node next;
        Node(long data){
        this.data=data;
        this.next=null;
        }
        
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

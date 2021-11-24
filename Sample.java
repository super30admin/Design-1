// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes after removing boundary conditions. Took the liberty to assume maxCapcity as 20, this failed on leetcode since 
// they have not specified any boundary conditions.
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
//Minstack implementation. Used linkedlist as underlying datastructure. The idea is to calculate min value during insertion of node and maintain it in node itself.
class Node{
    int data;
    Node next;
    int min;
    
    Node(int data){
        this.data=data;
        this.next=null;
        this.min=Integer.MAX_VALUE;
    }
}

class MinStack {
    
    private Node head;
    private int size;
    private int maxCapacity;


    public MinStack() {
        this.head=null;
        this.size=0;
        this.maxCapacity=20;
    }
    
    public void push(int val) {
        if(this.size==this.maxCapacity){
            System.out.println("Stack overflow");
        }else{
        Node node = new Node(val);
        if(this.head==null){
            node.min=val;
        }else{       
           node.min=Math.min(this.head.min,val);
        }
        node.next=this.head;
        this.head=node;
        size++;
        }
    }
    
    public void pop() {
        if(this.size==0){
            System.out.println("No elements to pop");
        }else{
             head= head.next;
            size--;
        }   
    }
    
    public int top() {
         if(this.size==0){
           return -1;
        }else{
            return this.head.data;
         }
    }
    
    public int getMin() {
        if(this.head!=null){
            return this.head.min;
        }else{
            return -1;
        }
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



 // Time Complexity : o(1)
// Space Complexity : o(n)
 //HashMap implementation

 class MyHashMap {

    int[][] primaryArr;
      
    
       public MyHashMap() {
           primaryArr= new int[100001][];
      
       }
       public int hash(int key){
           return key%100000;
       }
       public void put(int key, int value) {
           int[] arr = new int[2];
           arr[0]=key;
           arr[1]=value;
           primaryArr[hash(key)]=arr;
       }
      
       public int get(int key) {
          if(primaryArr[hash(key)]==null){
              return -1;
          }else{
              return primaryArr[hash(key)][1];
          }
       }
      
       public void remove(int key) {
           if(primaryArr[hash(key)]!=null){
               int[] arr = new int[2];
               arr[0]=-1 ;
               arr[1]=-1;
                   primaryArr[hash(key)]=arr;
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
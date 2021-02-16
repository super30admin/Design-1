// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Time Limit Exceeded (Program is running fine in IDE, 
// but on leetcode I am getting time Limit Exceeded error. Can I know how should I improve?)


// Your code here along with comments explaining your approach

public class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
       
       Node(int k, int v){
           key = k;
           value = v;
           next = null;
       }
   }
   
   Node head;


   /** Initialize your data structure here. */
   public MyHashMap() {
//    	Node node ;
   }
   
   /** value will always be non-negative. */
   public Boolean put(int key, int value) {
       try {
       Node node = new Node(key,value);
       if(head == null){
           head = node;
           return true;
       }
       Node temp = head;
       while(temp.next != null){
           temp = temp.next;
       }
       temp.next = node;
       return true;
       }
       catch(Exception e) {
           e.printStackTrace();
           return false;
       }
       
   }
   
   /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
   public int get(int key) {
       if(head == null){
           return -1;
       }
       Node temp = head;
       while(temp.next != null){
           if(temp.key == key){
               return temp.value;
           }
           temp = temp.next;
       }
       return -1;    
   }
   
   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
   public void remove(int key) {
       if(head == null){
           return;
       }
       if(head.key==key) {
           head=head.next;
           return;
       }
       Node temp = head;
       while(temp.next != null){
           if(temp.key == key){
               temp.next = temp.next.next;
               return;
           }
       }
   }
   
   public static void main(String[] args) { 

       MyHashMap obj = new MyHashMap();
        System.out.println("first insertion"+obj.put(1,2));
        System.out.println("first insertion"+obj.put(3,4));
        System.out.println("first insertion"+obj.put(5,6));
        int param_2 = obj.get(1);
        System.out.println(param_2);
        param_2 = obj.get(2);
        System.out.println(param_2);
        obj.remove(1);
        param_2 = obj.get(1);
        System.out.println(param_2);
        
        
   }
}

// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :   No

//Approach: Used Linear chaining to handle collisions in hashmap
//created an array of linkelists, found the hash value for the key and then created the node at that index of array and kept on inserting the nodes if there is same hash.

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
     
     int buckets_no = 10000; //Number of buckets
     Node[] buckets; // created an array of linkedlists
     public MyHashMap(){
         buckets = new Node[buckets_no];
     }
     int getHash(int key){    //finding hash value
         return key%buckets_no;
     }
     Node findPrev(int key){   //here is a method for finding the "previous node" which is common thing to do for put, get                               //and remove
         int hash = getHash(key);
         if(buckets[hash] ==  null){
             return null;
         }
         Node prev = buckets[hash];
         Node curr = prev.next;
         
         while(curr!=null && curr.key!=key){
             prev = curr;
             curr = curr.next;
         }
         return prev;
     }
     
     public void put(int key, int value) {
         Node prev = findPrev(key);
         if(prev == null){
             int hash = getHash(key);
             buckets[hash] = new Node(-1,-1); //creating a dummy node at the start to make sure there is a previous node                                                //for the first element too.
             prev = buckets[hash];
         }
         
         
         if(prev.next != null){
             prev.next.value = value;
         }
         else{                               //insert
             prev.next =  new Node(key, value);
         }
     }
     
     public int get(int key) {
         Node prev  = findPrev(key);
         if(prev == null || prev.next == null){
             return -1;
         }
         return prev.next.value;
     }
     
     public void remove(int key) {
         Node prev  = findPrev(key);
         if(prev== null || prev.next==null){
             return;
         }
         prev.next = prev.next.next;
     }
 }
 
 /**
  * Your MyHashMap object will be instantiated and called as such:
  * MyHashMap obj = new MyHashMap();
  * obj.put(key,value);
  * int param_2 = obj.get(key);
  * obj.remove(key);
  */
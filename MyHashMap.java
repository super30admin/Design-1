
import java.util.*;
class MyMap<K,V>{
    K key;
    V value;
   
   public MyMap(K key,V value){
       this.key=key;
       this.value=value;
   }
   
}

class Bucket{
   private List<MyMap<Integer,Integer>> bucket;
   
   public Bucket(){
       bucket=new LinkedList<MyMap<Integer,Integer>>();
       
   }
   
   public Integer get(Integer key){
       for(MyMap<Integer,Integer> m:bucket){
           if(m.key.equals(key)){
               return m.value;
           }
       }
       return -1;       
       
   }
   public void update(Integer key,Integer value){
       boolean ans=false;
       for(MyMap<Integer,Integer> m:bucket){
          if(m.key.equals(key)){
              m.value=value;
              ans=true;
              break;
          }
           
           
       }
       if(!ans){
               bucket.add(new MyMap<Integer,Integer>(key,value));
           }
   }
   
   public void remove(Integer key){
      for(MyMap<Integer,Integer> m:bucket){
           if(m.key.equals(key)){
               bucket.remove(m);
               break;
           }
         }
}
}
   

class MyHashMap {

   int k;
   List<Bucket> hash;
   /** Initialize your data structure here. */
   public MyHashMap() {
       this.k=2069;
       this.hash=new ArrayList<Bucket>();
       for(int i=0;i<this.k;i++){
       hash.add(new Bucket());
       }
   }
   
   /** value will always be non-negative. */
   public void put(int key, int value) {
       int hashkey=key%k;
       hash.get(hashkey).update(key,value);
       
   }
   
   /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
   public int get(int key) {
        int hashkey=key%k;
       return hash.get(hashkey).get(key);
       
   }
   
   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
   public void remove(int key) {
       int hashkey=key%k;
       hash.get(hashkey).remove(key); 
   }
   public static void main(String args[]){
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);          
    hashMap.put(2, 2);         
    System.out.println(hashMap.get(1));            // returns 1
    System.out.println(hashMap.get(3));            // returns -1 (not found)
    hashMap.put(2, 1);          // update the existing value
    System.out.println(hashMap.get(2));            // returns 1 
    hashMap.remove(2);          // remove the mapping for 2
    System.out.println(hashMap.get(2));
   }
}

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/
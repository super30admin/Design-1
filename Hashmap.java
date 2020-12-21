// Time Complexity : O(1)
// Space Complexity : always 1000000
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I have taken very large array.
//If I take small array, there will be collision


// Your code here along with comments explaining your approach
// take mod of key with size and keep value at that position.


class MyHashMap {
      int size=1000000;
      Hashnode[] harr;
    class Hashnode{
        int key;
        int value;
        public Hashnode(int k,int v){
            key=k;
            value=v;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
       
    harr=new Hashnode[size];
    }
    int hash(int k){
     return ( k )%size;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Hashnode g=new Hashnode(key,value);
        int index=hash(key);
        if(harr[index]==null){
        harr[index]=g;}
        else{
            harr[index].key=key;
            harr[index].value=value;
        }
    }
   
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(harr[hash(key)]!=null){
            return harr[hash(key)].value;
        }
        else{
            return -1;
        }
    }
   
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
       if(harr[hash(key)]!=null){
           harr[hash(key)]=null;
       }
        else{
            return ;
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
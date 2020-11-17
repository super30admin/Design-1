// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes, never known the actual implementation of hashmap function. Had to google to
//											to understand the hashmap implementation 


// Your code here along with comments explaining your approach

class MyHashMap {
    Pair[] entry = new Pair[1000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashValue = hashCode(key);
        if(entry[hashValue]==null)
            entry[hashValue]= new Pair(-1,-1);
        
            
            Pair bucket = findEntry(entry[hashValue],key);
          
            if(bucket.next==null)
                bucket.next=new Pair(key,value);
            else
                bucket.next.value=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int hashValue = hashCode(key);
        
        if(entry[hashValue]==null)
            return -1;
        
            Pair bucket = findEntry(entry[hashValue],key);
                if(bucket.next==null)
                    return -1;
            return bucket.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         int hashValue = hashCode(key);
        if(entry[hashValue]==null)
            return ;
        Pair bucket = findEntry(entry[hashValue],key);
        if(bucket.next!= null)
            bucket.next=bucket.next.next;     

    }
    
    public int hashCode(int key){
        return key%entry.length;
    }
    
    public Pair findEntry(Pair pair,int key){
        Pair p=pair;
        Pair result = null;
        while(p!=null&&p.key!=key){
            result=p;
            p=p.next;
        }
        return result;
    }
    
    class Pair{
        int key,value;
        Pair next;
        Pair(int key, int value){
            this.key = key;
            this.value = value;            
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
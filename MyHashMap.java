package Design1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Pair<Class1,Class2>{
    public Class1 first;
    public Class2 second;
    
    
    //constructor
    public Pair(Class1 first,Class2 second){
        this.first=first;
        this.second=second;
    }
}

class Bucket{
    private List<Pair<Integer,Integer>> bucket;
    
    //constructor
    public Bucket(){
        this.bucket=new LinkedList<Pair<Integer,Integer>>();
    }
    
    public void remove(Integer key){
        for(Pair<Integer,Integer> pair:this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
    
    public void update(Integer key,Integer value){
        Boolean found= false;
        for(Pair<Integer,Integer> pair:this.bucket){
            if(pair.first.equals(key)){
                pair.second=value;
                    found=true;
            }
        }
        if(!found) 
        this.bucket.add(new Pair<Integer,Integer>(key,value));
    }
    
    public Integer get(Integer key){
        for(Pair<Integer,Integer> pair:this.bucket){
            if(pair.first.equals(key)) return pair.second;
        }
        return -1;
    }
}




public class MyHashMap {
	private int keySpace;
    private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public MyHashMap() {
         this.keySpace = 2069; 
    this.hash_table = new ArrayList<Bucket>();
        for(int i=0;i<this.keySpace;i++){
            this.hash_table.add(new Bucket());
        }
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    int hash_key=key % this.keySpace;
        this.hash_table.get(hash_key).update(key,value);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key= key % this.keySpace;
        return this.hash_table.get(hash_key).get(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key=key % this.keySpace;
        this.hash_table.get(hash_key).remove(key);
        
    }
}

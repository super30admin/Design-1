import java.util.*;
// Time Complexity : O(N/K) where N=number of possible keys, K=number of buckets in hashmap
// Space Complexity : O(K+M) where K=number of buckets, M=number of unique keys in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Pair<U,V>{

    public U first;
    public V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

class Bucket{

    private List<Pair<Integer,Integer>> bucket ;

    public Bucket(){
        bucket = new LinkedList<Pair<Integer,Integer>>();
    }

    public Integer get(Integer key){
        for(Pair<Integer,Integer> pair:this.bucket){
        if(pair.first.equals(key)){
            return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer val){
        boolean found = false;
        for(Pair<Integer,Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                pair.second = val;
                found = true;
            }
        }
        if(!found){
            this.bucket.add(new Pair<>(key,val));

        }
    }

    public void remove(Integer key){

        for(Pair<Integer,Integer> pair: this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

class HashMap{
    public int keyspace;
    public List<Bucket> hash_table;

    public HashMap(){
        this.keyspace = 2096;
        this.hash_table = new ArrayList<>();
        for(int i=0;i<this.keyspace;i++){
            this.hash_table.add(new Bucket());
        }
    }

    public int get(int key){
        int hash_key = key % this.keyspace;
        return this.hash_table.get(hash_key).get(key);
    }

    public void put(int key, int value){
        int hash_key = key % this.keyspace;
        this.hash_table.get(hash_key).update(key, value);
    }

    public void remove(int key){
        int hash_key = key % this.keyspace;
        this.hash_table.get(hash_key).remove(key);
    }

    public static void main(String[] args){

        HashMap map = new HashMap();
        map.put(0,1);
        map.put(1,2);
        map.put(0,3);
        System.out.println(map.get(0));
    
    
    }
}



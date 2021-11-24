// Time complexity = O(n/k) where n is no of keys and n is predfined buckets
// Space O(k + m) k is no of buckets and m is unique keys inserted
class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}
class Bucket{
        
        List<Pair<Integer,Integer>> bucket;
        
        public Bucket()
        {
            this.bucket = new LinkedList<Pair<Integer,Integer>>();
        }
    
    public Integer get(Integer key)
    {
        
        for(Pair<Integer,Integer> pair : this.bucket)
        {
            if(pair.first.equals(key))
                return pair.second;
        }
        
        return -1;
        
    }
    
    public void update(Integer key, Integer value)
    {
        boolean found = false;
        for(Pair<Integer,Integer> pair : this.bucket)
        {
            if(pair.first.equals(key))
            {
                pair.second = value;
                found = true;
            }
        }
        
        if(!found)
        {
            this.bucket.add(new Pair<Integer,Integer>(key,value));
        }
    }
    
    public void remove(Integer key)
    {
        for(Pair<Integer,Integer> pair : this.bucket)
        {
            if(pair.first.equals(key))
            {
                this.bucket.remove(pair);
            }
        }
        
    }
}

class MyHashMap {
      int key_space;
    List<Bucket> hashtable;
    
   
    

    public MyHashMap() {
        
        this.key_space = 1000;
        this.hashtable = new ArrayList<Bucket>();
        
        for(int i=0;i<this.key_space;++i)
        {
            this.hashtable.add(new Bucket());
        }
        
    }
    
    public void put(int key, int value) {
        
        int hash_key = key % this.key_space;
        this.hashtable.get(hash_key).update(key,value);
        
    }
    
    public int get(int key) {
        
        int hash_key = key % this.key_space;
        return this.hashtable.get(hash_key).get(key);
        
    }
    
    public void remove(int key) {
        
        int hash_key = key % this.key_space;
        this.hashtable.get(hash_key).remove(key);
        
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class Pair<K,V>{
  public K k;
  public V v;
  public Pair(K k, V v){
    this.k = k;
    this.v = v;
  }
}

// Bucket Operations
class Bucket{
  private List<Pair<Integer,Integer>> bucket;
  
  public Bucket(){
    this.bucket = new LinkedList<Pair<Integer,Integer>>();
  }


  public Integer get(Integer key){
    for(Pair<Integer, Integer> pair: this.bucket){
      if(pair.k.equals(key)){
        return pair.v;
      }
    }
    return -1;
  }

  public void update(Integer key, Integer value){
    boolean found = false;
    for(Pair<Integer, Integer> pair: this.bucket){
      if(pair.k.equals(key)){
        pair.v = value;
        found = true;
      }
    }
    if(!found){
        this.bucket.add(new Pair<Integer,Integer>(key,value));
    }
  }


  public void remove(Integer key){
    for(Pair<Integer, Integer> pair: this.bucket){
      if(pair.k.equals(key)){
        this.bucket.remove(pair);
        break;
      }
    }
  }
  
}



class MyHashMap {
    private ArrayList<Bucket> hmap;
    private int key_space = 2069; 

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.hmap = new ArrayList<Bucket>();
      for(int i=0;i<key_space;i++){
        this.hmap.add(new Bucket());
      }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % key_space;
        this.hmap.get(hash_key).update(key,value); 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key = key % key_space;
        return this.hmap.get(hash_key).get(key); //?
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      int hash_key = key % key_space;
      this.hmap.get(hash_key).remove(key);
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

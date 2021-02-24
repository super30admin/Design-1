class Pair<K,V>{
    public K first;
    public V second;

    public Pair(K first,V second)
    {
        this.first=first;
        this.second=second;
    }


}

class Bucket{

    private List<Pair<Integer, Integer>> bucket ;

    public Bucket(){

        this.bucket=new LinkedList<Pair<Integer,Integer>> ();
    }

    public Integer get(Integer key){
        for(Pair<Integer, Integer> pair : this.bucket)
        {
            if(pair.first.equals(key))
            {
                return pair.second;
            }
        }
        return -1;
    }

    public void update(Integer key, Integer value)
    {
        boolean found=false;
        for(Pair<Integer, Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                pair.second=value;
                found=true;
            }

    }
    if(!found){
        this.bucket.add(new Pair<Integer,Integer> (key, value));
    }

    }

    public void remove(Integer key){
      for(Pair<Integer, Integer> pair : this.bucket)
      {
           if(pair.first.equals(key)){
               this.bucket.remove(pair);
               break;
           }

      }
    }
}


class MyHashMap {
 private int k;
 private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public MyHashMap() {




    /** value will always be non-negative. */

        this.k=2003;
        this.hash_table= new ArrayList<Bucket> ();
        for(int i=0;i< this.k;++i){
            this.hash_table.add(new Bucket());
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public void put(int key, int value) {
        int hash_key= key % this.k ;
        this.hash_table.get(hash_key).update(key,value);
    }

    public int get(int key)
    {
        int hash_key= key % this.k ;
       return this.hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key= key % this.k ;
        this.hash_table.get(hash_key).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

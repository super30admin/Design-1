// Time Complexity : O(N/M)
// Space Complexity : O(N+M) , where n is no.of predefined buckets. k is no.of unique keys
// Did this code successfully run on Leetcode : yes

class pair<X,Y> {
    public X key;
    public Y value;

    public pair(X key,Y value){
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private List<pair<Integer,Integer>>  pairlist;

    public Bucket(){
        this.pairlist =  new LinkedList<pair<Integer,Integer>>();
    }
    public Integer get(Integer key){
        for(pair<Integer,Integer> pair : this.pairlist){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return -1;

    }
    public void update(Integer key,Integer value){
        boolean found = false;
        for(pair<Integer, Integer> pair : this.pairlist){
            if(pair.key.equals(key)){
                pair.value =value;
                found = true;
            }
        }
        if(! found){
            this.pairlist.add(new pair<Integer,Integer>(key,value));
        }
    }

    public void remove(Integer key){
        for(pair<Integer,Integer> pair : this.pairlist){
            if(pair.key.equals(key)){
                this.pairlist.remove(pair);
                break;
            }
        }
    }
}
class MyHashMap {
    private int Key_space;
    private List<Bucket> hash_table;

    public MyHashMap() {
        this.Key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i=0;i< this.Key_space;i++){
            this.hash_table.add(new Bucket());
        }

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_code = key % Key_space;
        this.hash_table.get(hash_code).update(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_code = key % Key_space;
        return this.hash_table.get(hash_code).get(key);

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_code = key % Key_space;
        this.hash_table.get(hash_code).remove(key);
    }
}

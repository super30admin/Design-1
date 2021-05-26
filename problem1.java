class MyHashMap {

    /** Initialize your data structure here. */
    private static final int SIZE = 1024;
    List<ArrayList<Pair>> map;
    public MyHashMap() {
        map= new ArrayList<>();
        for(int i=0;i<SIZE;i++){
            ArrayList<Pair> bucket=new ArrayList<>();
            map.add(bucket);
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        boolean found = false;
        int hash = this.hash(key);
        ArrayList<Pair> bucket = map.get(hash);
        for(Pair pair:bucket){
            if(pair.key==key){
                pair.value=value;
                found = true;
                break;
            }
        }
        if(!found){
            Pair pair = new Pair(key,value);
            bucket.add(pair);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = this.hash(key);
        ArrayList<Pair> bucket = map.get(hash);
        for(Pair pair : bucket){
            if(pair.key==key){
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = this.hash(key);
        ArrayList<Pair> bucket = map.get(hash);
        Pair toRemove = null;
        for(Pair pair : bucket){
            if(pair.key==key){
                toRemove = pair;
            }}
        if(toRemove!=null){
            bucket.remove(toRemove);
        }


    }
    public int hash(int key){
        return key%SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class Pair{
    int key;
    int value;
    public Pair(int key, int value){
        this.key=key;
        this.value=value;
    }
}

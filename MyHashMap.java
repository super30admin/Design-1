class MyHashMap {
    
    public class Pair{
       public int x;
       public int  y;
        
        Pair(){
            this.x =0;
            this.y =0;
        }
        
        Pair(int xVal, int yVal){
            this.x = xVal;
            this.y = yVal;
        }
    }

    /** Initialize your data structure here. */
    //Need another structure here, a Set of Sets
    LinkedList<Pair> hashMap;
    
    public MyHashMap() {
        this.hashMap = new LinkedList<Pair>();
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int indexOfRepeat=-1;
        for( Pair p: this.hashMap){
            if(p.x == key){
                p.y=value;
                return;
            }
        }
        this.hashMap.add(new Pair(key,value));
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for( Pair p: this.hashMap){
            if(p.x == key){
                return p.y;
            }
        }
        
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for( Pair p: this.hashMap){
            if(p.x == key){
                this.hashMap.remove(p);
                return;
                }
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

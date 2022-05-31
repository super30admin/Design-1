//Time Complexity : O(1)
//Space Complexity : O(n)
class MyHashMap {
    private int[][] hashMap;
    int buckets;
    int bucketlists;
    public MyHashMap() {
         buckets=1000;
         bucketlists=1000;
        hashMap=new int[buckets][];
        
    }
    
    public int hash1(int key){
        return key%buckets;
    }
    public int hash2(int key){
        return key/bucketlists;
    }
    
    public void put(int key, int value) {
        int bucket=hash1(key);
        int bucketlist=hash2(key);
        if (hashMap[bucket]==null){
            if (bucket==0){
                hashMap[bucket]=new int[bucketlists+1];
                Arrays.fill( hashMap[bucket], -1);
                }
            else{
                hashMap[bucket]=new int[bucketlists];
                Arrays.fill( hashMap[bucket], -1);
                }
        }
        hashMap[bucket][bucketlist]=value;
    }
    
    public int get(int key) {
        int bucket=hash1(key);
        int bucketlist=hash2(key);
        if (hashMap[bucket]==null) return -1;
        if (hashMap[bucket][bucketlist]!=-1){
            return  hashMap[bucket][bucketlist];
            
        }
        return -1;
        }
       
        
    
    public void remove(int key) {
         int bucket=hash1(key);
        int bucketlist=hash2(key);
        if (hashMap[bucket]==null) return;
         hashMap[bucket][bucketlist]=-1;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
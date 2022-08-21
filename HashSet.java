public class HashSet {
    boolean[][] primaryArray;
    int buckets;
    int itemBuckets;

    public MyHashSet() {
        this.buckets = 1000;
        this.itemBuckets = 1000;
        this.primaryArray = new boolean[buckets][];
        
    }
    
    private int firstHashFunc(int key){
        return key%buckets;
    }
    
    private int secondHashFunc(int key){
        return key/buckets;
    }
    
    public void add(int key) {
        int hash1 = firstHashFunc(key);
        int hash2 = secondHashFunc(key);
        if(primaryArray[hash1] == null){
            if(hash1 == 0){
                primaryArray[hash1] = new boolean[itemBuckets + 1];
            }
            else{
                primaryArray[hash1] = new boolean[itemBuckets];
            }
        }
        primaryArray[hash1][hash2] = true;
        
    }
    
    public void remove(int key) {
        int hash1 = firstHashFunc(key);
        int hash2 = secondHashFunc(key);
        if(primaryArray[hash1] == null){
            return;
        }
        primaryArray[hash1][hash2] = false;
        
    }
    
    public boolean contains(int key) {
        int hash1 = firstHashFunc(key);
        int hash2 = secondHashFunc(key);
        if (primaryArray[hash1] == null){
            return false;
        }
        return primaryArray[hash1][hash2];
        
    }
    
}

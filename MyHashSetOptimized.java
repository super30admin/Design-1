class MyHashSetOptimized {

    private boolean[][] storage;
    private int hash1Size;
    private int hash2Size;
    public MyHashSetOptimized() {
        hash1Size = 1000;
        hash2Size = 1000;
        storage = new boolean[hash1Size][];
    }
    
    public boolean add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            storage[hash1] = (hash1 == 0) ? new boolean[hash2Size+1]:new boolean[hash2Size];
        }
        if(storage[hash1][hash2])
            return false;
        storage[hash1][hash2] = true;
        return true;

    }
    
    public boolean remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            return false;
        }
        if(!storage[hash1][hash2])
            return false;
        storage[hash1][hash2] = false;
        return true;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            return false;
        }
        return storage[hash1][hash2];
    }
    
    private int hash1(int key){
        return key % hash1Size;
    }
    
    
    private int hash2(int key){
        return key / hash2Size;
    }


    public static void main(String[] args) {
        MyHashSetOptimized set = new MyHashSetOptimized();
        System.out.println(set.remove(2));//false
        System.out.println(set.contains(2));//false

        System.out.println(set.add(1));//true
        System.out.println(set.contains(1));//true
        System.out.println(set.add(2));//true
        System.out.println(set.contains(2));//true

        System.out.println(set.add(2));//false -- 2 already present shouldnt add duplicate
        System.out.println(set.contains(2));//true
        System.out.println(set.remove(2));//true
        System.out.println(set.contains(2));//false
        
        System.out.println(set.contains(1));//true

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

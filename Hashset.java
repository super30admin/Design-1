/*
 * Time complexity and space complexity for each function is o(1)
 */
class MyHashSet {
    int bucket = 1000;
    int bucketitems = 1000;
    boolean arr[][];
    public MyHashSet() {
       arr = new boolean[1000][]; 
    }

    public int hash1(int key)
    {
        return key%bucket;
    }
    public int hash2(int key)
    {
        return key/bucketitems;
    }
    public void add(int key) {
        
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1] == null)
        {
            if(hash1==0)
            {
                arr[hash1] = new boolean[bucketitems+1];
            }
            else
            {
                arr[hash1] = new boolean[bucketitems];
            }
           
        }
         arr[hash1][hash2]=true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1]==null)
        {
            return;
        }
        arr[hash1][hash2] = false;
        
    }
    
    public boolean contains(int key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(arr[hash1] == null) return false;

        if(arr[hash1][hash2] == true) return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
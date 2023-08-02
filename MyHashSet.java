class MyHashSet {

    public int buckets;
    public boolean[][] arr;
    public int bucketItems;



    public MyHashSet() {
        this.buckets =1000;
        this.bucketItems =1000;
        this.arr = new boolean[buckets][];

    }
    
    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int b = hash1(key);
        int bItem = hash2(key);
        
        if(arr[b] == null){
            if (b == 0) {

                arr[b] = new boolean[bucketItems+1];
                
            }else{
                arr[b] = new boolean[bucketItems];
            }
        }
        arr[b][bItem] = true;
    }
    
    public void remove(int key) {

        int b = hash1(key);
        int bItem = hash2(key);

        if (arr[b] == null) {

            return;
            
        }
        arr[b][bItem] = false;
    }
    
    public boolean contains(int key) {

        int b = hash1(key);
        int bItem = hash2(key);
        if (arr[b] == null) {

            return false;
            
        }

        return arr[b][bItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



// Your code here along with comments explaining your approach

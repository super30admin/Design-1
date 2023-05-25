class MyHashSet {
	/*
	 * Approach was to use double hashing to store values without collisions and to further save space a boolean array
	 * is used. An edge case where the input = 1000000 was handled by creating and extra primary arrayspace that holds a nested
	 * array of size 1.
	 * Time Complexity :
	 * add(), remove(), contains() - O(1)
	 * 
	 * Space Complexity :
	 * Space complexity is O(N)
	 * Did this code successfully run on Leetcode : yes
	 * 
	 * Any problem you faced while coding this : None
	 */

    private int primaryArraySize;
    private int nestedArraySize;
    private boolean[][] Bucket;

    public MyHashSet() {
        this.nestedArraySize= primaryArraySize=1000;
        this.Bucket= new boolean[primaryArraySize+1][];
    }

    private int hash1(int key){
        return key%primaryArraySize;
    }

    private int hash2(int key){
        return key/nestedArraySize;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(Bucket[hash1]==null){
            Bucket[hash1]=new boolean [nestedArraySize];
        }
        if(key==1000000){
            Bucket[primaryArraySize] = new boolean[1];
            Bucket[primaryArraySize][0]=true;
        }
        else
            Bucket[hash1][hash2]=true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(key==1000000){
            if(Bucket[primaryArraySize] == null)
                return;
            else{
                Bucket[primaryArraySize][0]=false;
                return;
            }
        }
        if(Bucket[hash1]==null){
            return;
        }
        Bucket[hash1][hash2]=false;

    }
    
    public boolean contains(int key) {

        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(key==1000000){
            if(Bucket[primaryArraySize] == null)
                return false;
            else
                return Bucket[primaryArraySize][0];
        }

        if(Bucket[hash1]==null){
            return false;
        }
        else return Bucket[hash1][hash2];
    }
}

// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No




class MyHashSet {
        private boolean[][] store; 
        private int primaryArray;  
        private int nestedArray;  

        private int hash1(int key){
            return key % primaryArray;  
        }

        private int hash2(int key){
            return key / nestedArray;
        }
    public MyHashSet() {
        this.primaryArray = 1000;  
        this.nestedArray = 1000;
        this.store = new boolean [1000][]; //We are only creating primary array first. Based on values we get we start adding nested Arrays to each index
    }

    public void add(int key) {
        int primaryArray = hash1(key);
        if (store[primaryArray] == null){ 
            if(primaryArray == 0){
                store[primaryArray] = new boolean[nestedArray + 1]; //This is to check for 10000000 All the nested Arrays will be 0 to 999 and the index 0 nested arrays will be 0 to 1000 to store the last element
            }
            else{ 
                store[primaryArray] = new boolean[nestedArray];
            }
        }
        int nestedArray = hash2(key); 
        store[primaryArray][nestedArray]=true; 
    }

    public void remove(int key) {
        int primaryArray = hash1(key);
        if (store[primaryArray] == null) {return;} 
        int nestedArray = hash2(key); 
        store[primaryArray][nestedArray]= false; 
    }

    public boolean contains(int key) {
        int primaryArray = hash1(key);
        if (store[primaryArray]==null){
            return false;
        }
        int nestedArray = hash2(key); 
        return store[primaryArray][nestedArray];
    }
}
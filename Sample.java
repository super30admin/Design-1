// Time Complexity : o(1)
// Space Complexity : o(1)o(1)
// Did this code successfully run on Leetcode : yess
// Any problem you faced while coding this : could pass 26/33 of test cases. Looking into the other failing test cases

class MyHashSet {
    private int primaryarlen;
    private int secondaryarlen;
    private Boolean [] [] array;
    

    public MyHashSet() {
        this.primaryarlen = 1000;
        this.secondaryarlen = 1001;
        this.array = new Boolean[primaryarlen][];
      
        
    }
    
    int hash1(int key) {
        return key%primaryarlen;
    }
    
    int hash2(int key) {
        return key/secondaryarlen;
    }
    
    public void add(int key) {
        int priindex = hash1(key);
        int secindex = hash2(key);
        if(array[priindex] == null) {
            if (priindex == 0) {
                array[priindex] = new Boolean[secondaryarlen + 1];
            }
            else {
                array[priindex] = new Boolean[secondaryarlen];
            }
        }
        array[priindex][secindex] = true;
    }
    
    public void remove(int key) {
        int priindex = hash1(key);
        int secindex = hash2(key);
        if(array[priindex] == null) return;
        array[priindex][secindex] = false;
    }
    
    public boolean contains(int key) {
        int priindex = hash1(key);
        int secindex = hash2(key);
        if(array[priindex] == null) return false;
        return array[priindex][secindex];
    }
}


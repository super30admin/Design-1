// Time Complexity : add -O(1), remove-O(1), Contains-O(1) 
// Space Complexity : O(1000 + n*1000)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :



class MyHashSet {
    int  primary;
    int secondary;
    boolean [][] data;
     
    private int hash1(int key){
        return key%primary;
    }
    
     private int hash2(int key){
        return key/secondary;
    }
    
    public MyHashSet() {
        primary = 1000;
        secondary = 1000;
        data = new boolean[primary][];   
    }
    
    public void add(int key) {
        int index= hash1(key);
        if(data[index]==null){
            if(index==0){
                data[index]= new boolean[secondary+1];
            }
            else {
               data[index]= new boolean[secondary]; 
            }  
        }
        int index2= hash2(key);
        data[index][index2]= true;
    }
    
    public void remove(int key) {
        int index= hash1(key);
        if(data[index]==null) return;
         int index2= hash2(key);
        data[index][index2]= false;
    }
    
    public boolean contains(int key) {
        int index= hash1(key);
        if(data[index]==null) return false;
        int index2= hash2(key);
        return data[index][index2];
        }
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
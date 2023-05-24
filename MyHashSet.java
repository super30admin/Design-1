// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had first thought of implementing it through single hashing technique but wasnt sure how to
//aoid collision. But got clear understanding when the problem was solved in class


// Your code here along with comments explaining your approach
class MyHashSet {
    private int firstLevelArray;
    private int secondLevelArray;
    private boolean[][] storage;

    public MyHashSet() {
        this.firstLevelArray=1000;
        this.secondLevelArray=1000;
        this.storage=new boolean[firstLevelArray][];
    }

    private int firstHashing(int key){
        return key%firstLevelArray;
    }

    private int secondHashing(int key){
        return key/secondLevelArray;
    }
    
    public void add(int key) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]==null){
            if(firstHashingValue==0){
                storage[firstHashingValue]=new boolean[secondLevelArray+1];
            }
            else{
                storage[firstHashingValue]=new boolean[secondLevelArray];
            }
        }
        storage[firstHashingValue][secondHashingValue]=true;
        
    }
    
    public void remove(int key) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]==null)
            return;
        storage[firstHashingValue][secondHashingValue]=false;
        
    }
    
    public boolean contains(int key) {
        int firstHashingValue=firstHashing(key);
        int secondHashingValue=secondHashing(key);
        if(storage[firstHashingValue]==null)
            return false;
        else
            return storage[firstHashingValue][secondHashingValue];      
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

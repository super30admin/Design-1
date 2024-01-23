//Several elements in a hash set may hash to the same index. A is used to linked list to hold all the elements that hash to the same index in order to prevent collisions. A key-value pair is represented by each element in the linked list. In this manner, items having the same hash code can be kept in the same block together. 
//In the worst scenario, the time complexity is O(n) because linked lists use linear searches.
// Space complexity - o(n+m)
class MyHashSet {
    private static final int size = 1000;
    private LinkedList<Integer>[] block;

    public MyHashSet() {
        block = new LinkedList[size];

    }
    private int hash(int key){
        return key%size;
    }
    
    public void add(int key) {
        int index = hash(key);
        if(block[index] == null) {
            block[index] = new LinkedList<>();
        }
        if(!block[index].contains(key)) {
            block[index].add(key);
        }
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(block[index]!= null) block[index].remove(Integer.valueOf(key));
        
    }
    
    public boolean contains(int key) {
       int index = hash(key);
       if(block[index] != null && block[index].contains(key)){
           return true;

       }return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 

//In a HashSet, multiple elements may hash to the same index. To resolve collisions, I have used a linked list, to store all elements that hash to the same index. Each element in the linked list represents a key-value pair. This way, elements with the same hash code can be stored together in the same block. time complexity is O(n) in worst case since linked list follows linear search.
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
 

//time complexity O(1)  Space complexity O(10^6)
class MyHashSet {
    int buckets;
    int bucketitems;
    boolean [][] storage;

    public MyHashSet() {
        buckets=1000;
        bucketitems=1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
       int bucket = key % buckets;
       if(storage[bucket]==null && bucket==0){
           storage[bucket] = new boolean[bucketitems+1];
       }
       if(storage[bucket]==null){
           storage[bucket] = new boolean[bucketitems];
       }
       int bucketitem = key / bucketitems;
       storage[bucket][bucketitem] = true;

    }
    
    public void remove(int key) {
        int bucket = key % buckets;
       if(storage[bucket]==null){
          return;
       }
       int bucketitem= key/bucketitems;
       storage[bucket][bucketitem]=false;
        
    }
    
    public boolean contains(int key) {
         int bucket = key % buckets;
    if(storage[bucket]==null){
        return false;
    }
    
     int bucketitem= key/bucketitems; 
     return storage[bucket][bucketitem];
    }
}

public class MyHashSetDriver {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        // Adding some elements
        set.add(1);
        set.add(2);
        set.add(3);

        // Checking if elements exist in the set
        System.out.println("Contains 2: " + set.contains(2)); // Should print "true"
        System.out.println("Contains 4: " + set.contains(4)); // Should print "false"

        // Removing an element
        set.remove(2);

        // Checking if the removed element still exists
        System.out.println("Contains 2 after removal: " + set.contains(2)); // Should print "false"
    }
}

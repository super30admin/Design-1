class MyHashSet {
    private boolean[][] storage; // 2D array to store boolean values representing presence/absence of elements
    private int buckets; // Number of primary arrays (buckets)
    private int bucketItems; // Number of secondary arrays (bucket items)

    // Constructor
    public MyHashSet() {
        this.buckets = 1000; // Number of primary arrays initialized to 1000
        this.bucketItems = 1000; // Number of secondary arrays initialized to 1000
        this.storage = new boolean[buckets][]; // Initialize the 2D storage array with 1000 primary arrays (buckets)
    }
    
    // Hash function for primary array (buckets)
    private int hash1(int key){
        return key % this.buckets; // Modulo operation to determine the bucket index for the given key
    }
    
    // Hash function for secondary array (bucket items)
    private int hash2(int key){
        return key / this.bucketItems; // Division operation to determine the index of the secondary array within a bucket
    }
    
    // Method to add a key to the HashSet
    public void add(int key) {
        int bucket = hash1(key); // Calculate the bucket index for the key
        int bucketItem = hash2(key); // Calculate the index within the bucket
        if (storage[bucket] == null) { // Check if the bucket is empty
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1]; // Initialize secondary array with additional space for bucket 0
            } else {
                storage[bucket] = new boolean[bucketItems]; // Initialize secondary array
            }
        }
        storage[bucket][bucketItem] = true; // Mark the presence of the key in the HashSet
    }
    
    // Method to remove a key from the HashSet
    public void remove(int key) {
        int bucket = hash1(key); // Calculate the bucket index for the key
        int bucketItem = hash2(key); // Calculate the index within the bucket
        if (storage[bucket] == null) return; // If the bucket is empty, no need to remove anything
        storage[bucket][bucketItem] = false; // Mark the absence of the key in the HashSet
    }
    
    // Method to check if the HashSet contains a key
    public boolean contains(int key) {
        int bucket = hash1(key); // Calculate the bucket index for the key
        int bucketItem = hash2(key); // Calculate the index within the bucket
        if (storage[bucket] == null) return false; // If the bucket is empty, key is not present
        return storage[bucket][bucketItem]; // Return whether the key is present in the HashSet
    }

    // Main method for testing
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1)); // Output: true
        System.out.println(obj.contains(3)); // Output: false
        obj.remove(2);
        System.out.println(obj.contains(2)); // Output: false
    }
}

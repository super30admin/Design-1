class HashSet {
    // We select a 2D Matrix to design this data structure
    // Given the range of 1M, our 2D matrix will be of size 1k x 1k. (except first column)
    int buckets; // Total columns
    int bucketItems; // Total rows
    boolean[][] storage; // Actual 2D array
    // Declaring everything in the class.
    // Initializing in the Constructor.

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[1000][]; // Initializing just the first row for now.
    }

    // This function returns a unique column position for a given key
    private int hashFunctionOne(int key) {
        if (key < 0 || key > 1000000) {
            throw new IllegalArgumentException("Input is not in the valid range.");
        }
        return key % buckets;
    }

    // This function returns a unique row position for a given key
    private int hashFunctionTwo(int key) {
        if (key < 0 || key > 1000000) {
            throw new IllegalArgumentException("Input is not in the valid range.");
        }
        return key / buckets;
    }

    public void add(int key) {
        // Calculate correct row and column position.
        // If given position is null, initialize it.
        int bucketNumber = hashFunctionOne(key);
        int bucketItemNumber = hashFunctionTwo(key);

        if (storage[bucketNumber] == null) {
            if (bucketNumber == 0) {
                storage[bucketNumber] = new boolean[bucketItems + 1]; // First bucket shall have extra size.
            } else {
                storage[bucketNumber] = new boolean[bucketItems];
            }

        }
        storage[bucketNumber][bucketItemNumber] = true;
    }

    public void remove(int key) {
        int bucketNumber = hashFunctionOne(key);
        int bucketItemNumber = hashFunctionTwo(key);

        if (storage[bucketNumber] == null) {
            return; // Nothing to remove
        }
        storage[bucketNumber][bucketItemNumber] = false; // Removed the element.
    }

    public boolean contains(int key) {
        int bucketNumber = hashFunctionOne(key);
        int bucketItemNumber = hashFunctionTwo(key);

        if (storage[bucketNumber] == null) {
            return false;
        }

        return storage[bucketNumber][bucketItemNumber];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

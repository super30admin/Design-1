//We are going to use double hashing based hashing collision algorithm since the primary purpose
//of hash set is to search an element in O(1) time complexity
//Time Complexity: O(1) for all operations
//Space Complexity: O(1)
//Did the code run successfully in leetcode: yes
public class MyHashSet {

    private final boolean[][] storage;
    private final int bucket;
    private final int bucketItems;

    /**
     * Instantiates the data members
     */
    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }

    /**
     *
     * @param key the key to store in the set
     * @return Calculates and returns the hash key for the primary array using modulo
     */
    private int hash1(int key) {
        return key % bucket;
    }

    /**
     *
     * @param key the key to store in the set
     * @return Calculates and returns the hash key for the secondary array using division
     */
    private int hash2(int key) {
        return key / bucketItems;
    }

    /**
     * <p>
     *     If the hash value for the primary array is 0, we initialize the nested array with 1 extra space
     *     because 10 ^ 6 falls on the 1000 index of the nested array which would result in Index Out of bounds exception
     * </p>
     *
     * adds the key to the hash set
     * @param key the key to store in the set
     */
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null) {
            if (bucket == 0) storage[bucket] = new boolean[bucketItems + 1];
            else storage[bucket] = new boolean[bucketItems];
        }

        storage[bucket][bucketItem] = true;
    }

    /**
     * returns if the secondary bucket for the primary hash key is not initialized
     * removes the key from the storage if the key is present
     *
     * @param key the key to remove from the set
     */
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null) return;

        storage[bucket][bucketItem] = false;
    }

    /**
     * returns false if the secondary bucket for the primary hash key is not initialized
     * returns true if the key is present in the storage
     *
     * @param key the key to check in the set
     */
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        final MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(5);    //storage[5[[0] = true
        myHashSet.add(15);   //storage[15][0] = true
        myHashSet.add(35);   //storage[35][0] = true
        myHashSet.add(485);  //storage[485][0] = true
        myHashSet.add(5485); //storage[485][5] = true

        System.out.println(myHashSet.contains(345)); //returns false
        myHashSet.remove(345); //return, since key does not exist

        System.out.println(myHashSet.contains(485)); //returns true
        myHashSet.remove(485); //set storage[485][0] = false
        System.out.println(myHashSet.contains(485)); //returns false
    }
}

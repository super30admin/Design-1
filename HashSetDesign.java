// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
/* Got more clarification during class for implementing it for O(1) complexity */

// Your code here along with comments explaining your approach
/* 
 * To store the key we use a array, whose index is pointing to another array.
 * To avoid collision we are using hasing method for primary array using % and for secondary array using /
 * check for all the null pointer exceptions
 */
class HashSetDesign {

    // array to store the values index wise and by doing hash
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public HashSetDesign() {
        // generating squareroot of the total size of the keys, 1000000 --> 1000 buckets
        // and 1000 bucket items per bucket.
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    // hashing key for the primary array by taking modulus
    private int hashIndex1(int key) {
        return key % buckets;
    }

    // hashing key for the secondary array by taking / , since we have tp avoid the
    // collision again in secondary array.
    private int hashIndex2(int key) {
        return key / bucketItems;
    }

    private void add(int key) {
        // generate index for bucket
        int bucket = hashIndex1(key);
        // generate index for nested array
        int bucketItem = hashIndex2(key);

        // checkoing if the primary array is null , if so check the index value, if the
        // index is 0, we add 1 element extra to avaoid nested collision.
        // or else just create a boolan array of length 1000
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        // just set the value at that index to true.
        storage[bucket][bucketItem] = true;
    }

    private void remove(int key) {
        int bucket = hashIndex1(key);
        int bucketItem = hashIndex2(key);

        // if the bucket is already empty
        if (storage[bucket] == null)
            return;

        // set the index back to false
        storage[bucket][bucketItem] = false;
    }

    private boolean contains(int key) {
        int bucket = hashIndex1(key);
        int bucketItem = hashIndex2(key);

        // check to avoid null pointer exception
        if (storage[bucket] == null)
            return false;

        return storage[bucket][bucketItem];
    }

    public static void main(String args[]) {
        HashSetDesign hashSet = new HashSetDesign();

        hashSet.add(1);
        hashSet.add(2);
        // hashSet.printArr();
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(1);
        System.out.println(hashSet.contains(2));

    }

}


public class MyHashSet {

	private int bucketSize = 1000;
    private int bucketItemsSize = 1000;
    private boolean[][] myHashSet;

    public MyHashSet() {
        // Initialize only outer array
        myHashSet = new boolean[bucketSize][];
    }

    private int hashFunc(int key) {
        return key % bucketSize;
    }

    /*
1. Why division for the second hash function (not modulus)

The idea of your 2D array design is:

The first hash function (hashFunc) chooses the bucket (outer array index).

The second hash function (hashFuncItems) chooses the position inside that bucket (inner array index).

If you want to support keys up to 1,000,000, and you pick bucketSize = 1000, then:

Each outer bucket should cover a range of 1000 numbers.
Example:

Bucket 0 → keys 0 … 999

Bucket 1 → keys 1000 … 1999

…

Bucket 1000 → keys 1,000,000

This is exactly what integer division does:

hashFunc(key)      = key % 1000         // chooses bucket index
hashFuncItems(key) = key / 1000         // chooses item position inside that bucket


If you used % (modulus) for both, you’d lose the ability to uniquely place elements, because both functions would give you just the remainder, not a split of bucket and item index. That would lead to collisions.

So:

% (modulus) → remainder = fine for bucket selection.

/ (division) → quotient = fine for item position.

Together, (key / bucketItemsSize, key % bucketSize) is like decomposing the key into two coordinates.
    */
    private int hashFuncItems(int key) {
        return key / bucketItemsSize;  // note: usually divide here, not modulus
    }

    public void add(int key) {
        int hashBucket = hashFunc(key);
        int hashItem = hashFuncItems(key);
        if (myHashSet[hashBucket] == null) {
            // allocate bucket lazily
            // bucket 0 needs one extra slot to hold key = 1_000_000 (i = 1000)
            myHashSet[hashBucket] = new boolean[hashBucket == 0 ? bucketItemsSize + 1 : bucketItemsSize];
        }
        myHashSet[hashBucket][hashItem] = true;
    }

    public void remove(int key) {
        int hashBucket = hashFunc(key);
        int hashItem = hashFuncItems(key);
        if (myHashSet[hashBucket] != null) {
            myHashSet[hashBucket][hashItem] = false;
        }
    }

    public boolean contains(int key) {
        int hashBucket = hashFunc(key);
        int hashItem = hashFuncItems(key);
        return myHashSet[hashBucket] != null && myHashSet[hashBucket][hashItem];
    }
    

}

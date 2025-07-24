// Time Complexity :
// add()      -> O(1) average time
// remove()   -> O(1) average time
// contains() -> O(1) average time

// Space Complexity :
// O(N) in worst case, where N is the number of unique keys added (bounded by 10^6)

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// Yes. Initially had confusion around how to avoid IndexOutOfBoundsException
// when handling key = 10^6, so used conditional sizing for row 0 to size+1 (1001).

// Your code here along with comments explaining your approach

class MyHashSet {
    private boolean[][] buckets;
    private final int size = 1000;

    public MyHashSet() {
        // Outer array with 1000 slots (initially all null to save space)
        buckets = new boolean[size][];
    }

    // Row is calculated using mod, to keep within 0–999
    private int getRow(int key) {
        return key % size;
    }

    // Column is calculated using integer division
    private int getCol(int key) {
        return key / size;
    }

    public void add(int key) {
        int row = getRow(key);
        int col = getCol(key);

        // Lazy initialization of inner array
        if (buckets[row] == null) {
            // Special case: row 0 might need 1001 columns to fit key = 10^6
            buckets[row] = new boolean[(row == 0) ? size + 1 : size];
        }
        buckets[row][col] = true;
    }

    public void remove(int key) {
        int row = getRow(key);
        int col = getCol(key);

        // Only try to remove if the bucket is already initialized
        if (buckets[row] != null) {
            buckets[row][col] = false;
        }
    }

    public boolean contains(int key) {
        int row = getRow(key);
        int col = getCol(key);

        // Return true only if the row exists and the specific slot is true
        return buckets[row] != null && buckets[row][col];
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        // Add values
        set.add(1);
        set.add(2);
        set.add(1000);      // Same row as 0, but col = 1
        set.add(1000000);   // Edge case, largest supported value

        // Check if values exist
        System.out.println("Contains 1? " + set.contains(1));          // true
        System.out.println("Contains 2? " + set.contains(2));          // true
        System.out.println("Contains 3? " + set.contains(3));          // false
        System.out.println("Contains 1000? " + set.contains(1000));    // true
        System.out.println("Contains 1000000? " + set.contains(1000000)); // true

        // Remove a value
        set.remove(2);
        System.out.println("Contains 2 after removal? " + set.contains(2)); // false

        // Try to remove a value not added
        set.remove(3); // No error even if not present
        System.out.println("Contains 3 after removal attempt? " + set.contains(3)); // false
    }
}

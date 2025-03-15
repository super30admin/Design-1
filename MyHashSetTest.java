class MyHashSet {

    boolean[][] storage;
    int primaryBucket;
    int secondaryBucket;

    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1001;
        this.storage = new boolean[primaryBucket][];
    }

    private int getPrimaryHash(int key) {
        return key % 1000;
    }

    private int getSecondaryHash(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            storage[primaryIndex] = new boolean[secondaryBucket];
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}

public class MyHashSetTest {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        
        // Adding elements
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(1001); // Should be handled correctly
        
        // Checking elements
        System.out.println("Contains 1: " + myHashSet.contains(1)); // true
        System.out.println("Contains 2: " + myHashSet.contains(2)); // true
        System.out.println("Contains 3: " + myHashSet.contains(3)); // false
        System.out.println("Contains 1001: " + myHashSet.contains(1001)); // true
        
        // Removing elements
        myHashSet.remove(2);
        System.out.println("Contains 2 after removal: " + myHashSet.contains(2)); // false
        
        myHashSet.remove(1001);
        System.out.println("Contains 1001 after removal: " + myHashSet.contains(1001)); // false
    }
}

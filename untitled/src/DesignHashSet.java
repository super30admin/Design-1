public class DesignHashSet
{
    private int primaryBuckets;
    private int secondaryBuckets;
    private boolean[][] storage;

    public DesignHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];
    }

    private int getPrimaryHashKey(int key) {
        return key % primaryBuckets;
    }

    private int getSecondaryHashKey(int key) {
        return key / secondaryBuckets;
    }

    public void add(int key) {
        int primaryIdx = getPrimaryHashKey(key);
        if(storage[primaryIdx] == null) {
            if(primaryIdx == 0) {
                storage[primaryIdx] = new boolean[secondaryBuckets+1];
            } else {
                storage[primaryIdx] = new boolean[secondaryBuckets];
            }
        }
        int secondaryIdx = getSecondaryHashKey(key);
        storage[primaryIdx][secondaryIdx] = true;
    }

    public void remove(int key) {
        int primaryIdx = getPrimaryHashKey(key);
        if(storage[primaryIdx] == null) {
           return;
        }
        int secondaryIdx = getSecondaryHashKey(key);
        storage[primaryIdx][secondaryIdx] = false;
    }

    public boolean contains(int key) {
        int primaryIdx = getPrimaryHashKey(key);
        if(storage[primaryIdx] == null) {
            return false;
        }
        int secondaryIdx = getSecondaryHashKey(key);
        return storage[primaryIdx][secondaryIdx];
    }

}
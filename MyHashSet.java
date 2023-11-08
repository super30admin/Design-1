//TC: O(1) for all operation
//SC: O(1) as it uses constant space
// Earlier I implemented using just one array of boolean with a size of 1000000. Below is solution with double Hashing
public class MyHashSet {
    int buckets;
    int bucketSize;
    boolean[][] arr;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketSize = 1000;
        arr = new boolean[buckets][];
    }
    private int getOuterHash(int key){
        return key % buckets;
    }
    private int getInnerHash(int key){
        return key / buckets;
    }

    public void add(int key) {
        int outerHash = getOuterHash(key);
        if(arr[outerHash] == null){
            if(outerHash == 0){
                // This is to Handle 1000000 condition where both will be 1000
                arr[outerHash] = new boolean[bucketSize+1];
            }else{
                arr[outerHash] = new boolean[bucketSize];
            }
        }
        int innerHash = getInnerHash(key);
        arr[outerHash][innerHash] = true;

    }

    public void remove(int key) {
        int outerHash = getOuterHash(key);
        if(arr[outerHash] != null){
            int innerHash = getInnerHash(key);
            arr[outerHash][innerHash] = false;
        }

    }

    public boolean contains(int key) {
        int outerHash = getOuterHash(key);
        if(arr[outerHash] == null){
            return false;
        }else{
            int innerHash = getInnerHash(key);
            return arr[outerHash][innerHash];
        }

    }
}

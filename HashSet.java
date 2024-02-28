class HashSet {
    // Time Complexity : O(1)
    // Space Complexity : O(n) worst case
    // Did this code successfully run on Leetcode : yes, 705. Design HashSet
    // Any problem you faced while coding this : NA

    int bucketLength; // 1D array, this would be of length 1000 as max elements could be 10^6, so taking sqrt of it.
    int items; // secondary array count
    boolean[][] buckets; // this will be our storage bucket

    public HashSet() {
        this.bucketLength = 1000;
        this.items = 1000;
        this.buckets = new boolean[bucketLength][]; // initially we would be creating a primary array with length bucketLength
    }

    private int hashFunctionMod(int key) {
        // Time Complexity : O(1)
        return key % this.bucketLength;
    }

    private int hashFunctionDivide(int key){
        // Time Complexity : O(1)
        return key / this.items;
    }

    public void add(int key) {
        // Time Complexity : O(1)
        int hashPrimary = hashFunctionMod(key); // calculate primary hash, to identify primary index
        if(buckets[hashPrimary] == null){ // if it is null then only create secondary array
            if(hashPrimary == 0){
                buckets[hashPrimary] = new boolean[items + 1]; // say if we want to add the biggest number in range, in this case 10^6
            } else {
                buckets[hashPrimary] = new boolean[items];
            }
        }
        int hashSecondary = hashFunctionDivide(key); // calculate secondary hash, to identify secondary index to toggle boolean to true.
        buckets[hashPrimary][hashSecondary] = true; // key has been added
    }

    public void remove(int key) {
        // Time Complexity : O(1)
        int hashPrimary = hashFunctionMod(key);
        if(buckets[hashPrimary] == null) return;
        int hashSecondary = hashFunctionDivide(key);
        buckets[hashPrimary][hashSecondary] = false;  // element has been removed
    }

    public boolean contains(int key) {
        // Time Complexity : O(1)
        int hashPrimary = hashFunctionMod(key);
        int hashSecondary = hashFunctionDivide(key);
        if(buckets[hashPrimary] != null && buckets[hashPrimary][hashSecondary]) {
            return true; // key found
        }
        return false; // key not found
    }
}


class Main1 {
    public static void main(String args[]){

        HashSet obj = new HashSet();
        obj.add(9);
        obj.remove(19);
        obj.add(14);
        obj.remove(19);
        obj.remove(9);
        obj.add(0);
        obj.add(3);
        obj.add(4);
        obj.add(0);
        obj.remove(9);
        obj.contains(4);
    }
}

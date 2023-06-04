package prog_705_designHashset;
// This solution is with the boolean array to save the extra space as int is 4 bit and boolean is 1 bit
public class MyHashSet2 {
    private int firstBucketSize ;
    private int secondBucketSize ;
    boolean[][] storage;
    public MyHashSet2() {
        this.firstBucketSize = 1000;
        this.secondBucketSize = 1000;
        this.storage = new boolean[firstBucketSize][];
    }

    public int hashFun1(int key){
        return key % firstBucketSize ;
    }
    public int hashfun2(int key){
        return key / secondBucketSize;
    }
    public void add(int key) {
        int hashVal1 = hashFun1(key);
        if(storage[hashVal1] == null)  {
            if(hashVal1 == 0){
                storage[hashVal1] = new boolean[secondBucketSize + 1];
                int hashVal2 = hashfun2(key);
                storage[hashVal1][hashVal2] = true ;
            }
            else{
                storage[hashVal1] = new boolean[secondBucketSize];
                int hashVal2 = hashfun2(key);
                storage[hashVal1][hashVal2] = true ;
            }
        }
        else{
            int hashVal2 = hashfun2(key);
            storage[hashVal1][hashVal2] = true ;
        }
    }

    public void remove(int key) {
        int hashVal1 = hashFun1(key);
        if(storage[hashVal1] == null){
            return ;
        }
        else{
            int hashVal2 = hashfun2(key);
            storage[hashVal1][hashVal2] = false ;
        }
    }

    public boolean contains(int key) {
        int hashVal1 = hashFun1(key);
        if(storage[hashVal1] == null){
            return false ;
        }

        int hashVal2 = hashfun2(key);
        if(storage[hashVal1][hashVal2] == true){
            return true ;
        }
        return false ;
    }

}

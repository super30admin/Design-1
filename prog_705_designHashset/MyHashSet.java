package prog_705_designHashset;
class MyHashSet {
    private int firstBucketSize ;
    private int secondBucketSize ;
    Integer[][] storage;
    public MyHashSet() {
        this.firstBucketSize = 1000;
        this.secondBucketSize = 1000;
        this.storage = new Integer[firstBucketSize][];
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
                storage[hashVal1] = new Integer[secondBucketSize + 1];
                int hashVal2 = hashfun2(key);
                storage[hashVal1][hashVal2] = key ;
            }
            else{
                storage[hashVal1] = new Integer[secondBucketSize];
                int hashVal2 = hashfun2(key);
                storage[hashVal1][hashVal2] = key ;
            }
        }
        else{
            int hashVal2 = hashfun2(key);
            storage[hashVal1][hashVal2] = key ;
        }
    }

    public void remove(int key) {
        int hashVal1 = hashFun1(key);
        if(storage[hashVal1] == null){
            return ;
        }
        else{
            int hashVal2 = hashfun2(key);
            storage[hashVal1][hashVal2] = null ;
        }
    }

    public boolean contains(int key) {
        int hashVal1 = hashFun1(key);
        if(storage[hashVal1] == null){
            return false ;
        }

        int hashVal2 = hashfun2(key);
        if(storage[hashVal1][hashVal2] != null){
            return true ;
        }
        return false ;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

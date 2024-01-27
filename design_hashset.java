//TimeComplexity:O(1)
//SpaceComplexity: O(n)



class MyHashSet {
    boolean [][]array;
    int primaryArraySize;
    int nestedArraySize;
    public MyHashSet() {
        this.primaryArraySize = 1000;
        this.nestedArraySize = 1000;
        this.array = new boolean[this.primaryArraySize][];
    }
    int hashFunction1(int key) {
      return key%this.primaryArraySize;
    }
    int hashFunction2(int key) {
      return key/this.nestedArraySize;
    }
    public void add(int key) {
        int primaryIndex = hashFunction1(key);
        int secondaryIndex = hashFunction2(key);
        if(array[primaryIndex] == null) {
            if(primaryIndex == 0) {
              array[primaryIndex] = new boolean[nestedArraySize+1];
            } else {
            array[primaryIndex] = new boolean[nestedArraySize];
            }
        }
        array[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = hashFunction1(key);
        int secondaryIndex = hashFunction2(key);
        if(array[primaryIndex] == null) {
            return;
        }
        array[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = hashFunction1(key);
        int secondaryIndex = hashFunction2(key);
        if(array[primaryIndex] == null) {
            return false;
    } 
    return array[primaryIndex][secondaryIndex];
}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
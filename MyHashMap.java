//Time Complexity: O(1)
//Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Pair{
    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int get(int key){
        return this.value;
    }
}

class Bucket1{
    Pair[] element;

    public Bucket1(){
        element = new Pair[1001];
    }

    public int hashCode(int key){
        return key/1000;
    }

    public void insert(int key, int value){
        int index = hashCode(key);
        element[index] = new Pair(key, value);
    }

    public int getValue(int key){
        int index = hashCode(key);
        return element[index].value;
    }

    public boolean checkKey(int key){
        int index = hashCode(key);
        if(element[index]==null)
            return false;
        return true;
    }

    public void removeKey(int key){
        if(checkKey(key)){
            int index = hashCode(key);
            element[index] = null;
        }
    }

}

class MyHashMap {

    /** Initialize your data structure here. */
    Bucket1[] bucket;
    public MyHashMap() {
        bucket = new Bucket1[1000];
    }

    public int bucketId(int key){
        return key % 1000;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int id = bucketId(key);
        if(bucket[id]==null)
            bucket[id] = new Bucket1();
        bucket[id].insert(key,value);

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int id = bucketId(key);
        if(bucket[id]==null)
            return -1;
        if(bucket[id]!=null && bucket[id].checkKey(key)==false)
            return -1;
        return bucket[id].getValue(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int id = bucketId(key);
        if(bucket[id]!=null)
            bucket[id].removeKey(key);
    }

    public static void main(String[] args){
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        System.out.println("1");
        obj.put(2,2);
        System.out.println("2");
        obj.get(1);
        System.out.println("3");
        obj.get(2);
        System.out.println("4");
        obj.get(3);
        System.out.println("5");
        obj.put(2,1);
        obj.get(2);
        obj.remove(2);
        obj.get(2);


    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
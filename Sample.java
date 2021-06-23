// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : modified after the class


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Store {
        int value;
        int key;
        Store next;
        Store(int key, int value) {
            this.value = value;
            this.key = key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
    Store[] myStore;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myStore = new Store[10000];
    }
    
    public int getHashCode(int key) {
        return key % myStore.length;
    }
    
    public Store getPrevious(int index, int key) {
        Store s = myStore[index];
        if(s == null) {
            System.out.println("prevttt ");
            myStore[index] = new Store(-1, -1);
            return myStore[index];
        }
        System.out.println("prevttt123 ");
        Store prev = s;
        while(prev.next!=null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        System.out.println("prev " + prev.key + prev.value);
        if(prev.next == null) {
            System.out.println("inside put 1" + key + value);
            prev.next = new Store(key, value);
        }else {
            prev.next.value = value;
        }        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        if(prev.next == null) {
            return -1;
        }else {
            return prev.next.value;
        }       
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHashCode(key);
        Store prev = getPrevious(index, key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

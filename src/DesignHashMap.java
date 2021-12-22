// Time Complexity :
//      push = O(1)
//      pop = O(1)
//      top = O(1)
//      getMin = O(1)
// Space Complexity : O(10000000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, Double hashing Trying
class DesignHashMap {

    int arr[] = new int[10000000];
    public DesignHashMap() {

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = -1;
        }
    }

    public void put(int key, int value) {

        arr[key] = value;


    }

    public int get(int key) {
        return arr[key];


    }

    public void remove(int key) {
        arr[key] = -1;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
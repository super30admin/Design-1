/**
 * Space complexity is O(n)
 * time complexity of add remove and get operations is O(1)
 */
class MyHashMap {
    private int[][] arr;
    private int bucket;
    private int items;
    

    public MyHashMap() {
        arr = new int[1000][];
        bucket = 1000;
        items = 1000;
    }

    private int bucketIndex(int key) {
        return key%bucket;
    }

    private int itemPosition(int key) {
        return key/items;
    }

    public void put(int key, int value) {
        int bucketIndex = bucketIndex(key);
        int position = itemPosition(key);
        if(arr[bucketIndex] == null) {
            arr[bucketIndex] = new int[1001];
            for(int i = 0; i <= 1000; i++) {
                arr[bucketIndex][i] = -1;
            }
        }
        arr[bucketIndex][position] = value;
    }
    
    public int get(int key) {
        int bucketIndex = bucketIndex(key);
        int position = itemPosition(key);
        if(arr[bucketIndex] != null) {
            return arr[bucketIndex][position];
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucketIndex = bucketIndex(key);
        int position = itemPosition(key);
        if(arr[bucketIndex] != null) {
            arr[bucketIndex][position] = -1;
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
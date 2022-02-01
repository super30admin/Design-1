/*
    Put Time Complexity: O(1)  
    Get Time Complexity: O(1)
    Remove Time Complexity: O(1)
    
    Space Time Complexity: O(n)
    
    Accepted Leetcode URL: https://leetcode.com/submissions/detail/632571240/  
*/
class MyHashMap {

    private int[] arr;
    
    public MyHashMap() {
        this.arr = new int[1000001];
        Arrays.fill(this.arr, -1);
    }
    
    public void put(int key, int value) {
        this.arr[key] = value;
    }
    
    public int get(int key) {
        return this.arr[key];
    }
    
    public void remove(int key) {
        this.arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Time Complexity: O(1) for all operations
// Space Complexity: The space complexity is O(N) where N = 1000001
// Idea: We can use a boolean array to store the values. If the value is present, we can set the value to true. If the value is not present, we can set the value to false. This way we can perform all the operations in O(1) time.
// Did it run on Leetcode: Yes
// Any problems faced: No


class DesignHashSet {

    private boolean[] data;

    public DesignHashSet() {
        data = new boolean[1000001];
    }
    
    public void add(int key) {
        data[key] = true;
    }
    
    public void remove(int key) {
        data[key] = false;
    }
    
    public boolean contains(int key) {
        return data[key];
    }
}

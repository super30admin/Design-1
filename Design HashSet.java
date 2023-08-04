// Created HashSet procedures to add, remove, and search the array
// used parentList to declare list with ARRAY Size of 100 and childList as a bucket within parentList to store values
// Space Complexity: O(K+M) where K is number of pre-defined buckets and M is number of keys
// Time Complexity: O(N/K) where n is all possible values, and k is number of buckets in the hashmap

class MyHashSet {
    
    private final int MAX_VALUE = 10000000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentList;
    
    boolean[] arr;
    
    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        }
        else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}

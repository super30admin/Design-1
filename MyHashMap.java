// Time Complexity : O(L)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class MyHashMap {
    List<int[]>[] lists;
    
    public MyHashMap() {
        lists = new ArrayList[10000];
        for (int i = 0; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }
    }
    
    private int getHash(int key){
        return key % 10000;
    }
    
    public void put(int key, int value) {
        int idx = getHash(key);
        for (int i = 0; i < lists[idx].size(); i++){
            if (lists[idx].get(i)[0] == key){
                lists[idx].get(i)[1] = value;
                return;
            }
        }
        lists[idx].add(new int[]{key,value});
    }
    
    public int get(int key) {
        int idx = getHash(key);
        for (int i=0; i<lists[idx].size();i++){
            if (lists[idx].get(i)[0] == key){
                return lists[idx].get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = getHash(key);
        for (int i = 0; i < lists[idx].size(); i++){
            if (lists[idx].get(i)[0] == key){
                lists[idx].remove(i);
            }
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
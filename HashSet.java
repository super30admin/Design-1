// Time Complexity : O(n) for add, remove, and contains — each linearly scans the ArrayList
// Space Complexity : O(n) — stores up to n unique keys in the ArrayList
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MyHashSet {
    ArrayList<Integer> hashSet = new ArrayList<>();

    public MyHashSet() {

    }

    public void add(int key) {
        boolean repeated = false;
        for(int i=0;i < hashSet.size(); i++){
            if(hashSet.get(i)==key){
                repeated = true;
            }
        }
        if(repeated== false){
            hashSet.add(key);
        }
    }

    public void remove(int key) {
        for(int i=0;i<hashSet.size();i++){
            if(hashSet.get(i)==key){
                 hashSet.remove(Integer.valueOf(key));
            }
        }
    }

    public boolean contains(int key) {
         for(int i=0;i<hashSet.size();i++){
            if(hashSet.get(i)==key){
                 return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
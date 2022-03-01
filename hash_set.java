//Time Complexity : O(N)
//Space Complexity: O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class MyHashSet {

    ArrayList<Integer> arr;
    
    public MyHashSet() {
        
        arr = new ArrayList<>();
    }
    
    public void add(int key) {
        
        if(!contains(key))
        {
            arr.add(key);
        }
    }
    
    public void remove(int key) {
        
        arr.remove(new Integer(key));
        
    }
    
    public boolean contains(int key) {
        
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)==key)
            {
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
/* Time Complexity: O(1) */
/* Space Complexity: O(n) */
/* Did this code successfully run on Leetcode : Yes */
/* Any problem you faced while coding this : I faced some syntactical adn compilation errors. ALoso i had to take help from the google solution to proceed with the problem*/

class MyHashSet {
    
    private final int max_value = 1000000;
    private final int array_size = 1000;
    private List<List<Integer>> parentList;

    
    /* Constructor where I initiliazed my Data structure */
    public MyHashSet() {
        parentList = new ArrayList<>(array_size);
        for(int i = 0 ; i < array_size ; i++){
            parentList.add(null);
        }
    }
    
    public void add(int key) {
       /*Mapping int to one bucket in parentList using modulo  */
        int index =  key % array_size;
        
        /*Taking childList for that bucket where the key needs to go */
        List<Integer> childList = parentList.get(index);
        if (childList == null){
            List<Integer> List = new LinkedList();
            List.add(key);
            parentList.set(index, List);
        } 
        else {
            if(!childList.contains(key)){
                childList.add(key);
            }
            
        }
        
    
    }
    
    public void remove(int key) {
        
    /* To find the bucket where that key might be present */
        int index = key % array_size;
        
    /*Taking childList for that bucket where the key is present */
        List<Integer> childList = parentList.get(index);
        
        if(childList != null){
            childList.remove(Integer.valueOf(key));  /* Used Integer.valueOf() to remove the int element & not place */
            
        }
        
    }
    
    public boolean contains(int key) {
        /* To find the bucket where that key might be present */
        int index = key % array_size;
        
    /*Taking childList for that bucket where the key is present */
        List<Integer> childList = parentList.get(index);
        
        return childList !=null && childList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
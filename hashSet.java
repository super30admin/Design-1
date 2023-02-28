// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
// Implemented Hashset using Array and used chaining using LinkedList to avoid collision

class MyHashSet {

    private final int Array_size= 100;
    private List<List<Integer>> ParentList;
    public MyHashSet() {

        ParentList = new ArrayList<>(Array_size);
        for(int i=0; i< Array_size; i++)
        {
            ParentList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key%Array_size;

        List<Integer> childlist=ParentList.get(index);

        if(childlist==null)
        {
           List<Integer> list = new LinkedList<>();
           list.add(key);
           ParentList.set(index, list);
        }
        else {
                if(!childlist.contains(key))
                 childlist.add(key);
        }

        
    }
    
    public void remove(int key) {
       int index = key%Array_size;
       List<Integer> childlist = ParentList.get(index);

       if(childlist!= null)
        childlist.remove(Integer.valueOf(key));
    }

    
    public boolean contains(int key) {
      int index = key%Array_size;
      List<Integer> childlist = ParentList.get(index);

      return childlist != null && childlist.contains(key);

    }
}

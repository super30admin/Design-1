import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    
    private final int ARRAY_SIZE=100;
    private List<List<Integer>> parentList;
    
    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i=0; i<ARRAY_SIZE; i++)
        {
            parentList.add(null);
        }
        
    }
    
    public void add(int key) {
        int index = key % ARRAY_SIZE; 
        List<Integer> childList = parentList.get(index);
        if(childList == null)
        {
          List<Integer> list = new LinkedList<>();
          list.add(key);
          parentList.set(index, list);
        }
        else
        {
          if(!childList.contains(key))
          {
            childList.add(key);
          }
        }
    }
    
    public void remove(int key) 
    {
      int index = key % ARRAY_SIZE;
      List<Integer> childList = parentList.get(index);
      if( childList != null)
      {
        childList.remove(Integer.valueOf(key));

      }
    }
    
    public boolean contains(int key) 
    {
       int index = key % ARRAY_SIZE;
       List<Integer> childList = parentList.get(index);
       return childList != null && childList.contains(key);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
      MyHashSet myHashSet = new MyHashSet();
      myHashSet.add(1);      // set = [1]
      myHashSet.add(2);      // set = [1, 2]
      myHashSet.contains(1); // return True
      myHashSet.contains(3); // return False, (not found)
      myHashSet.add(2);      // set = [1, 2]
      myHashSet.contains(2); // return True
      myHashSet.remove(2);   // set = [1]
      myHashSet.contains(2); // return False, (already removed)
    }
}
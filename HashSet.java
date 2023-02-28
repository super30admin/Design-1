import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashSet {
/*
Method1 -
Time Complexity - O(1)
Space Complexity - O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
We initialize a boolean array, while adding keys, we make the key as index and set that particular index value to true. When we want to remove an element,
we make that particular index to false. For contains, we check if that particular key value is true, else return false.

Method2 -
Time Complexity - O(1)
Space Complexity - O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No

 */
    //METHOD-1
    /*boolean arr[];
    public HashSet() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        arr[key] = true;

    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }*/

    //METHOD-2
    private final int bucket_size = 100;
    private List<List<Integer>> parentList;
    public HashSet() {
        parentList = new ArrayList<>(bucket_size);
        for(int i=0;i<bucket_size;i++){
            parentList.add(null);
        }
    }
//O(1)
    public void add(int key) {
        int index = key%bucket_size;
        List<Integer> temp = parentList.get(index);
        if(temp == null)  {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.add(index, list);
        } else {
            if(!temp.contains(key)) {
                temp.add(key);
                parentList.set(index, temp);
            }
        }
    }
//O(N)
    public void remove(int key) {
        int index = key%bucket_size;
        List<Integer> temp = parentList.get(index);
        if(temp != null)  {
            temp.remove(Integer.valueOf(key));
        }
    }

    //O(N)
    public boolean contains(int key) {
        int index = key%bucket_size;
        List<Integer> temp = parentList.get(index);
        if(temp != null) {
            return temp.contains(key);
        }
        return false;
}

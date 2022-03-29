import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class myBucket{
    int MAX_VALUE = 100000;
    int array_size =100;
    List<List<Integer>> parentList;

    public myBucket(){
        parentList = new ArrayList<>(array_size);
        for(int i=0;i<array_size;i++){
            parentList.add(null);
        }
    }

    public void add(int key){
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList == null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        }
        else{
            if(!childList.contains(key)){
                childList.add(key);
            }
        }
    }

    public void remove(int key){
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(index));
        }
    }

    public boolean contains(int key){
        boolean res = false;
        int index = key % array_size;
        List<Integer> childList = parentList.get(index);
        if(childList != null && childList.contains(key)){
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
        myBucket mb = new myBucket();
        mb.add(1);
        mb.add(2);
        System.out.println(mb.contains(1));
        System.out.println(mb.contains(3));
        mb.add(2);
        System.out.println(mb.contains(2));
    }
}
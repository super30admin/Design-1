// Time Complexity :  The time complexity is O(N/K) where k is the size of the arrayList assuming that each bucket has size N/k and N is maximum number of values 
// which is 1000000 in this case
// Space Complexity : The space complexity if O(K+ M) where M is the number of unique keys inserted 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :
//This code was faster than only 37% of java submissions so it is not ideal. I have to improve on this. 

// Your code here along with comments explaining your approach
class MyHashSet {
    private List<List<Integer>> arrayList;
    private int arraySize = 809; //choose a prime number to avoid collisions
    private int maxValue = 1000000;
    
    public MyHashSet() {
        arrayList = new ArrayList<>(arraySize);
        for(int i =0; i<arraySize;i++)
        {
            arrayList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key%arraySize;
        List<Integer> bucket = arrayList.get(index);
        if(bucket==null)
        {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            arrayList.set(index, list);
        }
        else
        {
            if(!bucket.contains(key))
                bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key%arraySize;
        List<Integer> bucket = arrayList.get(index);
        if(bucket!=null)
        {
            bucket.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key%arraySize;
        List<Integer> bucket = arrayList.get(index);
        return bucket!=null&&bucket.contains(key);
    }
}

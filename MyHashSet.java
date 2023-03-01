//time complexity : O(n)
//space complexity: O(1)
// successfully executed on leetcode

class MyHashSet {
    int size = 100;
    List<List<Integer>> parentList ;

    public MyHashSet() {
        //assigned size to list of list
    parentList= new ArrayList<>(size);
    for(int i=0; i<size; i++){
        parentList.add(null);
    }
    }
    
    // function to find hash code
    public int hash(Integer key){
        return key%100; 
    }

    public void add(int key) {
        int index = hash(key);

        //getting index of element (list) of the list 
        List<Integer> childList = parentList.get(index);

        //check if particular index element is null, then create a node for the key
         if(childList== null){
             LinkedList<Integer> linkedList = new LinkedList<>();
             linkedList.add(key);
             parentList.set(index, linkedList);
         }
         else{

            // if childlist does not contain any key add it
             if(!childList.contains(key)){
                 childList.add(key);

             }
         }
    }
    
    public void remove(int key) {
        //find the postion using hash function then remove the element
        int index = hash(key);
        List<Integer> childList = parentList.get(index);
        if(childList!= null){
        childList.remove(Integer.valueOf(key));
    }
    }
    public boolean contains(int key) {
        int index = hash(key);
        //find the position and check whether element is present or not
        List<Integer> childList = parentList.get(index);
        if(childList !=null && childList.contains(key)){
            return true;
        }
        return false;
    }
}
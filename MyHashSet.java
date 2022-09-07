// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved collision by increasing size of hashset, unsure of implementation of double hashing.

//We are creating an array and the mod of the value to the size of the created array gives us index to add/insert the value(hashing function).
//To get the index to add/remove/check if the index contains the value, we call the hashing function 

class MyHashSet {
    int[] setarray;
        public MyHashSet() {
       setarray = new int[1000000];
            for(int i=0; i<setarray.length; i++){
                setarray[i]=-1;
            }
        }
        
        public void add(int key) {
            int index= hashfunction(key);
            setarray[index]=key;
        }
        
        public void remove(int key) {
            int index= hashfunction(key);
            setarray[index]=-1;
        }
        
        public boolean contains(int key) {
            int index= hashfunction(key);
            if(setarray[index]== key){
                return true;
            }
            else return false;
        }
        
        public int hashfunction(int key){
       int index= key% setarray.length;
            return index;
        }
    }
    
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
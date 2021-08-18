// Time Complexity : O(n) - n is the number I use for developing my hashcode
    // Ex. In my case that number is 1000 where to generate hashkey I use (key%1000) so even if I get same hashkeys for similar inputs I will have maximum of 1000 cases for similar hashkeys and will have to iterate over those
    // Not sure if this is correct or not 
// Space Complexity : 0(n^2) -  n is the number I use for developing my hashcode
    // Ex. I will array of length n and in each array index a max ArrayList of size n so n^2
    // Not sure if this is correct or not 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : First I tried doing with creating an array with size of Integer.MAX_Value and key as index of aray and it gave me memory limit exceeded error, the second approach I took was creating an array of array with hash function generate the index of the first array whihc conatins second array that stores values with same hash key but due t wrong implementation it gave me memory limit exceeded error, After through our discussion in first lecture I created a smaller array with Each array containing a ArrayList in which I used Java Pair implementation but it seems it is immutable so implemented a custom Pair class to store value in ArrayList


// Your code here along with comments explaining your approach
class Pair {
    int key;
    int value;
    
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    public int getKey(){
        return key;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int value){
        this.value = value;
    }
    
}

class MyHashMap {
    int n;
    ArrayList<Pair>[] arrList;

    /** Initialize your data structure here. */
    public MyHashMap() {
        n = 1000;
        arrList = new ArrayList[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
         
        if(arrList[key%n] == null) arrList[key%n] = new ArrayList();
        Pair pair = getPairFromList(arrList[key%n], key);
        
        if(pair == null) {
            pair = new Pair(key, value);
            arrList[key%n].add(pair);
        }
        else pair.setValue(value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(arrList[key%n] == null) return -1;
        
        Pair pair = getPairFromList(arrList[key%n], key);
        
        if(pair == null) return -1;
        else return pair.getValue();
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ArrayList<Pair> tempList = arrList[key%n];
        if(tempList == null) return;
        
        for(int i=0; i<tempList.size(); i++){
            if(tempList.get(i).getKey() == key){
                tempList.remove(i);
                return;
            }
        }
    }
    
    private Pair getPairFromList(ArrayList<Pair>list, int key){
        for(Pair tempPair : list){
            if(tempPair.getKey() == key) return tempPair;
        }

        return null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

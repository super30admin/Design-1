//s30: https://www.thes30.com/problem/5c91d568fdc132001682c131/solutions
//https://www.youtube.com/watch?v=G1biLTsvrWE
// Used Two dimensional array with 1000 rows and 1000 cols. In total,we can store 10^6 elements as given in input.
//Identifying row using Hash1 method.
//Identifying col using Hash2 method.
//Add- place an element at that place. //Remove- removing an element from that place. //Check- checking an element from the respective place.
//TC: O(1)
//SC: O(1)
class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;
    
    public MyHashSet() {
       this.primaryBuckets=1000;
       this.secondaryBuckets=1000;
       this.storage=new boolean[1000][];

    }
    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int h1=hash1(key);
        //To handle edge case.. 0 to 1000000 contains 1000001 elements. So, add extra size for one array to hold that extra element
        if(storage[h1]==null){
            if(h1==0){
                storage[h1]=new boolean[secondaryBuckets+1];
            }else{
                storage[h1]=new boolean[secondaryBuckets];
            }
           
        }

        int h2=hash2(key);
        storage[h1][h2]=true;
    }
    
    //TC: O(1)
    //SC: O(1)
    public void remove(int key) {
        int h1=hash1(key);
        if(storage[h1]!=null){
            int h2=hash2(key);
            storage[h1][h2]=false;
        }
        
    }
    //TC: O(1)
    //SC: O(1)
    public boolean contains(int key) {
        int h1=hash1(key);
        if(storage[h1]!=null){
            int h2=hash2(key);
            if(storage[h1][h2]==false){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

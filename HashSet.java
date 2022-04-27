
/* Time and Space complexity is O(1)
 Since i saw in th elast minute that the HashMap problem is changed to hash set didnot think of more optimal approach
 to reduce space

*/
class MyHashSet {

    int[] arr;
    
    public MyHashSet() {
     arr=new int[1000001];    
    }
    
    public void add(int key) {   
        arr[key]=1;   }
    
    public void remove(int key) {
        arr[key]=0;    
    }
    
    public boolean contains(int key) {
        if(arr[key]==0) {
            return false;}
        else {
        return true;}
    }
}
// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*
@auther = PRAYAG PATEl
@Problem = S30 FAANMG Problem #4 {Easy},706. Design HashMap
@asked = Microsoft
*/

/**@approach
 * using two stack to implement Que
 * for enQueue coping the content of queue stack into Operational Stack --> push new elemnt into queue_stack -->copy back elemnts from oprerational stack into queue stack
 * pop,peek and empty operation performed as usual time
 * 
 * */

class MyHashMap {
    int hm[];

    public MyHashMap() {
        hm = new int[1000001];
        Arrays.fill(hm,-1);
    }
    
    public void put(int key, int value) {
        hm[key]=value;
    }
    
    public int get(int key) {
        return hm[key];
    }
    
    public void remove(int key) {
        hm[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
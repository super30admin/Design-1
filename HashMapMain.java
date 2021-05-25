// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, but with poor time performance. Might need to improve the logic.
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Arrays;

class MyHashMap {

    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[10000000];
        //Initialized with -1
        Arrays.fill(map, -1);
    }
   
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
   
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] != -1 ? map[key] : -1;
    }
   
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }

    public void printFew() {
        System.out.println("\n");
        for(int i = 0; i < 10; i++) {
            System.out.print(map[i]+" ");
        }
    }
}
//Driver Code
class HashMapMain { 
    public static void main(String args[]) 
    {
        MyHashMap obj = new MyHashMap();
        obj.put(5,200);
        obj.put(9,300);
        obj.put(3,600);
        obj.printFew();
        int param = obj.get(9);
        System.out.println("\n GetValue: "+param);
        obj.put(3,700);
        obj.printFew();
        obj.remove(9);
        obj.printFew();
    } 
}

//OUTPUT

/**

-1 -1 -1 600 -1 200 -1 -1 -1 300
 GetValue: 300


-1 -1 -1 700 -1 200 -1 -1 -1 300

-1 -1 -1 700 -1 200 -1 -1 -1 -1
 */
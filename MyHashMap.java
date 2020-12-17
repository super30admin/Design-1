
// Time Complexity : Push Operation --> 1. It takes O(1) time to get index and then push it to arrayList.
//                                      2. It takes O(1) time to get index and check for the value in pos
//                                      3. It takes O(1) time to get index, its pos and then remove the value
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
Preconditions:
1. All keys and values will be in the range of [0, 1000000].
2. The number of operations will be in the range of [1, 10000].
 */

class MyHashMap{

    /*
    1. This problem can be imagined like a 2D matrix problem. We need to first find suitable row
    2. Once we find row, we need to push the value in suitable position for future retrieve
    3. to find suitable row we can use modulus operator on key with respect to length
    4. Key we can get from input from user and for length we can refer to precondition that is 1000000
     */

    private int final MAX = 1000000;

    //Using Pair DS so that I dont need to define extra Node class with attributes. Pair DS is similar
    //pre defined object in java.
    //here first Integer is Key and second Integer is value;
    //and i am using array of lists to store values
    private List<Pair<Integer,Integer>> map[];

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ArrayList[MAX];
    }

    //this function is to find row
    private int getIndex(int key){
        return key%MAX;
    }

    //this function is find corresponding value in col
    private int getPos(int key,int index){
        if (map[index] == null){
            return -1;
        }
        else{
            for (int i = 0; i < map[index].size(); i++){
                if (map[index].get(i).getKey() == key){
                    return i;
                }
            }
            return -1;
        }
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        int pos = getPos(key,index);

        if (pos == -1){
            if (map[index] == null){
                map[index] = new ArrayList<Pair<Integer,Integer>>();
            }
            map[index].add(new Pair(key,value));
        }
        else{
            map[index].set(pos,new Pair(key,value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        int pos = getPos(key,index);
        if (pos == -1){
            return -1;
        }
        else{
            return map[index].get(pos).getValue();
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key,index);
        if (pos == -1){
            return;
        }
        else{
            map[index].remove(pos);
        }
    }
}

/*
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)
 */

/*
Leetcode Analysis:
33 / 33 test cases passed.
Status: Accepted
Runtime: 13 ms
Memory Usage: 44 MB
 */





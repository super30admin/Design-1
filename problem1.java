// Time Complexity :  O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : If a key value larger than this range is provided, it will result in an array index out of bounds exception

class MyHashSet {

int size = (int)Math.pow(10, 6)+1;
boolean[] flag;
public MyHashSet() {
    flag = new boolean[size];
}

public void add(int key) {
    flag[key]=true;
}

public void remove(int key) {
    flag[key]=false;
}

public boolean contains(int key) {
    return flag[key];
}

}
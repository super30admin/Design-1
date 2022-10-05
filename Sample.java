// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyHashSet {

    // Using arraylist

/*    ArrayList<Integer> array = new ArrayList();
    public MyHashSet() {

    }

    public void add(int key) {
        if(!this.contains(key)){
            array.add(key);
        }
    }

    public void remove(int key) {
        for (int i=0 ; i<this.array.size();i++) {
            if (this.array.get(i) == key) {
                array.remove(i);
            }
        }
    }

    public boolean contains(int key) {
        return  array.contains(key);

    }*/


    // Using double hashing

    private  static final int BUCKET_1_SIZE = 1000;
    private  static final int BUCKET_2_SIZE = 1000;
    private boolean [][] arr;

    private int getHashKay1(int key){
        return key/BUCKET_1_SIZE;
    }

    private int getHashKay2(int key){
        return key%BUCKET_2_SIZE;
    }

    public MyHashSet() {
        arr = new boolean[BUCKET_1_SIZE + 1][];
    }

    public void add(int key) {
        int key1 = this.getHashKay1(key);
        int key2 = this.getHashKay2(key);


        if (arr[key1] == null) {
            if (key == 1_000_000){
                arr[key1] = new boolean[1];
            }
            else {
                arr[key1] = new boolean[BUCKET_2_SIZE];
            }
        }
        arr[key1][key2] = true;
    }

    public void remove(int key) {
        int key1 = this.getHashKay1(key);
        int key2 = this.getHashKay2(key);
        if (arr[key1] != null) {
            arr[key1][key2] = false;
        }
    }

    public boolean contains(int key) {
        int key1 = this.getHashKay1(key);
        int key2 = this.getHashKay2(key);

        if (arr[key1] == null){
            return false;
        }
        return arr[key1][key2];
    }


    public static void main (String args[]) {

        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1000_000);      // set = [1]
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}



// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used some resources
public class Design1 {

    class MyHashSet {
        //to keep track of array length
        int counter = 0;
        int[] array = new int[10];

        public MyHashSet() {

        }

        public void add(int key) {
            if (counter >= array.length) {
                //copies into new array
                int[] array2 = new int[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    array2[i] = array[i];
                }
                array = array2;
                array2 = null;

            }


            array[counter] = key;
            counter++;

        }

        public void remove(int key) {
            for (int i = 0; i < counter; i++) {

                if (array[i] == key)
                    array[i] = -1;
            }
        }

        public boolean contains(int key) {
            for (int i = 0; i < counter; i++) {

                if (array[i] == key) {
                    if (array[i] < 0) return false;
                    return true;
                }
            }
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


// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class HashSet {

        boolean arr[];

        public HashSet() {
            arr = new boolean[1000001];
        }

        public void add ( int key){
            arr[key] = true;

        }

        public void remove ( int key){
            arr[key] = false;


        }

        public boolean contains ( int key){
            return arr[key];

        }

    }

import java.util.Arrays;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Problem1 {

    public static class MyHashSet {
        public final int BUCKET_SIZE = 1001; // instead of using 1001 we can also have a check when key = 10^6 =>
                                             // hashSet[i]
                                             // = new boolean[1];

        public boolean[][] hashSet;

        public int hash1(int key) {
            return key / BUCKET_SIZE;
        }

        public int hash2(int key) {
            return key % BUCKET_SIZE;
        }

        public MyHashSet() {
            hashSet = new boolean[BUCKET_SIZE][];
        }

        public void add(int key) {
            int i = hash1(key);
            int j = hash2(key);
            if (hashSet[i] == null) {
                hashSet[i] = new boolean[BUCKET_SIZE];
            }
            hashSet[i][j] = true;
        }

        public void remove(int key) {
            int i = hash1(key);
            int j = hash2(key);
            if (hashSet[i] != null) {
                hashSet[i][j] = false;
            }
        }

        public boolean contains(int key) {
            int i = hash1(key);
            int j = hash2(key);
            if (hashSet[i] == null) {
                return false;
            }
            return hashSet[i][j];
        }
    }

    public static void main(String[] args) {
        String[] queries = new String[] { "MyHashSet", "add", "add", "contains", "contains", "add", "contains",
                "remove", "contains" };
        int[] values = new int[] { 0, 2, 2, 2, 2, 2, 2, 2, 2 };
        MyHashSet set = new MyHashSet();
        boolean[] result = new boolean[queries.length];
        for (int i = 1; i < queries.length; i++) {
            // if (queries[i].equals("MyHashSet")) {
            // continue;
            // }
            if (queries[i].equals("add")) {
                set.add(values[i]);
                result[i] = false;
            }
            if (queries[i].equals("contains")) {
                result[i] = set.contains(values[i]);

            }
            if (queries[i].equals("remove")) {
                set.remove(values[i]);
                result[i] = false;
            }
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
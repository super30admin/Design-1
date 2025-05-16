package Problem1;
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class DesignHashset {
    static class MyHashSet {
        private boolean[][] arr;
        private int len;
        public MyHashSet() {
            len = 1000;
            arr = new boolean[len][];
        }
        private int hash1(int key) {
            return key % 1000;
        }
        private int hash2(int key) {
            return key / 1000;
        }
        public void add(int key) {
            int index = hash1(key);
            if(arr[index] == null) {
                if(index == 0) {
                    arr[index] = new boolean[len +1];
                } else {
                    arr[index] = new boolean[len];
                }
            }
            arr[index][hash2(key)] = true;
        }

        public void remove(int key) {
            int index = hash1(key);
            if(arr[index] == null) {
                return;
            }
            arr[index][hash2(key)] = false;

        }

        public boolean contains(int key) {
            int index = hash1(key);
            if(arr[index] == null) {
                return false;
            }
            return arr[index][hash2(key)];
        }

        public static void main(String[] args) {
            MyHashSet set = new MyHashSet();
            set.add(2);
            set.add(3);
            set.add((4));
            System.out.println("does hash has 3 " + set.contains(3));
            set.remove(3);
            System.out.println("does hash has 3 " + set.contains(3));
        }
    }
}

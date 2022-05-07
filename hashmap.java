//Time Complexity :O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes

class MyHashMap {
    private final int MAX_LEN = 100000;// the amount of buckets
    private List<Pair<Integer, Integer>>[] map; // hash map implemented by array
    /** Returns the corresponding bucket index. */
    private int getIndex(int key) {
        return key % MAX_LEN;
        /** Search the key in a specific bucket. Returns -1 if the key does not existed. */
        private int getPos(int key, int index) {
            List<Pair<Integer, Integer>> temp = map[index];
            if (temp == null) {
                return -1;
            }
            // Iterate all the elements in the bucket to find the target key.
            for (int i = 0; i < temp.size(); ++i) {
                if (temp.get(i).getKey() == key) {
                    return i;
                }
            }
            return -1;
        }
        /** Initialize your data structure here. */

         public MyHashMap() {
            map = (List<Pair<Integer, Integer>>[])new ArrayList[MAX_LEN];
        }
        public void put(int key, int value) {
            int index = getIndex(key);
            int pos = getPos(key, index);
            if (pos < 0) {
                if (map[index] == null) {
                    map[index] = new ArrayList<Pair<Integer, Integer>>();
                }
                map[index].add(new Pair(key, value));
            }

            else {
                map[index].set(pos, new Pair(key, value));
            }
        }
        public int get(int key) {
            int index = getIndex(key);
            int pos = getPos(key, index);
            if (pos < 0) {
                return -1;
            } else {
                return map[index].get(pos).getValue();

            }
        }
        public void remove(int key) {
            int index = getIndex(key);
            int pos = getPos(key, index);
            if (pos >= 0) {
                map[index].remove(pos);
            }
        }

    }

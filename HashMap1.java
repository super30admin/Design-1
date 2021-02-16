import java.util.ArrayList;
import java.util.List;

public class HashMap1 {
    private class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    private class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            bucket = new ArrayList<>();
        }

        public void update(Integer key, Integer value) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).first.equals(key)) {
                    bucket.get(i).second = value;
                    return;
                }
            }

            bucket.add(new Pair<Integer, Integer>(key, value));
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.first.equals(key)) {
                    return pair.second;
                }
            }
            return -1;
        }

        public void remove(Integer key) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).first.equals(key)) {
                    bucket.remove(i);
                }
            }
        }
    }

    private int keySpace;
    private List<Bucket> hashTable;

    public HashMap1() {
        keySpace = 2069;
        hashTable = new ArrayList<>();

        for (int i = 0; i < keySpace; i++) {
            hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashkey = key % keySpace;
        hashTable.get(hashkey).update(key, value);
    }

    public int get(int key) {
        int hashkey = key % keySpace;
        return hashTable.get(hashkey).get(key);
    }

    public void remove(int key) {
        int hashkey = key % keySpace;
        hashTable.get(hashkey).remove(key);
    }

    public static void main(String[] args) {
        HashMap1 hm = new HashMap1();
        hm.put(12, 144);
        hm.put(2, 4);
        hm.put(10, 100);

        System.out.println(hm.get(3));
        System.out.println(hm.get(12));

        hm.remove(2);
        System.out.println(hm.get(2));
    }
}

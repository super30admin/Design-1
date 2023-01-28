class MyHashSet {

    class Bucket {
        LinkedList<Integer> container;

        Bucket() {
            container = new LinkedList<>();
        }

        void insert(Integer key) {
            int index = container.indexOf(key);
            if(index == -1) {
                container.addFirst(key);
            }
        }

        void delete(Integer key) {
            container.remove(key);
        }

        boolean exists(Integer key) {
            int index = container.indexOf(key);
            if(index == -1) {
                return false;
            }
            return true;
        }
    }

    Bucket[] buckets;
    int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.buckets = new Bucket[this.keyRange];
        for(int i = 0; i < keyRange; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int hash(Integer key) {
        return key % keyRange;
    }

    public void add(int key) {
        int index = hash(key);
        buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].exists(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
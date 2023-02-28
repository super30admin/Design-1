import java.util.*;



class Pair<U> {
    public U ky;

    public Pair( U ky) {
        this.ky = ky;
    }
}

class Bucket {
    public List<Pair<Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer>>();
    }

    public void update(int key) {
        boolean bool = false;
        for(Pair<Integer> pair : this.bucket) {
            if( pair.ky.equals(key)) {
                pair.ky = key;
                bool = true;
            }
        }

        if( !bool ) {
            Pair<Integer> pa = new Pair<Integer>(key);
            this.bucket.add(pa);
        }
    }

    public boolean contains_key(int key) {
        for(Pair<Integer> pair : this.bucket) {
            if( pair.ky.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {
        for(Pair<Integer> pair : this.bucket) {
            if( pair.ky.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }

}


public class MyHashSet {
    public int keySpace;
    public List<Bucket> set;

    public MyHashSet() {
        this.keySpace = 2069;
        this.set = new ArrayList<Bucket>();
        for(int i = 0; i < this.keySpace; i++) {
            this.set.add(new Bucket());
        }
    }

    public void add(int key) {
        int index = key % this.keySpace;
        this.set.get(index).update(key);
    }

    public void remove(int key) {
        int index = key % this.keySpace;
        this.set.get(index).remove(key);
    }

    public boolean contains(int key) {
        int index = key % this.keySpace;
        return this.set.get(index).contains_key(key);
    }
}


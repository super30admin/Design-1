import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private List<Integer> a;

    public MyHashSet() {
        a=new ArrayList<Integer>();

    }

    public void add(int key) {
        if(!a.contains(key)){
            a.add(key);
        }
    }

    public void remove(int key) {
        if(!a.isEmpty()){
            a.remove((Object) key);}

    }

    public boolean contains(int key) {
        return  a.contains((Object) key);

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
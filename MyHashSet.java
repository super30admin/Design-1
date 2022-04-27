import java.util.LinkedList;
//time complexity: O(1) //since we are using linklist adding at the head and delete directly at the index.
//space complexity: O(N)
//leetcode : Yes


class Store {
    LinkedList<Integer> container;

    public Store() {
        container = new LinkedList<Integer>();
    }

    public void insert(int key) {
        int index = container.indexOf(key);
        if (index == -1) {
            container.addFirst(key);
        }
    }

    public void delete (int key) {
         int index = container.indexOf(key);
         container.remove(index);
    }

    public boolean exists(int key) {
         int index = container.indexOf(key);
         return (index != -1);
    }
}
public class MyHashSet {
    final int hash_key = 1000;
    Store[] set = new Store[hash_key];
    public MyHashSet() {
         for (int i = 0; i < hash_key; i++) {
             set[i] =  new Store();
         }
    }

    public void add(int key) {
        int set_index = key%hash_key;
        System.out.println("Add "+ set_index);
        set[set_index].insert(key);
    }

    public void remove(int key) {
        int set_index = key%hash_key;
        System.out.println(set_index);
        set[set_index].delete(key);
    }

    public boolean contains(int key) {
        int set_index = key%hash_key;
        return set[set_index].exists(key);
    }

    public static void main(String args[]) {

        MyHashSet obj = new MyHashSet();
        obj.add(10);
        obj.add(20);
        obj.remove(10);
        boolean param_3 = obj.contains(10);
        param_3 = obj.contains(20);
    }
}

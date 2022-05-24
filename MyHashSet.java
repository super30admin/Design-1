import java.util.Arrays;

public class MyHashSet {
    // array of max size as specified in the problem statement is created
    int[] set;
    int MAX = 10000000;

    // Time complexity is O(n) as we are filling are indices with value -1 and SC is O(n)
    public MyHashSet() {
        set = new int[MAX];
        Arrays.fill(set,-1);
    }
    
    // hash table implemented with the same key and value
    // TC O(1)
    public void add(int key) {
        set[key] = key;
    }
    
    //TC O(1)
    public void remove(int key) {
        set[key] = -1;
    }
    
    //TC O(1)
    public boolean contains(int key) {
        if(key < MAX && set[key] == key){
            return true;
        }
        return false;
    }

    public static void main(String arr[]){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(1);
        hashSet.remove(30);
        System.out.println("Deleted 30 "+hashSet.contains(30));
    }
}
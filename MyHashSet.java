import java.util.*;;
public class MyHashSet {
    private int[] hashSet;

    public MyHashSet() {
        hashSet = new int[1000001];
        Arrays.fill(hashSet , -1);
    }

    public void add(int key) {
        hashSet[key] = key;
    }
    
    public void remove(int key) {
        hashSet[key] = -1;
    }
    
    public boolean contains(int key) {
        return (hashSet[key] != -1);
    }
    
}

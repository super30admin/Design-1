/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class HashSetTester {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();

        obj.add(0);
        obj.add(1000000);

        System.out.println(obj.contains(0));

        obj.remove(0);

        System.out.println(obj.contains(0));

        System.out.println(obj.contains(100));

        System.out.println(obj.contains(1000000));

    }
}

/*
* The implementation below is to design a hashset and to perform operations like add, remove and contains
* the hashset here is a boolean array which returns true if the key exists in the array and false otherwise
* The time complexity for the methods add(), remove(), contains() is O(1)*/
public class Hashset {
    private boolean[] hashset;

    public Hashset() {
        hashset = new boolean[100001];
    }

    public void add(int key) {
        hashset[key] = true;
    }

    public void remove(int key) {
        hashset[key] = false;
    }

    public boolean contains(int key) {
        return hashset[key];
    }

    public static class Main {
        public static void main(String[] args) {
            Hashset hashset = new Hashset();
            hashset.add(1);
            hashset.add(2);

            System.out.println(hashset.contains(1));
            System.out.println(hashset.contains(3));

            hashset.remove(2);
            hashset.add(3);

            System.out.println(hashset.contains(2));
            System.out.println(hashset.contains(3));
        }
    }
}

class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001]; // Assuming the maximum key value is 10^6
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1)); // Output: true
        System.out.println(myHashSet.contains(3)); // Output: false
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2)); // Output: true
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2)); // Output: false

        // Additional test case
        MyHashSet myHashSet2 = new MyHashSet();
        System.out.println(myHashSet2.contains(1)); // Output: false
        myHashSet2.add(1);
        System.out.println(myHashSet2.contains(1)); // Output: true
        myHashSet2.remove(1);
        System.out.println(myHashSet2.contains(1)); // Output: false
    }

}

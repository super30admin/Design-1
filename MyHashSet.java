public class MyHashSet {
    private boolean[][] arr;

    private static final int BUCKET_1_SIZE=1000;
    private static final int BUCKET_2_SIZE=1000;

    private int hash1(int key){
        return key/BUCKET_1_SIZE;
    }
    private int hash2(int key){
        return key % BUCKET_2_SIZE;
    }

    public MyHashSet() {
        arr = new boolean[BUCKET_1_SIZE][];
    }

    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1] == null)
            arr[hash1] = new boolean[BUCKET_2_SIZE];

        arr[hash1][hash2] = true;


    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        arr[hash1][hash2] = false;

    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(arr[hash1] == null)
            return false;

        return arr[hash1][hash2];
    }

    public static void main(String[] args){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1000);

        System.out.println("hash contains 1: "+ myHashSet.contains(1));
        System.out.println("hash contains 1000: "+ myHashSet.contains(1000));
        myHashSet.remove(1000);
        System.out.println("hash after remove contains 1000: "+ myHashSet.contains(1000));
    }
}
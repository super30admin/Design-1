//Time complexity o(1)
//Space complexity o(n)
class MyHashSet {

    private  boolean[][] arr;
    private int rows;
    private int cols;
    public MyHashSet() {
        this.rows = 1000;
        this.cols = 1000;
        arr = new boolean[rows][];
    }

    public int hashFunction1(int key){
        return  key % this.rows;
    }

    public  int hashFunction2(int key){
        return  key / this.cols;
    }
    
    public void add(int key) {
        int hash1 = hashFunction1(key);
        int hash2 = hashFunction2(key);
        if(arr[hash1] == null){
            if(hash1 == 0){
                arr[hash1] = new boolean[cols + 1];
            }
            else{
                arr[hash1] = new boolean[cols];
            }

        }
        arr[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hashFunction1(key);
        int hash2 = hashFunction2(key);
        if(arr[hash1] == null){
            return;
        }
        else{
            if(arr[hash1][hash2]){
                arr[hash1][hash2] = false;
            }
        }
    }
    
    public boolean contains(int key) {
        int hash1 = hashFunction1(key);
        int hash2 = hashFunction2(key);
        if(arr[hash1] == null){
            return false;
        }
        return  arr[hash1][hash2];
    }

    public static void main(String[] args) {
        MyHashSet m = new MyHashSet();
        m.add(2);
        m.add(1000000); 
        m.remove(2);
        m.contains(2);
    }
}
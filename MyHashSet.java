class MyHashSet {
    private boolean[][] storage;
    private int main;
    private int secondry;

    private int hashkey1(int val){
        return val%main;
    }

    private int hashkey2(int val){
        return val/secondry;
    }

    public MyHashSet() {
        this.main=1000;
        this.secondry=1000;
        storage = new boolean[main][];
    }

    public void add(int key) {
        int a=hashkey1(key);
        int b=hashkey2(key);
        if(storage[a]==null && a==0){
            storage[a] = new boolean[secondry+1];
        }else if(storage[a]==null){
            storage[a] = new boolean[secondry];
        }
        storage[a][b]=true;
    }

    public void remove(int key) {
        int a=hashkey1(key);
        int b=hashkey2(key);
        if(storage[a]==null){
            return;
        }
        storage[a][b]=false;
    }

    public boolean contains(int key) {
        int a=hashkey1(key);
        int b=hashkey2(key);
        if(storage[a]==null){
            return false;
        }
        return storage[a][b];


    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
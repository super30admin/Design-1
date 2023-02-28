class MyHashSet{
    int size = 3;
    int[] arr;
    double capacityFactor = 0.8;
    int count = 0;

    public MyHashSet() {
        arr = new int[size];
    }

    //a hash function place the elements
    public int  hashFunction(int key){
        return key%size;
    }

    //if the hashset reaches 80% capacity, allocate a new array double the size and copy contents of the old one into the new
    public void chainingFunction(int key){
        if(count == (int)(capacityFactor*size) || hashFunction(key)>=size){
            count = 0;
            size*=2;
            int[] oldArr = arr;
            arr = new int[size];
            for(int i = 0; i<oldArr.length; i++){
                arr[i]  = oldArr[i];
            }
        }
    }

    public void collisionResolution(){
        //ToDo: implement a collision resolution function if hashFunction returns the same index for 2 or more keys
    }

    public void add(int key) {
        chainingFunction(key);
        if(contains(key)) return;

        int index = hashFunction(key);
        if(arr[index] == 0){
            arr[index] = key;
        }
        else {
            collisionResolution();
        }
        count++;
    }

    public void remove(int key) {
        int[] newArr = new int[size-1];
        for(int i =0, j=0; i<size; i++){
            if(arr[i]!= key){
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        count --;
    }

    public boolean contains(int key) {
        int index  = hashFunction(key);
        return arr[index] == key;
    }


    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(21);
        myHashSet.add(32);
        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.add(14);
        myHashSet.contains(21);
        myHashSet.contains(33);
        myHashSet.remove(14);
        //10, 21, 32, 0, 14, 5
    }
}
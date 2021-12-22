public class HashSet {

    boolean[][] data;
    int size;
    public HashSet() {
        size = 1000;
        data = new boolean[size][];
    }

    public void add(int key) {
        int initialHashValue =  key % size;
        int secondHashValue =  key / size;
        if(data[initialHashValue] == null){
            if(initialHashValue == 0){
                data[initialHashValue] = new boolean[size+1];
            }
            else{
                data[initialHashValue] = new boolean[size];
            }
        }
        data[initialHashValue][secondHashValue]=true;
    }


    public void remove(int key) {
        int initialHashValue =  key % size;
        int secondHashValue =  key / size;



        if(data[initialHashValue]==null){
            return;
        }
        data[initialHashValue][secondHashValue]=false;
    }
    public boolean contains(int key) {
        int initialHashValue =  key % size;
        int secondHashValue =  key / size;
        if(data[initialHashValue]==null){
            return false;
        }
        return data[initialHashValue][secondHashValue];

    }
}

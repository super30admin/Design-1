
class MyHashSet {

    boolean[][] storage;
    int primary;
    int secondary;

    public MyHashSet() {
        this.primary=1001;
        this.secondary=1001;
        this.storage = new boolean[primary][];
    }
    

    private int primaryhash(int key){
        return key / primary;

    }

    private int secondaryhash(int key){
        return key%secondary;
    }

    public void add(int key) {
        int primaryindex= primaryhash(key);

        if(storage[primaryindex]==null){
            storage[primaryindex] = new boolean[secondary];
        }

        int secondaryindex = secondaryhash(key);

        storage[primaryindex][secondaryindex] = true;

        
    }
    
    public void remove(int key) {
        int primaryindex=primaryhash(key);
        if(storage[primaryindex]==null){
            return;
        }

        int secondaryindex=secondaryhash(key);

        storage[primaryindex][secondaryindex]=false;
        
    }
    
    public boolean contains(int key) {
        int primaryindex=primaryhash(key);
        if(storage[primaryindex]==null){
            return false;
        }

        int secondaryindex=secondaryhash(key);

       return storage[primaryindex][secondaryindex];
        
    }
}



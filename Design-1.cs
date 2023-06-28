public class MyHashSet {
    bool [][] storage;
    int primarylength;
    int secondarylength;
    public MyHashSet() {
        primarylength=1000;
        secondarylength=1000;
        storage= new bool [this.primarylength][];
    }
    
    public void Add(int key) {
        int primaryIndex= key%1000;
        int secondaryIndex= key/1000;
        if(this.storage[primaryIndex]==null){
            if(primaryIndex==0){
                this.storage[primaryIndex]= new bool[this.secondarylength+1];                
            }
            else
                this.storage[primaryIndex]= new bool [this.secondarylength];
        }

        this.storage[primaryIndex][secondaryIndex]= true;

    }
    
    public void Remove(int key) {
        int primaryIndex= key%1000;
        int secondaryIndex= key/1000;
        if(storage[primaryIndex]==null) return;
        else{
            storage[primaryIndex][secondaryIndex]= false;
        }
    }
    
    public bool Contains(int key) {
        int primaryIndex= key%1000;
        int secondaryIndex= key/1000;
        if(this.storage[primaryIndex]==null) return false;
        else{
            return this.storage[primaryIndex][secondaryIndex];
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */
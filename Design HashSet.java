class MyHashSet {

    boolean[] hashSetDef;
    public MyHashSet() {
        hashSetDef = new boolean[1000001];
    }
    
    public void add(int key) {
        hashSetDef[key]=true;
    }
    
    public void remove(int key) {
        hashSetDef[key]=false;
    }
    
    public boolean contains(int key) {
        if(hashSetDef[key]==true){
            return true;
        }else{
            return false;
        }
    }

}
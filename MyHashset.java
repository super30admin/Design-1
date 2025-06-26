class MyHashSet {
        int pbuckets;
        int sbuckets;
        boolean[][] sto;
    public MyHashSet() {
        this.pbuckets=1000;
        this.sbuckets=1000;
        this.sto=new boolean[pbuckets][];
    }
    private int getp(int key){
        return key%pbuckets;
    }
    private int gets(int key){
        return key/sbuckets;
    }
    
    public void add(int key) {
        int p=getp(key);
        int s=gets(key);
        if(sto[p]==null){
            if(p==0){
                sto[p]=new boolean[1001];
            }
            else{
                sto[p]=new boolean[1000];
            }
            
        }
        
        sto[p][s]=true;
    }
    
    public void remove(int key) {
        int p=getp(key);
        if(sto[p]==null){
            return;
        }
        int s=gets(key);
        sto[p][s]=false;
    }
    
    public boolean contains(int key) {
        int p=getp(key);
        if(sto[p]==null){
            return false;
        }
        int s=gets(key);
        return sto[p][s];
    }
}

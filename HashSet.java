class MyHashSet {
Set <Integer> s;
    public MyHashSet() {
         s=new HashSet<>();
    }
    
    public void add(int key) {
        s.add(key);
        return ;
    }
    
    public void remove(int key) {
        s.remove(key);
        return ;
    }
    
    public boolean contains(int key) {
        if(s.contains(key)) return true;
        return false;
    }
}


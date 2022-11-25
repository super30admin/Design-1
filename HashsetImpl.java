//time complexity - O(1)
//space complexity - O(N), N is Math.pow(10, 6)+1
//able to execute in leetcode
class MyHashSet {
    int size = (int)Math.pow(10, 6)+1;
    boolean[] hs = new boolean[size];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        hs[key] = true;
    }
    
    public void remove(int key) {
        hs[key]=false;
    }
    
    public boolean contains(int key) {
        return hs[key];
    }
}

//Below is the approach that learnt from class
//time complexity - O(1)
//space complexity - O(N), N is Math.pow(10, 6)+1
//able to execute in leetcode
class MyHashSet {
    boolean[][] hs = new boolean[1000][];
    public MyHashSet() {
        
    }
    public int gethashkeyOne(int key){
        return key%1000;
    }
    public int gethashkeyTwo(int key){
        return key/1000;
    }
    public void add(int key) {
        int one = gethashkeyOne(key);
        if(hs[one]==null){
            if(one==0){
                hs[one]=new boolean[1001];
            }
            else
            hs[one]=new boolean[1000];
        }
        int two = gethashkeyTwo(key);
        hs[one][two]= true;
    }
    
    public void remove(int key) {
        int one = gethashkeyOne(key);

        int two = gethashkeyTwo(key);
        if(hs[one]!=null)
            hs[one][two]= false;
    }
    
    public boolean contains(int key) {
        int one = gethashkeyOne(key);

        int two = gethashkeyTwo(key);
        if(hs[one]==null)
        return false;
        return hs[one][two];
    }
}

// TC=O(1)
//SC=O(10^6)

class MyHashSet {
    
    private boolean [][] vivek;  //boolean becoz we r just interested in whether it is present or not. Boolean takes less memory. If we want to retrieve the element correspondiing to the key then we can't use boolean
    private static int a=1000;
    private static int b=1000;

    public MyHashSet() {
        vivek= new boolean [a][];
    }
    
    private int hashF_1(int key){
        return key%a;
    }
    
    private int hashF_2(int key){
        return key/b;
    }
    
    public void add(int key) {
        if(!contains(key)){ // if key is not present
            int H1=hashF_1(key);
            if(vivek[H1]==null){ // checking whether array is present at 1st hash index
                if(H1==0){  // to handle edge case of 10^6 we r creating an array of extra size at index 0
                    vivek[H1]=new boolean[a+1];
                }
                else{
                    vivek[H1]= new boolean[a];
                }
            }
            int H2=hashF_2(key);
            vivek[H1][H2]=true;
        }
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            int H1= hashF_1(key);
            int H2= hashF_2(key);
            vivek[H1][H2]=false;
        }
    }
    
    public boolean contains(int key) {
        int H1= hashF_1(key);
        if(vivek [H1]==null){  // no entry corresponding to hash1 index
            return false;
        }
        int H2= hashF_2(key);
        return vivek[H1][H2];  //storiing true
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
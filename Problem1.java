//Got executed in leetcode
// The idea i had was to make a array of array and store values there; changed that to boolean for 2 reasons firstly as the input is int in java default is 0 so it was hard to diffrenciate and bool takes less space; than applied 2 hash function 1 for each array and placed at its place
//Time complexities add O(1) ; remove (1) ; contains O(1)



class MyHashSet {

    boolean[][] arr;

    public MyHashSet() {
        this.arr = new boolean[1000][];
        
    }
    public int hash1(int key){
        return key % 1000;
    }
    public int hash2(int key){
        return key / 1000;
    }
    
    public void add(int key) {
        int result = hash1(key);
        if(arr[result]==null){
            if(result==0){
                arr[result]= new boolean[1001];
                int result2 = hash2(key);
                arr[result][result2] = true; 

            }
            else{
                arr[result]= new boolean[1000];
                int result2 = hash2(key);
                arr[result][result2] = true;
            }


        }
        else{
            int result2 = hash2(key);
            arr[result][result2] = true;
        }
        
    }
    
    public void remove(int key) {
        int result = hash1(key);
         System.out.println("first" + key);
        if(arr[result]==null){
            return;
        }
        else{
            int result2 = hash2(key);
            System.out.println("else" + key);
            arr[result][result2] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int result = hash1(key);
         System.out.println("contains1" + key);
        if(arr[result]==null){
            return false;
        }
        else{
            int result2 = hash2(key);
            if(arr[result][result2] == true){
                 System.out.println("if" + key);
                return true;
            }
            else{
                 System.out.println("bob" + key);
                return false;
            }
        }        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
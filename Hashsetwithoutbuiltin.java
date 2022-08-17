/*
Time Complexity
O(1) add remove contains
Space Complexity
O(n) add remove//not sure exactly it is my doubt
O(1) contains
*/
class MyHashSet {
int bucket=1000;
int bucket1=1000;
boolean a[][]=new boolean[bucket][];
    public MyHashSet() {
    	
    }
    public int hash1(int key) {
    	return key%bucket;
    }
    public int hash2(int key) {
    	if(key%bucket==0) {
    		return key/(bucket+1);//as 0th index contain one extra item if not collision occurs value will be replaced
    	}
    	return key/bucket;
    }
    public void add(int key) {
        int hash11=hash1(key);
        int hash22=hash2(key);
        if(a[hash11]==null) {
        	if(hash11==0) {
        		a[hash11]=new boolean[(bucket+1)];
        	}
        	else {
        	a[hash11]=new boolean[bucket];	
        	}
        }
        a[hash11][hash22]=true;
    }
    
    public void remove(int key) {
    	int hash11=hash1(key);
    	int hash22=hash2(key);
    	if(a[hash11]==null) {
    		return;
    	}
    	else {
    	a[hash11][hash22]= false;
    	}	
    }
    
    public boolean contains(int key) {
    	int hash11=hash1(key);
    	int hash22=hash2(key);
    	if(a[hash11]==null) {
    		return false;
    	}
    	return a[hash11][hash22];
        }
    
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
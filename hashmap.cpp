
// Time Complexity :  put O(1) , get O(1), remove O(1)
// Space Complexity : worstcase O(n), where n is total elements
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE


// Your code here along with comments explaining your approach


class MyHashMap {
    
    // will store pointers to arrays that will be created down the line.
    int * primaryarr[1000] = { nullptr }; // sqrt of 10^6
    
public:
    MyHashMap() {
        
    }
    
    int hashprimary( int key ){
        return( key % 1000 );
    }
    
    int hashsec( int key ){
        return( key / 1000 );
    }
    
    void put(int key, int value) {
        int prindex = hashprimary( key );
        if( primaryarr[prindex] == nullptr ){
            if( prindex == 0 ){
               primaryarr[prindex] = new int[1001]; // to handle value 10^6
               memset(primaryarr[prindex], -1, sizeof( int )* 1001);
            } else {
               primaryarr[prindex] = new int[1000];
               memset(primaryarr[prindex], -1, sizeof( int )* 1000 );
            }
            
        }
        int secindex = hashsec( key );
        primaryarr[prindex][secindex] = value;
    }
    int get(int key) {
        int prindex = hashprimary( key );
        if( primaryarr[prindex] == nullptr ){ 
           return -1;
        }
        int secindex = hashsec( key );
        return primaryarr[prindex][secindex]; // will return -1 by default as memset to that
    }
    
    void remove(int key) {
        int prindex = hashprimary( key );
        if( primaryarr[prindex] == nullptr ){ 
           return;
        }
        int secindex = hashsec( key );
        primaryarr[prindex][secindex] = -1;
        
        // check if all are -1 for secondary array then remove the whole array to save up space
        //TO DO
        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

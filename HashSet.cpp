class MyHashSet {
    // Time Complexity : O(1)
    // Space Complexity : O(n)
public:
int arr[1000001];
    MyHashSet() {
    }
    
    void add(int key) {
        arr[key] = key;
    }
    
    void remove(int key) {
       arr[key] = -1; 
    }
    
    bool contains(int key) {
        if(arr[key] == key){
            return true;
        }
        else return false;
    }
}
// Approach 1
// Time Complexity - put(), get(), remove() are O(1) since I am accessing the value in a vector at a particular index which is O(1).
// Space COmplexity - This approach is not very memory efficient.
// Problems Faced - No!
// It runs on leetcode.

class MyHashMap {
    vector<int> v;
public:
    MyHashMap() {
        v.resize(1000001, -1);
    }
    
    void put(int key, int value) {
        v[key] = value;
    }
    
    int get(int key) {
        return v[key];
    }
    
    void remove(int key) {
        v[key] = -1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
*
// Approach 2
// Time Complexity - put(), get(), remove() is O(1) on average. I say average because sometimes I also have to traverse through the whole linked list which is O(n) but that is not the case alsways
// Space COmplexity - O(n) - Since it depends on the number of elements being put into the HashMap.
// Problems faced - I had to do this using an array. Could not do it with a vector(Kindly help here!)
// It runs on leetcode.

class MyHashMap {
    
        class Node{
        public:
        int key;
        int val;
        Node* next = NULL;
        
        Node(int k, int v){
            key = k;
            val = v;
            next = nullptr;
        }
    };
   //vector<Node> vec;
   //int size = 10000;
   //vector<>
   Node* vec[10000] = {NULL};
    
   int hashFnc(int key){
        return key%10000;
    }
    
    Node* find(Node* head, int targetKey){
        Node* prev = head;
        Node* curr = head->next;
        while(curr && curr->key != targetKey){
            prev = prev->next;
            curr = curr->next;
        }
        return prev;
    }
    
public:
    MyHashMap() {
        // for(int i = 0; i < 10000; i++){
        //     vec[i] = new Node(-1, -1);
        // }
        //vec.resize(10000);
    }
    
    void put(int key, int value) {
        int index = hashFnc(key);
        if(vec[index] == NULL)
            vec[index] = new Node(-1, -1);
        Node* node = find(vec[index], key);
        
        if(node->next == NULL)
            node->next = new Node(key, value);
        else
            node->next->val = value;
    }
    
    int get(int key) {
        int index = hashFnc(key);
        if(vec[index] == NULL)
            return -1;
        Node* node = find(vec[index], key);
        
        if(node->next == NULL)
            return -1;
        else
            return node->next->val;
    }
    
    void remove(int key) {
        int index = hashFnc(key);
        
        if(vec[index] == NULL)
            return;
        
        Node* node = find(vec[index], key);
        if(node->next == NULL)
            return;
        else{
            node->next = node->next->next;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

//Collision handeling - Separate chain method

// Time Complexity: O(N/K) where N is number of possible keys K is predefined buckets.
// Space Complexity: O(K+M) where M is the unique keys and K is predefined buckets.
// Run in Leetcode: Yes
// Problems: OOPS concept

class Node { 
public: 
    int key, value; 
    Node* next; 
    
}; 
Node* newNode(int key, int value){
        Node *newNode = new Node();
        newNode->key = key;
        newNode->value = value;
        newNode->next = NULL;
        return newNode;
    }

class MyHashMap {
public:
    /** Initialize your data structure here. */
    Node* head[10000];
    
    MyHashMap() {
        for(int i=0;i<10000;i++){
            head[i] = NULL;
        }
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        int index = key%(sizeof(head)/sizeof(head[0]));
        if(head[index]==NULL){
            head[index] = newNode(key,value);
            return;
        }
        else{
            Node* current = head[index];
            if(current->key==key){
                current->value = value;
                return;
            }
            while(current->next!=NULL){
                if(current->next->key == key){
                    current->next->value = value;
                    return;
                }
                current = current->next;
            }
            current->next = newNode(key,value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int index = key%(sizeof(head)/sizeof(head[0]));
        if(head[index]==NULL){
            return -1;
        }
        else{
            Node *current = head[index];
            
            while(current!=NULL){
                if(current->key == key){
                    return current->value;
                }
                current = current->next;
            }
        }
       
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int index = key%(sizeof(head)/sizeof(head[0]));
        if(head[index]!=NULL){
            Node* current = head[index], *prev = head[index];
            if(current->key==key){
                head[index] = current->next;
            }
            while(current!=NULL){
                if(current->key == key){
                    prev->next = current->next;
                }
                prev = current;
                current = current->next;
            }
        }
        else{
            return;
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

class MyHashMap {
public:
    /** Initialize your data structure here. */
 
    class Node{
     public:
        
        int key;
        int value;
        Node *next = NULL;
        Node(int x,int y){
            key = x;
            value =y;
            // next= NULL;
        }
       
    };
    
    
        Node **buckets =new Node*[1000];
    
        MyHashMap() {
    
        for(int i = 0; i < 1000; ++i) {
    
            buckets[i] = NULL;
        }
    
    
         }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        // int bucket_size = sizeof(buckets)/ sizeof(buckets[0]);
        // int bucket_size = sizeof(buckets);
        int bucket_size =1000;
        int hashindex= key % bucket_size;
        if( buckets[hashindex] == NULL){
            Node* curr = new Node( key, value );
            buckets[hashindex] = curr;
            return;
        }
        else{
           
            Node* head = buckets[hashindex];
            if(head->key == key){
                head->value = value;
                return;
            }
            else{
                Node *temp =head;
                while (temp->next != NULL){
                    if(temp->key == key){
                        temp->value = value;
                        return;
                    }
                    temp = temp->next;
                }
                
                temp->next = new Node(key, value);
                
            }
            
        }
                
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        // int bucket_size = sizeof(buckets)/ sizeof(buckets[0]);
        int bucket_size =1000;
        int hashindex= key % bucket_size;
         if( buckets[hashindex] == NULL){
            return -1;
         }
         Node* temp = buckets[hashindex];
        while (temp != NULL){
             if(temp->key == key){
                 return temp->value;
            }
            
            temp = temp->next;
         
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        // int bucket_size = sizeof(buckets)/ sizeof(buckets[0]);
        int bucket_size =1000;
        int hashindex= key % bucket_size;
         if( buckets[hashindex] == NULL){
            return;
         }
        Node* head = buckets[hashindex];
            if(head->key == key){
                // head = head->next;
                buckets[hashindex] = buckets[hashindex]->next;
                return;
            }
        
            Node* curr = buckets[hashindex];
            Node* prev = buckets[hashindex];
            while (curr != NULL){
             if(curr->key == key){
                prev->next = curr->next;
                 return;
            }
            prev= curr;
            curr= curr->next;
            
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
// Time Complexity : O(1), in worst case, we traverse max 100 nodes which is a constant.
// Space Complexity : O(1), space allocated is fixed and it is allocated on demand basis.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
#include<iostream>

using namespace std;

class MyHashMap {
public:
    class Node{
      public:
        int key;
        int value;
        Node *next = NULL;

        Node(int key, int value){
            this->key = key;
            this->value = value;
      }
    };
    
    /*primary array, whose indexes to which key values hashes to*/
    /* this array element points to the LL, which holds nodes*/
    Node *hashArr[10000] = {NULL};
    
    
    /** Initialize your data structure here. */
    MyHashMap() {
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        int idx = key%10000;
        Node *node = new Node(key,value);
        Node *curr = hashArr[idx];
        if(curr == NULL){
            hashArr[idx] = node;
        } else {
            Node *prev;
            while(curr!=NULL){
                if(curr->key == key){
                    curr->value = value;
                    delete(node);
                    return;
                }
                prev = curr;
                curr = curr->next;
            }
            prev->next = node;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int idx = key%10000;
        if(hashArr[idx] != NULL){
            Node *curr = hashArr[idx];
            while(curr!=NULL){
                if(curr->key == key){
                    return curr->value;
                }
                curr = curr->next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int idx = key%10000;
        if(hashArr[idx] == NULL){
            return;
        }
        Node *curr = hashArr[idx];
        if(curr->key == key){
            hashArr[idx] = curr->next;
            delete(curr);
        } else {
            Node *prev = curr;
            curr = curr->next;
            while(curr!=NULL){
                if(curr->key == key){
                    prev->next = curr->next;
                    delete(curr);
                    break;
                }
                prev = curr;
                curr = curr->next;
            }
        }
    }
};

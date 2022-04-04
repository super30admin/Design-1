
// Time Complexity                                  : PUT    - O(1)
//                                                    GET    - O(1)
//                                                    REMOVE - O(1)
// 
// Space Complexity                                 : O(3*N) = O(N) - storing key, value and next for each value.
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : No.

#include<bits/stdc++.h>
using namespace std;



class Node {
public: 
    int key, value;
    Node *next;
    Node(int key, int value) {
        this->key = key;
        this->value = value;
        this->next = nullptr;
    }
};

#define MAX 10000

class MyHashMap {
    vector<Node*> node;
public:
    MyHashMap() {
        Node *dummy = new Node(-1,-1);
        node.resize(MAX, dummy);
    }
    
    Node* getNode(int key) {
        int pa = key%MAX;
        Node *n = node[pa];
        return n;
    }
    
    Node* find(int key) {
        Node *p = getNode(key);
        Node *c = p->next;
        
        while(c) {
            if(c->key == key) {
                return p;
            }
            c = c->next;
            p = p->next;
        }
        
        return p;
    }
    
    void put(int key, int value) {
        
        Node *p = find(key);
        
        if(p->next) 
            p->next->value = value;
        else
            p->next = new Node(key,value);
    }
    
    int get(int key) {
        
        Node *p = find(key);
        if(p->next == nullptr) 
            return -1;
        else
            return p->next->value;
    }
    
    void remove(int key) {
        
        Node *p = find(key);
        if(p->next != nullptr) {
            Node *temp = p->next;
            p->next = temp->next;
            temp->next = nullptr;
            delete temp;
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
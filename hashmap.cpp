#include <iostream>
#include <vector>

using namespace std;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
public:
    class Node{
      public:
        int key;
        int val;
        Node* next;
        
        Node(int p_key, int p_val)
        {
            key = p_key;
            val = p_val;
            next = nullptr;
        }
    };
    
    int primarySize = 10000;
    vector<Node *> nodes;
    MyHashMap() {
        nodes.resize(primarySize);
    }
    
    int getHash(int key)
    {
        return key % primarySize;
    }
    
    Node* findKeyInLinkedList(Node* node, int key)
    {
        Node *prev = node;
        Node *current = prev->next;
        
        while(current != nullptr && current->key != key)
        {
            prev = current;
            current = current->next;
        }
        
        return prev;
    }

    // Time Complexity : O(n)
    // Space Complexity :  O(1) 
    void put(int key, int value) {
        int primIndex = getHash(key);
        if(nodes[primIndex] == NULL)
        {
            nodes[primIndex] = new Node(-1 , -1);
        }
        Node *prev = findKeyInLinkedList(nodes[primIndex], key);
        
        if(prev->next == nullptr)
        {
            prev->next = new Node(key, value);
        }
        
        prev->next->val = value;
    }
    
    // Time Complexity : O(n)
    // Space Complexity :  O(1) 
    int get(int key) {
        int primIndex = getHash(key);
        if(nodes[primIndex] == NULL)
        {
            return -1;
        }
        
        Node *prev = findKeyInLinkedList(nodes[primIndex], key);
        if(prev->next == nullptr)
        {
            return -1;
        }
        
        return prev->next->val;
    }
    
    // Time Complexity : O(n)
    // Space Complexity :  O(1) 
    void remove(int key) {
        int primIndex = getHash(key);
        if(nodes[primIndex] == NULL)
        {
            return;
        }
        
        Node *prev = findKeyInLinkedList(nodes[primIndex], key);
        if(prev->next == nullptr)
        {
            return;
        }
        
        Node *temp = prev->next;
        prev->next = prev->next->next;
        
        delete temp;
    }
};
// Time Complexity : O(1)
// Space Complexity : O(1n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't find a C++ built-in function to generate hashcode as in Java

#include <iostream>
using namespace std;

class MyHashMap{
    class Node {
     public:
        int key;
        int value;
        Node* next;

        Node(int key, int value) {
            this->key = key;
            this->value = value;
            this->next = NULL;
        }
    };
//Node* hashMap[10000]; -- comment line 38 
Node** hashMap; 
int size;

int getIndex(int key) {
    return key % size;
}

Node* find(Node* head, int key) {
    Node* prev = NULL;
    Node* curr = head;
    while (curr != NULL && curr->key != key){
        prev = curr;  // temp = curr; curr = curr.next; prev = temp;
        curr = curr->next;
    }
    return prev;
}

public:
MyHashMap(){
    size = 10000;
    hashMap = new Node*[size];
    for (int i=0; i<size; i++) 
        hashMap[i] = NULL;
}
 
void put(int key, int value){
    int index = getIndex(key);
    if(hashMap[index] == NULL)
        hashMap[index] = new Node(-1,-1);
    
    Node* ptr = find(hashMap[index], key);

    if(ptr->next == NULL) {
        ptr->next = new Node(key,value);
    }
    else {
        ptr->next->value = value;
    }

}

int get(int key) {
    int index = getIndex(key);
    if (hashMap[index] == NULL)
        return -1;

    Node* ptr = find(hashMap[index], key);
    if (ptr->next == NULL)
        return -1;
    else
        return ptr->next->value;
}

void remove(int key) {
    int index = getIndex(key);
    if (hashMap[index] == NULL)
        return;
    
    Node* ptr = find(hashMap[index], key);
    if (ptr->next == NULL)
        return;
    else 
        ptr->next = ptr->next->next;
}
};

int main() 
{
    MyHashMap hm;
    hm.put(1,1);
    hm.put(2,2);
    cout << hm.get(1) << endl; //return 1
    cout << hm.get(3) << endl; //return -1
    hm.put(2,1);
    cout << hm.get(2) << endl; //return 1
    hm.remove(2);
    cout << hm.get(2) << endl; //return -1
    return 0;
}
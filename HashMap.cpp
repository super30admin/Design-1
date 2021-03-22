#include <bits/stdc++.h>
#define BUCKETS 10000

using namespace std;


class MyHashMap {
    
private:
    class Node {
         
    public:
        int key, value;
        Node *next;

        Node() : key(-1), value(-1), next(nullptr) {}
        Node(int key, int value) : key(key),
                                   value(value),
                                   next (nullptr) {}
    } *nodes;

public:
    /* Create buckets here. */
    MyHashMap()
    {
        nodes = new Node[BUCKETS] ();
    }

    /* Time complexity : O(1) */
    int index(int key)
    {
        return key % BUCKETS;
    }
    
    /* Time complexity : O(m) - m being number of colliosions
     * for a key. 
     */
    Node * find(Node *head, int key)
    {
        Node *cur = head, *prev = head;
        while ((cur != nullptr) && (cur->key != key)) {
            prev = cur;
            cur = cur->next;
        }
        
        return prev;
    }

    /* Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    void put(int key, int value)
    {
        int idx = index(key);
        if (nullptr == nodes[idx].next) {
            nodes[idx].next = new Node(key, value);
            return;
        }
        
        Node *prev = find(&nodes[idx], key);
        if (nullptr == prev->next) {
            prev->next = new Node(key, value);
        } else {
            prev->next->value = value;
        }
    }
    
    /* Returns the value to which the specified key is mapped, 
     * or -1 if this map contains no mapping for the key.
     * Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    int get(int key)
    {
        int idx = index(key);
        if (nullptr == nodes[idx].next) {
            return -1;
        }
        
        Node *prev = find(&nodes[idx], key);
        if (nullptr == prev->next) {
            return -1;
        }
        
        return prev->next->value;
    }
    
    /* Removes the mapping of the specified value key,
     * if this map contains a mapping for the key.
     * Value is assumed to be always non-negative. 
     * Time Complexity can be upto O(n) depending on the collsions
     */
    void remove(int key)
    {
        int idx = index(key);
        if (nullptr == nodes[idx].next) {
            return;
        }
        
        Node *prev = find(&nodes[idx], key);
        if (nullptr == prev->next) {
            return;
        }
        
        Node *temp = prev->next;
        prev->next = prev->next->next;
        delete temp;
    }
};

int main()
{
    MyHashMap m;

    m.remove(3);

    m.put(5,5);
    m.put(3,2);
    cout << "3 is mapped to " << m.get(3) << endl;
    
    if (m.get(8) == -1) {
        cout << "You don't undertstand how HashMap works dumbass! (<:" << endl;
    } else {
        cout << "Hmm! Then you don't know how to implement HashMap dumberass!!" << endl;
    }

    m.remove(5);
    m.remove(3);

    return 0;
}

//Time complexity - Amortized O(length of linked list)
//Space complexity - O(n)

//30 out of 36 cases passed on leetcode.

//Problems faced - Insted of using the dummy node like sir suggested, I decided to not use it in my code but this caused code
//to get very complicated. Using dummy node will have made a lot of things easier.

#include <iostream>
#include<vector>

using namespace std;

class MyHashMap {
public:
    class Node{
        public: 
        int key;
        int value;
        Node* next;
    };

    vector<Node*> primaryArray;

    MyHashMap() {
        primaryArray.resize(10000,NULL);
    }

    int ReturnPrimaryHashedIndex(int key){
        return key%10000;
    }
    
    void put(int key, int value) {
        int primaryArrayIndex=ReturnPrimaryHashedIndex(key);

        if(primaryArray[primaryArrayIndex]==NULL)
        {
            Node* newNode=new Node();
            primaryArray[primaryArrayIndex] = newNode;

            newNode->next=NULL;
            newNode->key=key;
            newNode->value=value;
        }
        else
        {
            Node* currentPointer=primaryArray[primaryArrayIndex];
            while(currentPointer->next!=NULL)
            {
                if(currentPointer->key==key)
                {
                    currentPointer->value=value;
                    return;
                }
                currentPointer=currentPointer->next;
            }

            if(currentPointer->key==key)
            {
                currentPointer->value=value;
                return;
            }
            Node* newNode=new Node();
            Node* temp=currentPointer->next;
            currentPointer->next=newNode;
            newNode->key=key;
            newNode->value=value;
            newNode->next=temp;
        }

    }
    
    int get(int key) {
        int primaryArrayIndex=ReturnPrimaryHashedIndex(key);
        if(primaryArray[primaryArrayIndex]==NULL)
        {
            return -1;
        }
        Node* currentPointer=primaryArray[primaryArrayIndex];

        while(currentPointer->next!=NULL)
        {
            if(currentPointer->key==key)
            {
                return currentPointer->value;
            }
            currentPointer=currentPointer->next;
        }
        if(currentPointer->key==key)
        {
            return currentPointer->value;
        }
        return -1;
    }
    
    void remove(int key) {
        int primaryArrayIndex=ReturnPrimaryHashedIndex(key);
        if(primaryArray[primaryArrayIndex]==NULL)
        {
            return;
        }
        Node* currentPointer=primaryArray[primaryArrayIndex];

        if(currentPointer->key==key)
        {
            primaryArray[primaryArrayIndex] = NULL;
            return;
        }
        Node* previousPointer=currentPointer;
        currentPointer=currentPointer->next;
        if(currentPointer==NULL)
        {
            return;
        }
        while(currentPointer->next!=NULL)
        {
            if(currentPointer->key==key)
            {
                previousPointer->next=currentPointer->next;
            }
            previousPointer=previousPointer->next;
            currentPointer=currentPointer->next;
        }
        if(currentPointer->key==key)
        {
            previousPointer->next=currentPointer->next;
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
// Time Complexity : O(1) for put, get and remove. O(n) for initializing map
// Space Complexity : O(1) no extra space used for any operation (excluding the map array which is not considered)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<iostream>
using namespace std;

class MyHashMap {
    private:
        int map[1000001];
    public:
        MyHashMap(){
            for(int i = 0; i < 1000001; i++)
                map[i] = -1;
        }
    
        void put(int key, int value){
            map[key] = value;
        }

        int get(int key){
            return map[key];
        }

        void remove(int key){
            map[key] = -1;
        }
};

/* Driver Program for testing*/
int main(){
    class MyHashMap *obj = new MyHashMap();
    cout<<"\nInserting 5 Pairs";
    obj->put(1, 10);
    obj->put(2, 20);
    obj->put(4, 40);
    obj->put(7, 70);
    obj->put(9, 90);
    cout<<"\nFor key 4 value is "<<obj->get(4);
    cout<<"\nFor key 6 value is "<<obj->get(6);
    cout<<"\nFor key 1 value is "<<obj->get(1);
    cout<<"\nRemoving at key 4";
    obj->remove(4);
    cout<<"\nFor key 4 updated value is now "<<obj->get(4);
    return 0;
}
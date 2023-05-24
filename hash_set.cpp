#include<iostream>
#include<vector>
using namespace std;

class MyHashSet
{
    private:

        int buckets{};
        int inner_buckets{};
        vector<vector<bool>> storage;

        int prim_arr_id(int val)
        {
            return val%buckets;
        }

        int sec_arr_id(int val)
        {
            return val/inner_buckets;
        }

    public :

        MyHashSet()
        {
            buckets = 1000;
            inner_buckets = 1000;
            storage.resize(buckets);
        }

        void add(int key)
        {
            int a {prim_arr_id(key)};
            int b {sec_arr_id(key)};

            if(storage[a].empty())
            {
                if(a == 0)
                {
                    storage[a] = vector<bool>(inner_buckets+1);
                }
                storage[a] = vector<bool>(inner_buckets);
            }

            storage[a][b] = true;

        }

        void remove(int key)
        {
            int a = prim_arr_id(key);
            if(storage.at(a).empty())
                return;
            int b = sec_arr_id(key);
            storage[a][b] = false; 
        }

        bool contains(int key)
        {
            int a = prim_arr_id(key);
            int b = sec_arr_id(key);

            return (storage.at(a).empty()?false:storage[a][b]);
        }

};

int main(int argc, char const *argv[])
{
    MyHashSet hashSet;

    cout<<boolalpha;

    hashSet.add(1);         
    hashSet.add(2);         
    cout<<hashSet.contains(1)<<endl;    // returns true
    cout<<hashSet.contains(3)<<endl;    // returns false (not found)
    hashSet.add(2);          
    cout<<hashSet.contains(2)<<endl;    // returns true
    hashSet.remove(2);          
    cout<<hashSet.contains(2)<<endl;    // returns false (already removed)

    return 0;
}

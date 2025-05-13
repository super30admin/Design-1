#include <bits/stdc++.h>
using namespace std;
class MyHashSet {
public:
    vector<bool>hash;
    MyHashSet() {
        hash.resize(1000001,false);
    }
    
    void add(int key) {
        hash[key]=true;
    }
    
    void remove(int key) {
        hash[key]=false;
    }
    
    bool contains(int key) {
        return(hash[key]);
        
    }
};
int main() {
    MyHashSet set;
    set.add(1);
    set.add(2);
    cout << set.contains(1) << endl; 
    cout << set.contains(3) << endl; 
    set.add(2);
    cout << set.contains(2) << endl; 
    set.remove(2);
    cout << set.contains(2) << endl; 
    return 0;
}


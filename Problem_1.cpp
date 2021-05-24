class MyHashMap {
vector<int> base;
public:
    MyHashMap() {}
    
    void put(int key, int value) {
        if (key >= base.size()) {
            base.resize(key+1, -1);
            base[key] = value;
        }
        else
            base[key] = value;
    }
    
    int get(int key) {
        if (key < base.size() && base[key] != -1)
            return base[key];
        return -1;
    }
    
    void remove(int key) {
        if (key < base.size())
            base[key] = -1;
    }
};

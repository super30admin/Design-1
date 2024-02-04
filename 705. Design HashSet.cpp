/*
Time Complexity: O(1)
Space Complexity: O(n) (precisely, 7*n, because each number can have max 7 digits)

Use Trie to store the set
*/
class MyHashSet {
public:
    struct Trie{
      struct node{
        int leaf = 0;
        vector<node*> child;

        node(){
          child = vector<node*>(10,nullptr);
        }
      };

      node* r;
      Trie(){
        r = new node();
      }

      void insert(node* r, int key){
        if(key==0){
          r->leaf = 1;
          return;
        }

        int pos = key%10;
        if(r->child[pos]==nullptr)  r->child[pos] = new node();
        insert(r->child[pos], key/10);
      }

      void remove(node* r, int key){
        if(r==nullptr)  return;
        if(key==0){
          r->leaf = 0;
          return;
        }

        int pos = key%10;
        remove(r->child[pos], key/10);
      }

      bool query(node* r, int key){
        if(r==nullptr)  return false;
        if(key==0){
          return r->leaf;
        }

        int pos = key%10;
        return query(r->child[pos], key/10);
      }
    }t;

    MyHashSet() {
       t = Trie(); 
    }
    
    void add(int key) {
        t.insert(t.r, key);
    }
    
    void remove(int key) {
        t.remove(t.r, key);
    }
    
    bool contains(int key) {
        return t.query(t.r, key);
    }
};


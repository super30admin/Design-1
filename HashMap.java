class MyHashMap {
    
    // top store the list of values when there's a collision
    class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            this.next = null;
        }
    }
    

    int max; // max size and also works as hash key
    double up_capacity; // check to double the capacity
    double down_capacity;
    int count; // to track count and return it in constant time
    Node[] hashArray;


    public MyHashMap() {
        this.count = 0;
        this.max = 11;
        this.up_capacity = 0.8;
        this.down_capacity = 0.2;
        this.hashArray = new Node[this.max];
    }
    
    // average case time complexity (1)
    public void addNode(int key){
        int hash_value = key%this.max;
        Node new_node = new Node(key);
        if(this.hashArray[hash_value] == null){
            this.hashArray[hash_value] = new_node;
        }
        else{
            Node current_chain = this.hashArray[hash_value];
            while(current_chain!=null){
                if(current_chain.key == key){
                    // key already exists
                    return;
                }
                if(current_chain.next == null){
                    break;
                }
                current_chain = current_chain.next;
            }
            current_chain.next = new_node;
        }
        this.count++;
    }
    
    // time complexity O(N). N is the number of elements in the array 
    public void doubleSize(){
        int old_max = this.max;
        this.max = (this.max*2)+1;
        this.count = 0;
        
        Node[] old_hashArray = new Node[old_max];
        System.arraycopy(hashArray, 0, old_hashArray, 0, old_max);
        
        this.hashArray = new Node[this.max];
        
        for(int i=0; i<old_max; i++){
            Node current_chain = old_hashArray[i];
            while(current_chain!=null){
                addNode(current_chain.key);
                current_chain=current_chain.next;
            }
            
        }
    }

    // time complexity O(N). N is the number of elements in the array 
    public void halfSize(){
        int old_max = this.max;
        this.max = (this.max/2)+1;
        this.count = 0;
        
        Node[] old_hashArray = new Node[old_max];
        System.arraycopy(hashArray, 0, old_hashArray, 0, old_max);
        
        this.hashArray = new Node[this.max];
        
        for(int i=0; i<old_max; i++){
            Node current_chain = old_hashArray[i];
            while(current_chain!=null){
                addNode(current_chain.key);
                current_chain=current_chain.next;
            }
            
        }
    }
    
    // average time complexity is constant
    public void put(int key, int value) {
        if((double)(this.count/this.max) > this.up_capacity){
            this.doubleSize();
        }
        
        this.addNode(key);
    }
    
    // find the hash value and directly check that list of numbers to return the value
    public int get(int key) {
        int index = key%this.max;
        Node current_chain = this.hashArray[index];
        while(current_chain!=null){
            if(current_chain.key == key){
                return current_chain.key;
            }
            current_chain=current_chain.next;
        }
        return -1;
    }
    
    // find the hash value and directly check that list of numbers to delete
    public void remove(int key) {
        int index = key%this.max;
        Node current_chain = this.hashArray[index];
        if(current_chain == null){
            return;
        }
        if(current_chain.key == key){
            this.hashArray[index] = current_chain.next;
            return;
        }
        Node pre = null;
        while(current_chain.next!=null){
            pre=current_chain;
            current_chain=current_chain.next;
            if(current_chain.key == key){
                pre.next = current_chain.next;
            }
        }
        // gave bad performance when halved the array
        // if((double)(this.count/this.max) < this.down_capacity){
        //     this.halfSize();
        // }
    }
}

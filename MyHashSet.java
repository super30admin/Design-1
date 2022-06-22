class MyHashSet {
       
    class Node{
        int data;
        Node next;

        public Node (int data) {
            this.data= data;
        }
    }

    private Node[] array;
    private int size;


    public MyHashSet(){
        this.size = 100;
        this.array = new Node[100];
    }

    public void add(int key) {
        int hash = key % this.size;

        if(this.array[hash] == null ){
            this.array[hash] = new Node(key); 
            return;          
        }
        else{
            Node x = this.array[hash];

            while(x!=null && x.data!=key){
                x=x.next;
            }

            if(x!=null){
                return;
            }
            
            Node newNode = new Node(key);
            newNode.next = this.array[hash];
            this.array[hash] = newNode;
        }



    }
    
    public void remove(int key) {
        int hash = key % this.size;

        if(this.array[hash] == null ){
            return;          
        }
        else{
            Node x = this.array[hash];

            if(x.data==key){
                this.array[hash] = x.next;
            }

            while(x.next != null && x.next.data!=key){
                x=x.next;
            }

            if(x.next==null){
                return;
            }

            x.next = x.next.next;
            

        }
    }
    
    public boolean contains(int key) {
        int hash = key % this.size;

        if(this.array[hash] == null ){
            return false;          
        }
        else{
            Node x = this.array[hash];

            if(x.data==key){
                return true;
            }

            while(x!=null && x.data!=key){
                x=x.next;
            }

            return x !=null;
        }
    }
}

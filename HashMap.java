class MyHashMap {

        ListNode[] nodes;

        //Constructor
        public MyHashMap() {
            nodes = new ListNode[10000];
        }

        //Add value into the array
        public void put(int key, int value) {

            //Retrieve the hashed index
            int index = getIndex(key);

            ListNode prev = findElement(index,key);
            //If prev.next is empty, put the (key,value) pair 
            if(prev.next==null)
                prev.next = new ListNode(key,value);
            else
                //If not, replace the value for that index.
                prev.next.value = value;


        }

        //Returns the value at a given key
        public int get(int key) {

            //Retrieve the hashed index
            int index = getIndex(key);

            ListNode prev = findElement(index,key);

            //If it is empty, then no value exists with that particular key
            if(prev.next==null)
                return -1;
            else
                //else return it
                return prev.next.value;

        }

      //Remove an element from the array
        public void remove(int key) {
            //Retrieve the hashed index
            int index = getIndex(key);
            ListNode prev = findElement(index, key);

            //Removing element from a linkedlist
            if(prev.next != null)
                prev.next = prev.next.next;
        }

        //generate the hashed key for the array
        public int getIndex(int key){
            return Integer.hashCode(key)%nodes.length;
        }

        public ListNode findElement(int index,int key){
            //If no value exist at the particular index, create a node with (-1,-1) (key,value) pair , store it in the array and return it.
            if(nodes[index]==null)
                return nodes[index] =  new ListNode(-1,-1);

            //Use this variable to traverse the array
            ListNode prev = nodes[index];

            //index is the hashed value of the key, we will compare the keys and return the value accordingly where the key matches
            while(prev.next!=null && prev.next.key!=key){
                prev = prev.next;
            }
            return prev;

        }


        //This is the LinkedList node

        static class ListNode{

            //key and value means the key-value pair for the nodes of a linked list.
            int key,value;
            ListNode next;

            ListNode(int key,int value){
                this.key = key;
                this.value = value;
            }

        }
}

        {
            this.key = key;
            this.value = value;
        }
    }*/
    
   // public Node[] nodearray = new Node[10000];
​
    /** Initialize your data structure here. */
    public MyHashMap() {
        //data = new LinkedList<(int key,int value)>[capacity];
        hashmap = new LinkedList<HashMapNode>[2070];
        
    }
    
    /** value will always be non-negative. */
    public void Put(int key, int value) {
        
       /* int index = key % nodearray.Length;
        
        if(nodearray[index] == null)
        {
            nodearray[index] = new Node(key,value);
            return;
        }
        else
        {
            Node n = nodearray[index];
            if(n.key == key)
            {
                n.value = value;
                return;
            }
            while(n.Next != null)
            {
                if(n.Next.key == key)
                {
                    n.Next.value = value;
                    return;
                }
                n = n.Next;
            }
            n.Next = new Node(key,value);
        }*/
        
        var index = key % 2070;
        var linkedList  = hashmap[index];
        
        if(linkedList ==null)
        {
            linkedList = new LinkedList<HashMapNode>();
            linkedList.AddFirst(new HashMapNode{key = key,val = value});
            hashmap[index] = linkedList;
        }
        else if(linkedList.Any(x => x.key == key)) {
            var existingListItem = linkedList.First(x => x.key == key);
            existingListItem.val = value;
        }
        else {
            linkedList.AddFirst(new HashMapNode { key = key, val = value });
        } 
        
    }
    

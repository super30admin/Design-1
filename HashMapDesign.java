public class HashMapDesign {
    

    public class ListNode{
        int value;
        int key;
        ListNode next;
        
        public ListNode(int key,int value){
            this.value = value;
            this.key = key;
        }
    }

    private ListNode[] hashMap;

    public HashMapDesign() {
        hashMap = new ListNode[100];
    }
    
    
    public ListNode getElement(int index,int key){
        if(hashMap[index]==null){
            hashMap[index] = new ListNode(-1,-1);
            return hashMap[index];
        }
        else{
            ListNode curr = hashMap[index];
            
            while(curr.next!=null && curr.next.key != key){
                curr = curr.next;
            }
            return curr;
        }
    }

    public void put(int key, int value) {
        int index = key%hashMap.length;
        ListNode prev = getElement(index,key);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }else{
            prev.next.value = value;
        }
    }


    public int get(int key) {
        int index = key%hashMap.length;
        ListNode prev = getElement(index,key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = key%hashMap.length;
        ListNode prev = getElement(index,key);
        if(prev.next == null){
            return;
        }else{
            prev.next = prev.next.next;
        } 
    }
    
    
    public static void main(String args[]){
        System.out.println("Hello");
        
        
        HashMapDesign hashmapObj = new HashMapDesign();
     
        hashmapObj.put(1,10);
        hashmapObj.put(11,12);
        
        System.out.println(hashmapObj.get(11));
        hashmapObj.remove(11);
        System.out.println(hashmapObj.get(11));
}

    
}

/*  Explanation
    Time Complexity for operators : o(1)   
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    The implemntation consists of only LinkedList. It creates DummyLinkedlIst initially and then add next element next to it
    If the hasfunction return and already existing value then  it will create an new linkedlist and add element at the end.
    We need to treverse thru the linkedlist by using find element function for each and every operator in order to traverse from
    the linkedlist.
*/

public class HashMap_Design {
    public static void main(String args[]){
            System.out.println("Hello");
            HashMap_Design hm = new HashMap_Design();
            hm.put(1,10);
            hm.put(11,12);
            System.out.println(hm.get(11));
    }


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

    public HashMap_Design() {
        hashMap = new ListNode[100];
    }
    
    public int hashFunction(int key){
        return key%hashMap.length;
    }
    
    public ListNode findElement(int index,int key){
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
        int index = hashFunction(key);
        ListNode prev = findElement(index,key);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }else{
            prev.next.value = value;
        }
    }


    public int get(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index,key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = hashFunction(key);
        ListNode prev = findElement(index,key);
        if(prev.next == null){
            return;
        }else{
            prev.next = prev.next.next;
        } 
    }
}
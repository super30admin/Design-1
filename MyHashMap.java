class MyHashMap

{

 ListNode[] nodes = new ListNode[10000];



 public int get(int key)

 {

   int index = getIndex(key);

   ListNode prev = findElement(index, key);

   return prev.next == null ? -1 : prev.next.val;

 }

 public void put(int key, int value)

 {

   int index = getIndex(key);

   ListNode prev = findElement(index, key);

   if (prev.next == null)

     prev.next = new ListNode(key, value);

   else

     prev.next.val = value;

 }



 public void remove(int key)

 {

   int index = getIndex(key);

   ListNode prev = findElement(index, key);

   if(prev.next != null)

     prev.next = prev.next.next;

 }



 private int getIndex(int key)

 {

   return Integer.hashCode(key) % nodes.length;

 }



 private ListNode findElement(int index, int key)

 {

   if(nodes[index] == null)

     return nodes[index] = new ListNode(-1, -1);

   ListNode prev = nodes[index];

   while(prev.next != null && prev.next.key != key)

   {

     prev = prev.next;

   }

   return prev;

 }



 private static class ListNode

 {

   int key, val;

   ListNode next;


   ListNode(int key, int val)

   {

     this.key = key;

     this.val = val;

   }

 }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
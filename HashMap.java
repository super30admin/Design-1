//Time complexity: O(1) 

//Space complexity: O(n) - where n is the number of entries in HashMap 


class HashMap

{

 Node[] nodes = new Node[10000];

​
 private static class Node

 {

   int key, val;

   Node next;

​

   Node(int key, int val)

   {

     this.key = key;

     this.val = val;

   }

 }
 
 private int getIndex(int key)

 {  

   return Integer.hashCode(key) % nodes.length;  // To get the hash code

 }
 
 

 
 
 public int get(int key)

 {

   int index = getIndex(key);

   Node prev = findElement(index, key);

	if(prev.next == null) // no next node
	{
		return -1;
	} else {
		
    prev.next.val;
	}
 }

 public void put(int key, int value)

 {

   int index = getIndex(key);

   Node prev = findElement(index, key);

   if (prev.next == null)
   {
     prev.next = new Node(key, value); // create new node if it is not there
   }
   else 
   {
     prev.next.val = value; //update the value
   }
 }

​

 public void remove(int key)

 {

   int index = getIndex(key);

   Node prev = findElement(index, key);

   if(prev.next != null)

     prev.next = prev.next.next;

 }

​
 private Node findElement(int index, int key)

 {

   if(nodes[index] == null)

     return nodes[index] = new Node(-1, -1);

   Node prev = nodes[index];

   while(prev.next != null && prev.next.key != key)

   {

     prev = prev.next;

   }

   return prev;

 }


​
}
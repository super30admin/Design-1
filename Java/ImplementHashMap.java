// Time Complexity : O(N+M) where N is number of nodes and M is unique key value pairs
// Space Complexity : O(K/B) where n is number of keys and k is number of buckets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
/*
Used hashing technique to reduce number of collisions
and LinkedList to hold all the values assigned by hash function
*/
class MyHashMap {
 ListNode[] nodes;

 /** Initialize your data structure here. */
 public MyHashMap() {
  nodes =new ListNode[10000];
 }

 int bucket(int key){
  return key%nodes.length;
 }

 ListNode findPrev(ListNode node, int key){
  ListNode curr = node;
  ListNode prev=null;
  while(curr!=null && curr.key!=key){
   prev=curr;
   curr=curr.next;
  }
  return prev;
 }

 /** value will always be non-negative. */
 public void put(int key, int value) {
  int i = bucket(key);
  if (nodes[i] == null)
   nodes[i] = new ListNode(-1, -1);
  ListNode prev = findPrev(nodes[i], key);
  if(prev.next==null)
   prev.next = new ListNode(key, value);
  else
   prev.next.val = value;
 }

 /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
 public int get(int key) {
  int i = bucket(key);
  if(nodes[i] == null) return -1;
  ListNode prev = findPrev(nodes[i], key);
  if(prev.next==null) return -1;
  return prev.next.val;

 }

 /** Removes the mapping of the specified value key if this map contains a mapping for the key */
 public void remove(int key) {
  int i = bucket(key);
  if(nodes[i] == null) return;
  ListNode prev = findPrev(nodes[i], key);
  if(prev.next==null) return;
  prev.next = prev.next.next;

 }
 class ListNode{
  int key, val;
  ListNode next;
  ListNode(int key,int val){
   this.key = key;
   this.val=val;
  }
 }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 *//
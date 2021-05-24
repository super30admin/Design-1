//Time Complexity : O(1) average and O(n) for worst case for all the methods used
//Space Complexity : O(n), where n is the number of entries
//Did this code successfully run on Leetcode : Yes

class MyHashMap {


    static final int J = 0x7A646E4D;  /** initializing large prime number that helps to index non-negative integers **/


    final ListNode nodes[] = new ListNode[10000]; /** Initialize based on constraints. given*/

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int index = getIndex(key);  /** get the index value */

        /** checking if there are any Listnodes if not initializing key and value to -1,-1 */
        if(nodes[index] == null) {
            nodes[index] = new ListNode(-1,-1);
        }

        /** checking to find previous listNode with key stored */
        ListNode previous = find(nodes[index],key);

        /** Inserting new key value pairs to the listnode */
        if(previous.next == null) {

            previous.next = new ListNode(key, value);
        }
        else {

            /** Updating previous key with the new value */
            previous.next.value = value;

        }


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int index = getIndex(key);

        /** if empty return*/
        if(nodes[index] == null) return -1;

        /** Find the key if present if yes return value or return -1*/
        ListNode node = find(nodes[index],key);

        return node.next == null ? -1 : node.next.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int index = getIndex(key);
        if(nodes[index] == null) return;

        /** Find the key if present if yes return value or return -1*/
        ListNode previous = find(nodes[index],key);

        /** if the key is not present return or remove by pointing to the next Listnode */
        if(previous.next == null) return;
        previous.next = previous.next.next;
    }


    public int getIndex(int key) {

        return Math.abs(key*J % nodes.length); /** return an index value to map integer between 0 and nodes.length */


    }


    ListNode find(ListNode nodes, int key) {
        /** Instantiating Listnode object and initializing previous to null */
        ListNode node = nodes, previous = null;

        /** if node is not empty and key does not match with key stored in the hashtable */
        while(node!=null && node.key != key) {

            previous = node;
            node = node.next;

        }

        return previous;
    }



    /** declaring listnode class and defining constructor within */
    class ListNode {

        int key, value;
        ListNode next;

        ListNode(int key, int value) {

            this.key = key;
            this.value = value;

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
// Time Complexity : Best Case O(1). WorstCase O(n) is when we have huge number of elements in same bucket
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to debug to track pointers.


// Your code here along with comments explaining your approach
class MyHashMap {

    MapNode[] nodes;

    static class MapNode{
        int key, value;
        MapNode next;

        MapNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new MapNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashValue = hashFunc(key);
        if(nodes[hashValue] == null){
            nodes[hashValue] = new MapNode(-1,-1);
            MapNode prevNode = nodes[hashValue];
            prevNode.next = new MapNode(key,value);
        } else {
            MapNode prevNode = nodes[hashValue];
            while(prevNode.next != null){
                if(prevNode.next.key == key){
                    prevNode.next.value = value;
                    return;
                }
                else{
                    prevNode = prevNode.next;
                }
            }
            prevNode.next = new MapNode(key, value);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashValue = hashFunc(key);
        int value = -1;
        MapNode prevNode = nodes[hashValue];
        if(prevNode != null){
            while(prevNode.next != null){
                if(prevNode.next.key == key){
                    value = prevNode.next.value;
                    break;
                }
                prevNode = prevNode.next;
            }
        }
        return value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashValue = hashFunc(key);
        MapNode prevNode = nodes[hashValue];
        if(prevNode != null){
            while(prevNode.next != null){
                if(prevNode.next.key == key){
                    prevNode.next = prevNode.next.next;
                    return;
                }
                prevNode = prevNode.next;
            }
        }
    }

    public int hashFunc(int key){
        return key%10000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
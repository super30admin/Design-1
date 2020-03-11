/*
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : No. I am getting Null Pointer exception
 Any problem you faced while coding this : I am not understanding whether the while loop should have cur!=null or cur.next!=null
*/


class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next
    }
}

class Hashmap {
    Node linkedList;
    Node head;

    public MyHashMap() {
        linkedList = new Node(0, 0);
        head = linkedList;

    }

    public void put(int key, int value) {
        Node cur = head.next;
        while(head!=null){
            if(cur.key == key){
                cur.value = value;
                return;
            } else {
                cur = cur.next;
            }
        }
        Node node = new Node(key, value)
        linkedList.next = node;
    }

    public int get(int key) {
        Node res = getNode(key);
        if(res == null){
            return res.value;
        }
        return -1;
    }

    public Node getNode(int key){
        Node cur = head.next;
        while(head!=null){
            if(cur.key == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(int key) {
        if(head.next != null){
            Node prev = head;
            Node cur = head.next;
            while(cur!=null){
                if(cur.key == key){
                    prev.next = cur.next;
                    return;
                } else {
                    prev = cur;
                    cur = cur.next;
                }

            }
        }
    }
}

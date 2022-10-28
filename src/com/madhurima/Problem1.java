// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

package com.madhurima;

public class Problem1 {
    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(5);
        hs.add(10);
        hs.add(20);
        hs.remove(5);
        System.out.println(hs.contains(10));
    }
}

class MyHashSet {
    Node[] bucketHead = new Node[100];

    class Node{
        int value;
        Node next;
    }

    public MyHashSet() {
    }

    public int myHashCode(int key){
        // int k = (""+key).hashCode();
        // if(k < 0) {
        //     k = k*-1;
        // }
        // return k%1000;
        return key%100;

    }

    //Time O(n) Space O(1)
    public void add(int key) {
        int hash = myHashCode(key);

        if(bucketHead[hash] == null) {
            bucketHead[hash] = new Node();
            bucketHead[hash].value = key;
            bucketHead[hash].next = null;

        } else {
            Node temp = bucketHead[hash];

            if(temp.next == null && temp.value == key) {
                return;
            } else if (temp.next == null && temp.value != key) {
                Node newNode = new Node();
                newNode.value = key;
                newNode.next = null;
                temp.next = newNode;
                return;
            }

            do{
                if(temp.value == key) {
                    return;
                } else {
                    temp = temp.next;
                }


            } while(temp.next != null);

            if(temp.value == key) {
                return;
            }

            Node newNode = new Node();
            newNode.value = key;
            newNode.next = null;
            temp.next = newNode;
        }
    }

    // Time O(n) Space O(1)
    public void remove(int key) {
        int hash = myHashCode(key);
        Node node = bucketHead[hash];
        int found = 0;

        if(node == null){
            System.out.println("Key not found!");
            return;
        }

        if(node.value == key) {
            bucketHead[hash] = node.next;
        } else {
            Node prev = null;
            while (node.next != null) {
                if(node.value == key) {
                    prev.next = node.next;
                    return;
                } else {
                    prev = node;
                    node = node.next;
                }
            }

            if(node.value == key) {
                prev.next = null;
            }
        }


    }

    // time = O(n), space = O(1)
    public boolean contains(int key) {
        int hash = myHashCode(key);

        if(bucketHead[hash] == null) {
            return false;

        } else {
            Node temp = bucketHead[hash];

            if(temp.next == null && temp.value == key) {
                return true;
            } else if (temp.next == null && temp.value != key) {
                return false;
            }

            do{
                if(temp.value == key) {
                    return true;
                } else {
                    temp = temp.next;
                }


            } while(temp.next != null);

            if(temp.value == key) {
                return true;
            }

            return false;
        }
    }


}


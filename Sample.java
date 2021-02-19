Problem MinStack
// Time Complexity : O(n)
// Space Complexity : O(1) if we dont consider input arrar
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no (i coded after attending the class)


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack1;
    int min;
    public MinStack() {
        stack1 = new Stack<Integer>();
        min =Integer.MAX_VALUE;
        stack1.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if(x<=min){
            stack1.push(min);
            stack1.push(x);
            min = x;
        }else{
            stack1.push(x);
        }

    }

    public void pop() {
        if(stack1.peek() == min){
            stack1.pop();
            min = stack1.pop();
        }else{
            stack1.pop();
        }

    }

    public int top() {
        return stack1.peek();

    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


// Time Complexity : Worst case O(n) average case O(Collision list size) Collision list size = Input range / Bucket size ==>==> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : mo getting time limit exceeded.
// Any problem you faced while coding this : yes ,i followed same concept as class ,but coded more convoluted i guess.


// Your code here along with comments explaining your approach

class MyHashMap {

    /** Initialize your data structure here. */

    ListNode[] hashBucket;
    public MyHashMap() {
        hashBucket = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = getHash(key);
        if(hashBucket[hash]==null){
            hashBucket[hash] = new ListNode(key,value);
        }else{
            ListNode temp = hashBucket[hash];
            do{
                if(temp.key == key) {
                    temp.value = value;
                    return;
                }else{
                    if(temp.next != null)
                        temp = temp.next;
                }
            } while(temp.next != null);
            temp.next = new ListNode(key,value);
        }
    }

    public int getHash(int key) {
        return key % 10000;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        if(hashBucket[hash]==null){
            return -1;
        }else{
            ListNode temp = hashBucket[hash];
            do{
                if(temp.key == key) {
                    return temp.value;
                }else{
                    if(temp.next != null)
                        temp = temp.next;
                }
            } while(temp.next != null);
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHash(key);
        if(hashBucket[hash] == null){
            return;
        }else{
            ListNode prev = hashBucket[hash];
            if(prev.key == key){
                hashBucket[hash] = prev.next;
                return;
            }
            ListNode temp = prev.next;
            while(temp != null)
            {
                if(temp.key == key) {
                    prev.next = temp.next;
                    return;
                }
            }

        }

    }


    private static class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
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
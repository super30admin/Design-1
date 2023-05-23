// Time Complexity : O(1)
// Space Complexity : O(n)
    //Where n is the size of the MinStack

// Did this code successfully run on Leetcode : 
    //Yes. Beats 95.69% of all LeetCode Java Submissions in terms of Time Complexity and 82.56% of them in terms of Space Complexity.

// Any problem you faced while coding this : 
    //No, I am using Chaining Method to avoid collisions. I could have used BST instead of LinkedList as the chain. But, implementing a self-balancing BST is quite complex for me right now.

// Your code here along with comments explaining your approach

    //Locate the head of the Linked List using the hash index. Traverse through the LinkedList,
    //Add new numbers at end of the Linked List. We must traverse the entire List to avoid duplicate numbers. We cannot have a tail pointer and Doubly LL.
    //We remove the numbers or check their availability like a general Singly LL.

class MyHashSet {

    private ListNode[] hashArray;
    private int primeNumber = 1009;

    public MyHashSet() {
        hashArray = new ListNode[primeNumber];
    }
    
    public void add(int key) {
        ListNode temp = new ListNode(key);
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            head = temp;
            hashArray[hashIndex] = head;
            return;
        }
        ListNode curr = head;
        while(curr.next!=null)
        {
            if (curr.val==key)
            {
                return;
            }
            curr = curr.next;
        }
        if (curr.val==key)
        {
            return;
        }
        curr.next = temp;
        hashArray[hashIndex] = head;
    }
    
    public void remove(int key) {
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            return;
        }
        if (head.val==key)
        {
            head = head.next;
            hashArray[hashIndex] = head;
            return;
        }
        ListNode curr = head;
        while(curr.next!=null)
        {
            if (curr.next.val==key)
            {
                curr.next = curr.next.next;
                hashArray[hashIndex] = head;
                return;
            }
            curr = curr.next;
        }
        hashArray[hashIndex] = head;
    }
    
    public boolean contains(int key) {
        
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            return false;
        }
        ListNode curr = head;
        while(curr!=null)
        {
            if (curr.val==key)
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val)
    {
        this.val = val;
        next = null;
    }

    @Override
    public String toString()
    {
        return "["+this.val+"]";
    }
    
    public void print()
    {
        ListNode curr = this;
        while(curr!=null)
        {
            System.out.print(curr+"->");
            curr = curr.next;
        }
        System.out.println("Null");
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
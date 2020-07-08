// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap{
    ListNode[] nodes = new ListNode[1000];

    public void put(int key, int value){
        int Index = getIndex(key);
        ListNode prev = findElement(index, key);
        if (prev.next == null){
            prev.next = new ListNode(key, value);
        }
        else{
            prev.next.key = key;
        }
    }

    public void remove(int key){
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }

    }

    public int get(int key){
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null? -1:prev.next.val;
    }

    public int getIndex(int key){
        return Integer.hashCode(key)%1000;
    }

    private ListNode findElement(int index, int key){
        if (nodes[index]==null){
            return nodes[index] = new ListNode(-1,-1);
        }
        else{
            ListNode prev = nodes[index];
            while(prev.next!=null && prev.next.key!=key){
                prev = prev.next;
            }
            return prev;
        }
    }


    private static class ListNode{
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

}

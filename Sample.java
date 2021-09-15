// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1.
class MyHashSet {

    /** Initialize your data structure here. */
    private final int Max = 1000000;
    private final int ArrSize = 100;
    private List<List<Integer>> ParentList;

    public MyHashSet() {

        ParentList = new ArrayList<>(ArrSize);
        for( int i = 0; i <= ArrSize ; i++){
            ParentList.add(null);
        }

    }

    public void add(int key) {
        int Index = key % ArrSize;
        List<Integer> ChildList = ParentList.get(Index);
        if(ChildList == null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            ParentList.set(Index,list);
        }
        else{
            if(!ChildList.contains(key))
            {
                ChildList.add(key);
            }

        }

    }


    public void remove(int key) {

        int Index = key % ArrSize;
        List<Integer> ChildList = ParentList.get(Index);
        if(ChildList != null){
            ChildList.remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int Index = key % ArrSize;
        List<Integer> ChildList = ParentList.get(Index);
        if(ChildList != null){
            return ChildList.contains(key);
        }
        return false;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


//2.
class MinStack {

    Stack<Integer> stack = new Stack();
    Stack<Integer> minvalue = new Stack();


    /** initialize your data structure here. */

    public void push(int val) {

        if(minvalue.isEmpty() || val <= minvalue.peek()){
            minvalue.push(val);
        }

        stack.push(val);
    }

    public void pop() {
        if(stack.peek().equals(minvalue.peek())){
            minvalue.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minvalue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

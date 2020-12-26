//TC; O(1)
//SC: O(n)

/*
thought process: This thought process came from vertical order traversal of binary tree,where we
modify the treeNode as custom Node and store min and max value:
 */

//in this question we will modify input into a custom node which will also store min and reference of previous
//inserted element.

class Node{
    int x;
    int min;
    Node prev;

    public Node(int x, int min, Node prev){
        this.x = x;
        this.min = min;
        this.prev = prev;
    }
}

class MinStackModified{
    Node st;

    public MinStackModified(){
        this.st = null;
    }

    public void push(int x) {
        //check if this is first element getting inserted
        if(st == null){
            st = new st(x,x,st);
        }
        else{
            //if the element is not first element then come in this condition
            /*
            1. insert the element
            2. check if the element is minimum
            3. store the reference of previous element
             */

            st = new Node(x,Math.min(x,st.min),st);
        }
    }

    public void pop() {
        //update the st pointer to the previous node.
        st = st.prev;
    }

    public int top() {
        //return the value of the node which is on top;
        return st.x;
    }

    public int getMin() {
        //return the minValue stored.
        return st.min;
    }
}

/*
Leetcode analysis:
Runtime: 3 ms, faster than 100.00% of Java online submissions for Min Stack.
Memory Usage: 40.7 MB, less than 73.45% of Java online submissions for Min Stack.
 */
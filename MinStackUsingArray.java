//Time complexity: O(1)
//Space complexity: O(1)
class MinStackUsingArray {


    //We will maintain a index variable
    int index = -1;

    //values array will be used to insert elements in the order they come.
    int[] values = new int[30000];

    //min array will be used to insert element in such a way that minimum value remains at the top of the stack.
    int[] min = new int[30000];

    MinStackUsingArray() {

    }
   
    public void push(int val) {
        //increment the index counter and then push the element
        index++;
        //insert the element into the array at index.
        values[index] = val;
        //if this the first element to pushed, push at index 0
        if(index == 0) {
            min[index] = val;
        }
        //else we will compare the element to be inserted with the element at location index-1, and then insert.
        else{
             min[index] = Math.min(min[index-1], val);
        }
    }
   
    public void pop() {
        //decrement the index counter
        index--;
    }
   
    public int top() {  
        return values[index];  
    }
   
    public int getMin() {
        return min[index];   
    }

    public static void main(String args[]) {
        MinStackUsingArray minStack = new MinStackUsingArray();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin();
    }
    
}
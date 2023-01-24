
// Your code here along with comments explaining your approach
/*
Time Complexity : O(1)
Space Complexity : O(1)
Hashset Impl
my thought process
1. we need to store keys i.e. select a suitable data structure, i thought of arrays & linkedlist
2. perform a search to find the key
3. perform a search and delete key if found

i chose linkedlist because if i chose arrays, deleting a key would be difficult.
i tried to implement using linkedlist, but it was out of time.
then i thought of using arrays to implement with the max size i.e. possible total calls given.
thought of using the mod while inserting the elements, but got stuck with deletion.
i got stuck for few minutes, so took a look at solutions.

class MyHashSet {
    boolean[] setArray;
    public MyHashSet() {
        setArray = new boolean[1000000 + 1];
    }
    public void add(int key) {
        setArray[key] = true;
    }
    public void remove(int key) {
        setArray[key] = false;
    }
    public boolean contains(int key) {
        return setArray[key];
    }
}

MinStack Impl
Time Complexity : O(1)
Space Complexity : O(n)
as the time taken should be O(1), we should keep track of the minimum element.
my approach:
1. take two arrays, one for stack, second for tracking min element at a given time and two indexes(i.e. one is top & other is min index)
2. we have to update both arrays for push and pop
3. in case of push, if the element is starting element, make it as min element. else, check if it overflows,
if not, compare min and given value, if min>=val, push it to minStack, increment minIndex;
4. in case of pop, check if it is the min element, if yes, decrement minIndex(now this will point to previous min element)

i thought of implementing using linkedlist but got stuck.
this solution passed all test cases.
we could modify this to use less space.

class MinStack {

    int stack[];
    int minStack[];
    int top;
    int min;
    int minIndex;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
        top = -1;
        min = -1;
        minIndex = -1;
    }

    public void push(int val) {
        if(top==-1){
            stack[++top] = val;
            min = val;
            minStack[++minIndex] = val;
            return;
        }
        if (top!=stack.length-1) {
            stack[++top] = val;
            if(min>=val) {
                min = val;
                minStack[++minIndex] = val;
            }
        }
    }

    public void pop() {
        if(stack[top]==min){
            if(minIndex!=0)
                min = minStack[--minIndex];
            else
                min = minStack[minIndex--];
        }
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minIndex];
    }


}

public class Sample {
    public static void main(String args[]) {
        MinStack obj = new MinStack();
        obj.push(395);
        System.out.println("min"+obj.getMin());
        System.out.println("min"+obj.top());
        System.out.println("min"+obj.getMin());
        obj.push(276);
        obj.push(29);
        System.out.println("min"+obj.getMin());
        obj.push(-482);
        System.out.println("min"+obj.getMin());
        obj.pop();
        obj.push(-108);
        obj.push(-251);
        System.out.println("min"+obj.getMin());

    }
}
*/
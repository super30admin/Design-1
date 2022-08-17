//Approach 1: Using 1:1 Stack Mapping
//Overall Time Complexity: O(1)
//Overall Space Complexity: O(N)
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> supportStack;
    int min;

    public MinStack() {
        mainStack = new Stack<>();
        supportStack = new Stack<>();
        min = Integer.MAX_VALUE;
        supportStack.push(min); //To tackle the case where main stack has one element
    }

    //Time Complexity: O(1)
    public void push(int val) {
        min = Math.min(val, min);
        mainStack.push(val);
        supportStack.push(min);
    }

    //Time Complexity: O(1)
    public void pop() {
        mainStack.pop();
        supportStack.pop();
        min = supportStack.peek();
    }

    //Time Complexity: O(1)
    public int top() {
        return mainStack.peek();
    }

    //Time Complexity: O(1)
    public int getMin() {
        return min;
    }
}

//Approach 2: Single stack approach
//Overall Time Complexity: O(1)
//Overall Space Complexity: O(N)
class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        st = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    //Time Complexity: O(1)
    public void push(int val) {
        // Mind the equal to condition as well,
        // as while popping we want to maintain consistency
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }

    //Time Complexity: O(1)
    public void pop() {
        //once pop is already done in the condition checking
        if(min == st.pop()){
            min = st.pop();
        }
    }

    //Time Complexity: O(1)
    public int top() {
        return st.peek();
    }

    //Time Complexity: O(1)
    public int getMin() {
        return min;
    }
}

//There is also a Pair Approach
//Single stack two items approach
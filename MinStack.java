class MinStack {
    Stack<Integer> stack;
    Stack<int[]> minStack;

    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(new,int[]{x,1});
        }
        else if(x<minStack.peek()[0]){
            minStack.push(new,int[]{x,1});
        }
        else if(x == minStack.peek()[0]){
            minStack.peek()[1]++;
        }
    }

    public void pop(){
        int poppedElement = stack.pop();
        if(poppedElement == minStack.peek()[0]){
            minStack.peek()--;
        }
        if(minStack.peek()[1] == 0){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }
}
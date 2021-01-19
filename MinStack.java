class MinStack {
    
    static final int MAX = 1000000; 
    int top; 
    public int a[] = new int[MAX];
    int min;

    /** initialize your data structure here. */
    public MinStack() {
       top = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if (x <= min) {
            top = top + 1;
            a[top] = min;
             min = x;
        }
        top = top + 1;
        a[top] = x;
        
    }
    
    public void pop() {
        
        int poppedEle = a[top];
        top = top - 1;
        
        if (poppedEle == min) {
            min = a[top];
            top = top - 1;
        }
    
        
    }
    
    public int top() {
        
        return a[top];
        
    }
    
    public int getMin() {
        return min;
    }
}

class Main { 
    public static void main(String args[]) 
    { 
        MinStack obj = new MinStack();
       // Main.printArray(obj.a, obj.min, obj.top);
        obj.push(-2);
        Main.printArray(obj.a, obj.min, obj.top);
        obj.push(-1);
        Main.printArray(obj.a, obj.min, obj.top);
        obj.push(-3);
        Main.printArray(obj.a, obj.min, obj.top);
        obj.pop();
        Main.printArray(obj.a, obj.min, obj.top);
    } 

    public static void printArray(int[] arr, int min, int top) {
        System.out.println("\n\n\n");
        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Min: " + min + " Top: " + arr[top]);
        System.out.println("\n\n\n");
    }
}
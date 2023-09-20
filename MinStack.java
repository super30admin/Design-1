import java.util.Scanner;
import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    int min;
    public MinStack() {
        s=new Stack<>();    
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
            s.push(min);
            min=val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(min==s.pop())
        {
           min= s.pop();
        }   
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Push an element");
            System.out.println("2. Pop the top element");
            System.out.println("3. Get the top element");
            System.out.println("4. Get the minimum element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int elementToPush = scanner.nextInt();
                    minStack.push(elementToPush);
                    break;
                case 2:
                    minStack.pop();
                    break;
                case 3:
                    int topElement = minStack.top();
                    System.out.println("Top element: " + topElement);
                    break;
                case 4:
                    int minElement = minStack.getMin();
                    System.out.println("Minimum element: " + minElement);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}


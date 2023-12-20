
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStackTester {
    public static void main(String[] args) {
        MinStack minStackTester = new MinStack();

        minStackTester.push(5);
        minStackTester.push(51);
        minStackTester.push(5);
        minStackTester.push(1);

        System.out.println(minStackTester.getMin());

        minStackTester.pop();

        System.out.println(minStackTester.getMin());
        minStackTester.pop();
        System.out.println(minStackTester.getMin());
        minStackTester.pop();
        System.out.println(minStackTester.getMin());
        minStackTester.pop();
        System.out.println(minStackTester.getMin());
        System.out.println(minStackTester.getMin());

    }
}
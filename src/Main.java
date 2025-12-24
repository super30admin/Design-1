
void main() {
    MyHashSet myHashSet = new MyHashSet();

    myHashSet.add(1);        // set = [1]
    myHashSet.add(2);        // set = [1, 2]

    System.out.println(myHashSet.contains(1)); // true
    System.out.println(myHashSet.contains(3)); // false

    myHashSet.add(2);        // set = [1, 2]
    System.out.println(myHashSet.contains(2)); // true

    myHashSet.remove(2);     // set = [1]
    System.out.println(myHashSet.contains(2));// false
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(-0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
}
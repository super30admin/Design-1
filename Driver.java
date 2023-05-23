public class Driver {
    public static void main(String[] args)
    {
        //Problem-1
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(2);
        myHashSet.add(78);
        myHashSet.add(987123);
        System.out.println(myHashSet.contains(78));
        System.out.println(myHashSet.contains(79));
        System.out.println(myHashSet.contains(987123));
        myHashSet.remove(987123);
        System.out.println(myHashSet.contains(987123));
        System.out.println(myHashSet.contains(33424));
        myHashSet.add(33424);
        System.out.println(myHashSet.contains(33424));

        //Problem-2
        MinStack minStack = new MinStack();
        minStack.push(56);
        minStack.push(78);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(15);
        minStack.push(98);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


    }
}

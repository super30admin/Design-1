public class Main {
    public static void main(String[] args) {
        DesignHashSet obj = new DesignHashSet();
        obj.add(6);
        obj.add(4);
        obj.add(2);
        obj.remove(6);
        boolean param_3 = obj.contains(4);
        System.out.println(param_3);

        MinStack obj1 = new MinStack();
        obj1.push(2);
        obj1.push(-4);
        obj1.push(5);
        obj1.pop();
        obj1.push(120);
        obj1.push(-234);
        obj1.push(435);
        int p = obj1.top();
        int p1 = obj1.getMin();
        System.out.println(p);
        System.out.println(p1);
    }
}

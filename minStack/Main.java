package minStack;

public class Main {
	
	
public static void main(String[] arg) {
	
MinStack2 s= new MinStack2();
s.push(2);
s.push(0);
s.push(3);
s.push(0);

System.out.println(s.getMin());
s.pop();
System.out.println(s.getMin());
s.pop();
System.out.println(s.getMin());
s.pop();
System.out.println(s.getMin());

//s.push(-1);
System.out.println(s.getMin());

}
}

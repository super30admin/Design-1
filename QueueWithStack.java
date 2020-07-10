
import java.util.*;
// look what specific class is required to implement the code


class QueueWithStack{
Stack<Integer> q1 = new Stack<>();
Stack<Integer> q2 = new Stack<>();
  public void push(int x){
    q1.push(x);
  }
  // TS:O(1)

  public void pop(){
    if(q2.isEmpty()){
      while(!q1.isEmpty()){
        q2.push(q1.pop());
      }
    }
    q2.pop();
  }
  // TS:O(n)


  public int peek(){
    if(q2.isEmpty()){
      while(!q1.isEmpty()){
        q2.push(q1.pop());
      }
    }
    return q2.peek();
  }
  // TS:O(n)


  public boolean Empty(){
    if(q1.isEmpty() && q2.isEmpty())
    return true;

    else
    return false;
  }
  // TS:O(1)

}

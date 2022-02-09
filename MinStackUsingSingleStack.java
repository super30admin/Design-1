/*Discussed in class*/
class MinStackUsingSingleStack
{
  Stack<Integer> stack;
  int min ;

  public MinStackUsingSingleStack()
  {
     min = Integer.MAX_VALUE;
  }

  public void push(int val)
  {

  if (val < = min)
      {
      stack.push(min);
      min = val;
      }
      stack.push(val);
  }

  public void pop()
  {
   int ele = stack.pop();
   if (min == ele)
   {
      min = stack.pop();
   }
  }

  public int top()
  {
   return stack.peek();
  }


  public int getMin()
  {
   return min;
  }

}
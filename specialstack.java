import java.util.Stack; 
  

class MinStack{
    Stack<Integer> min;
    MinStack(){
         min = new Stack<Integer>();
    }
   int mini;
   public void push(int x){
        if(min.isEmpty()){
            min.push(x);
            mini=x;
        }
        else{
            if(x>mini){
                min.push(x);
            }
            else{
                min.push(mini);
                mini=x;
                min.push(x);
            }
        }
    }
    public void pop(){
        if(min.isEmpty()){
            return ;
        }
        else{
            if(min.peek()!=mini){
                min.pop();
            }
            else{
                min.pop();
                if(!min.isEmpty()){
                    mini=min.peek();
                    min.pop();
                }
                else{
                    mini=0;
                }
                
            }
        }
       
    }
    public int top(){
        if (min.isEmpty()){
            return 0;
        }
        else{
             return min.peek();
        }
       
    }
    public int getMin(){
        if(min.isEmpty()){
            return 0;
        }
        else{
             return mini;
        }
       
    }
    }

    // Min stack implemented using one single stack as taught in the class. Run time exceptions in this code has been handled by checking whether the stack runs empty or not during every peek(), pop() and getMin() operations.
    // Time Complexity: O(1), Average Space Complexity: N.
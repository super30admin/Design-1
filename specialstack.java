import java.util.Stack; 
  

class SpecialStack extends Stack<Integer> 
{ 
    Stack<Integer> min = new Stack<>(); 
      
    
    void push(int x) 
    { 
        if(isEmpty() == true) 
        { 
            super.push(x); 
            min.push(x); 
        } 
        else
        { 
            super.push(x); 
            int y = min.pop(); 
            min.push(y); 
            if(x < y) 
                min.push(x); 
            else
                min.push(y); 
        } 
    } 
  
    /* SpecialStack's member method to insert an element to it. This method 
    makes sure that the min stack is also updated with appropriate minimum 
    values */
    public Integer pop() 
    { 
        int x = super.pop(); 
        min.pop(); 
        return x; 
    } 
  
    /* SpecialStack's member method to get minimum element from it. */
    int getMin() 
    { 
        int x = min.pop(); 
        min.push(x); 
        return x;
    }
}
//Special stack has been implemented using the stack data struction in java.
//Time complexity:O(1).
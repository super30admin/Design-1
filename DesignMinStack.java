//Time Complexity : O(1)
//Space Complexity : O(n)
class MinStack {
    ArrayList<Integer> minStack=new ArrayList<Integer>();
    ArrayList<Integer> minValue=new ArrayList<Integer>();
   int min;
   int count;
   int minCount;
       
       public MinStack() {
           min=Integer.MAX_VALUE;
           count=-1;
           minCount=0;
           minValue.add(min);
           
       }
       
       public void push(int val) {
           minStack.add(val);
           if (val<=min){
             minValue.add(val);
             min=val;
             minCount+=1;
           }
           count+=1;
           
    
       }
       
       public void pop() {
           int popValue=minStack.remove(count);
           if (popValue==min){
               minValue.remove(minCount);
               minCount-=1;
               min=minValue.get(minCount);
               }
           count-=1;
      
           
       }
       
       public int top() {
           return minStack.get(count);
       }
       
       public int getMin() {
           return min;
       }
   }
   
   /**
    * Your MinStack object will be instantiated and called as such:
    * MinStack obj = new MinStack();
    * obj.push(val);
    * obj.pop();
    * int param_3 = obj.top();
    * int param_4 = obj.getMin();
    */
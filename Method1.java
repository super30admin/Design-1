//Time complexity O(1)
//Space complexity O(N)
//successfully run in leetcode
//also done an approach using two stacks instead of two arrays. so the runtime and space are less



class MinStack {
    int MAX = 30000,i=0;
    int arr[]=new int [MAX];
    int min[]=new int [MAX];
    int top;
    public MinStack() {                                                                                                                                                                                                                                                             
        top=-1;
        
    }
    
    public void push(int val) {
        if(top>=MAX){
            return;
        }   
        
        top++;
        arr[top]=val;
        if(top==0){
         min[i]=arr[top];
            return;
        }
        if(arr[top]<=min[i]){
            i++;
            min[i]=arr[top];
            
            
        
        }
        return;
    }
    
    public void pop() {
        if(top==-1){
            return;
        }
        if(arr[top]==min[i] && i!=0){
            i--;
        }
        top--;
        return;
    
        }
        
    
    public int top() {
        return arr[top];
    }
    
    public int getMin() {
        return min[i];
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



// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

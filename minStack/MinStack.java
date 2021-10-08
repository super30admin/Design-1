package minStack;

import java.util.*;

class MinStack {
    
    class pair{
        int value;
        int min;
        
     pair(int value, int min){
         this.value=value;
         this.min=min;
     }   
        
    }
    
    
    int top;
    int min;
    int max;
    ArrayList<pair> a;
    
    
    /** initialize your data structure here. */
    public MinStack() {
        this.a= new ArrayList<pair>();
        this.top=0;
    }
    
    public void push(int val) {
        
        
        if(this.a.size()==0){
            pair p= new pair(val,val);
            this.a.add(p);
            this.min=val;
            this.top++;
            
        }else if(val<this.min){
                pair p= new pair(val,val);
                this.min=val;
                this.a.add(p);   
                this.top++;      
        }else{
            
            pair p= new pair(val,this.min);
            this.a.add(p);
            this.top++;
       
        }
        
        }
        
    
    
    public void pop() {
        
        if(a.size()!=0){
        
            this.a.remove(this.top-1);
            this.top--;
            
        }
    
     if(this.top>0){
        	this.min=this.a.get(this.top-1).min;
        	   }
    }
    
    public int top() {
        return this.a.get(this.top-1).value;
    }
    
    public int getMin() {
        return this.a.get(this.top-1).min;
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

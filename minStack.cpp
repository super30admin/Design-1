#include<iostream>
# define MAX 1000
class MinStack {
     int top_1;
public:
       
        int a[MAX];
    MinStack() {top_1 = -1;}
        // void push(int val); 
        // void pop(); 
        // int top(); 
        // int getMin(); 

    void push(int val) {
        if(top_1 == MAX-1){
            cout<<"Stack is overflow"<<endl;
        }
        else{
            top_1++;
            a[top_1] = val;

        }
        
    }
    
    void pop() {
        if(top_1 == -1){

            cout<<"Stack is underfflow"<<endl;

        }
        else{
            int x = a[top_1];
            top_1--;
            
            
        }


    }
    
    int top() {
        
        int x;
        if(top_1 == MAX-1){
            cout<<"Stack is overflow"<<endl;
        }
        else{
         x = a[top_1];
                  
        }
        return x;
    }
    
    int getMin() {
        
        int i,j,x = a[0];
        for(i=0;i<=top_1;i++){
        if(x>a[i]){
            x = a[i];
        }
    }
    return x;
}

};


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
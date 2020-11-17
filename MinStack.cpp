class MinStack {
public:
    /** initialize your data structure here. */
     stack <int> s1;
    stack <pair <int , int> >  s2;
    MinStack() {
   
    }
    
    void push(int x) {
        s1.push(x);

        if(s2.empty())
            s2.push({x,1});
        else{
            int min = s2.top().first;
            int freq= s2.top().second;
            if(x < min){
                s2.push({x,1});
            }
            else if(x == min){
                s2.pop();
                s2.push({x, freq+1});
            }
        } 
    }
    
    void pop() {
        if(s1.top() == s2.top().first){
            
            int freq = s2.top().second;
            if(freq==1){
                s1.pop();
                s2.pop();
            }
            else{
                s1.pop();
                int min= s2.top().first;
                s2.pop();
                s2.push({min, freq-1});
            }
            
        }
        else{
            s1.pop();
        }        
    }
    
    int top() {
        
        return s1.top();
    }
    
    int getMin() {
        return s2.top().first;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
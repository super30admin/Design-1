//155. Min Stack

/*
Maintain two stacks - one to push/pop/top[act] and another which tracks of minimum element[mini]
When a new value is added to act, if mini is empty add it otherwise compare to the minimum element inserted so far

Time complexity: O(1) - push/pop/top to stack takes O(1); getMini() also takes O(1) as its mini.top()
Space complexity: O(n+n) = O(2n) = O(n)
*/

class MinStack {

private:
  stack<int> act;
  stack<pair<int,int>> mini;    // to get mini
public:
    MinStack() {
        
    }
    
    void push(int val) {

        act.push(val);

        if(mini.empty() || mini.top().first > val){
            mini.push({val, 1});
        }
        //why maintain second index? - for checking frequency
        else if(mini.top().first == val){
            mini.top().second++;
        }
        
    }
    
    void pop() {

        if(act.top() == mini.top().first){
            mini.top().second--;

            if(mini.top().second == 0){
                mini.pop();
            }
        }


        act.pop();

        
    }
    
    int top() {

        return act.top();
        
    }
    
    int getMin() {

        return mini.top().first;
        
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
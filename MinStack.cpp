// Time Complexity : All Operations are O(1).
// Space Complexity : Space Complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I wasn't able to get the idea that I couldve stored the minimum value as a second value in the pair.  

class MinStack {
public:
vector<pair<int,int>> buffer; // A buffer vector to store the value and the minimum value seen until that value. 
    MinStack() {         
    }
    
    void push(int val) { // Check if buffer size is zero. If not, compare current Minimum Value to "val" and figure out which one is minimum, and push that value along with "val".
        if(buffer.size() == 0) buffer.push_back({val,val});
        else {
            int currentMin = buffer.back().second; 
            cout << "current Min is: " << currentMin << endl; 
            if(currentMin > val) buffer.push_back({val,val});
            else buffer.push_back({val,currentMin}); 
        }    
    }
    
    void pop() { // Easy pop. 
        buffer.pop_back();     
    }
    
    int top() { // Return the first element in the pair at the top. 
        return buffer.back().first;        
    }
    
    int getMin() { // Return the second elemnt in the pair at the top. 
        return buffer.back().second;     
    }
};
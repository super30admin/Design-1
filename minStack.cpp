#include <iostream>
#include <vector>
#include <climits>

using namespace std;

class MinStack {
private:
    vector<int> mainStackArr;
    vector<int> minStackArr;
public:
    MinStack() {
        // Nothing to initialize here
    }
    
    void push(int val) {
        mainStackArr.push_back(val);
        if (minStackArr.empty()) {
            minStackArr.push_back(val);
        }
        else {
            minStackArr.push_back(min(val, minStackArr.back()));
        }
    }
    
    void pop() {
        if (!mainStackArr.empty()){
            mainStackArr.pop_back();
            minStackArr.pop_back();
        }
    }
    
    int top() {
        if (!mainStackArr.empty()){
            return mainStackArr.back();
        }
        return INT_MIN;    
    }
    
    int getMin() {
        if (!minStackArr.empty()){
            return minStackArr.back();
        }
        return INT_MIN;
    }
};

int main() {
    MinStack minStack;
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    cout << minStack.getMin() << endl;
    minStack.pop();
    cout << minStack.top() << endl;
    cout << minStack.getMin() << endl;

    return 0;
}
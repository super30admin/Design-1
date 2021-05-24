// Time Complexity : O(1) for all operations
// Space Complexity : O(1) no extra space used for any operation (excluding the stack array which is not considered)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<iostream>
using namespace std;

#define MAX_SIZE 30001

class MinStack {
private:
    int top1;
    int min;
    int minIndex;
public:
    int arr[MAX_SIZE];

    MinStack() {
        top1 = -1;
        min = INT_MAX;
    }
    
    void push(int val) {

        if(top1 >= 30001 - 1){
            return;
        }
        else{
            if(min >= val){
                top1++;
                arr[top1] = min; //push the old min
                min = val;      // update min to val
            }
            top1++;
            arr[top1] = val; // push the val or new min if val < min
        }
        
    }
    
    void pop() {

        if(top1 == -1){
            return;
        }
        else{
            if(arr[top1] == min){
                --top1;  // Removed the element
                min = arr[top1]; // this contains the copy of old min which is now the new min
                --top1;  // Delete the extra old min copy
            }
            else{
                --top1;
            }
        }
    }
    
    int top() {
        if(top1 == -1)
            return 0;
        else
            return arr[top1];
    }
    
    int getMin() {
        if(top1 == -1)
            return 0;
        else 
            return min;
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

/* Driver Program for testing*/
int main(){
    class MinStack *obj = new MinStack();
    cout<<"\nPushing 4 Values";
    obj->push(2);
    obj->push(0);
    obj->push(3);
    obj->push(0);
    cout<<"\nMinimum: "<<obj->getMin();
    obj->pop();
    cout<<"\nTop is: "<<obj->top();
    cout<<"\nMinimum: "<<obj->getMin();
    obj->pop();
    cout<<"\nMinimum: "<<obj->getMin();
    obj->pop();
    cout<<"\nMinimum: "<<obj->getMin();
    cout<<"\nTop is: "<<obj->top();
    return 0;
}
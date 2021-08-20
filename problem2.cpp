// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass MyHashMap(object):
class List{
    public:
    int data;
    int min;
    List* next;
};

class MinStack {
public:
    List* head;
    MinStack() {
        head=NULL;
    }
    
    void push(int val) {
        List* newNode=new List();
        if(head==NULL){
            newNode->data=val;
            newNode->next=head;
            newNode->min=val;
        }
        else{
            newNode->data=val;
            newNode->next=head;
            newNode->min=min(val,head->min);
        }
        head=newNode;
    }
    
    void pop() {
        head=head->next;
    }
    
    int top() {
        return head->data;
    }
    
    int getMin() {
        return head->min;
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
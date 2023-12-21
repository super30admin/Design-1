// Time Complexity : O(1)
// Space Complexity : O(2n) worst case, amortized O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
#include <climits>
class MinStack {
private:
    struct Node
    {
        int value;
        Node* next;
        Node(int val,Node* nextNode)
        {
            value = val;
            next = nextNode;
        }
    };
public:
    Node* head;
    int currMin;
    MinStack() {
        head = nullptr; 
        currMin = INT_MAX;
    }
    
    void push(int val) {
        if(val<=currMin)
        {
            head= new Node(currMin,head);
            currMin = val;
        }
        head = new Node(val,head);
    }
    
    void pop() {
        if(currMin==top())
        {
            Node* temp1 = head;
            Node* temp2 = head->next;
            currMin = temp2->value;
            head = head->next->next;
            delete temp1,temp2;
            return;
        }
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }
    
    int top() {
        return head->value;
    }
    
    int getMin() {
        return currMin;
    }
};
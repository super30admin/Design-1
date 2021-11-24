// Time Complexity : O(1) for all operations
// Space Complexity : O(N) for storing data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MinStack 
{
    
    struct Node
    {
        int value;
        int min;
        Node *next;
    };
    
    Node * head;
    
public:
    MinStack() 
    {
        head=NULL;
    }
    
    void push(int val) 
    {
        if(head==NULL)
        {
            Node* newNode = new Node();
            newNode->value = val;
            newNode->min = val;
            
            newNode->next = head;
            head = newNode;
        }
            
        else
        {
            int curr_min = head->min;
            Node* newNode = new Node();
            newNode->value = val;
            if(curr_min>val)
            {
                newNode->min = val;
            }
            else
                newNode->min = curr_min;
            
            
            newNode->next = head;
            head = newNode;
        }
    }
    
    void pop() 
    {
        if(head !=NULL)
        {
            Node * temp = head;
            head = head->next; 
            delete(temp);    
        }
            
    }
    
    int top() 
    {
        if(head == NULL)
            return NULL;

        return head->value;
    }
    
    int getMin() 
    {
        if(head!=NULL)
            return head->min;
        return NULL;
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
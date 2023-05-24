/*

// Time Complexity : O(1) for all the functions
// Space Complexity : O(1) for all the functions
// Did this code successfully run on Leetcode :
Yes it did. However, there was a better implementation using inbuilt stack functions
also using double stack functions . Need to check
// Any problem you faced while coding this :
Problem faced using class Node so instead used struct node. 
intial logic , how to use the values of the stack instead of using the pointers
to retrieve the next min value

// Your code here along with comments explaining your approach

*/



#include<iostream>
#include<limits.h>

using namespace std;

// define node
struct Node
{

    long long int val{};
    Node* next;
};

//define stack
class MinStack
{
    Node* head;
    long long int min_val{};
    public:

    MinStack()
    {
        head = NULL;
        min_val = INT_MIN;
    }
    /*
    check if new value less than existing min
    if so then val = 2*new_min - old_min
    so that you can trace back the old values using this function
    as 2*newmin - old_min < new_min
    it act as a flag for all the minimums in the stack. 
    */
    void push(long long int val)
    {
        Node* node = new Node();
        if(!head)
        {
            min_val = val;
        }
        else
        {
            if(val<min_val)
            {
                long long int old_min{min_val};
                min_val = val;
                val = 2*val - old_min;
            }
        }
        node->val = val;
        node->next = head;
        head = node;

    }
    /*
    if pop value is existing min 
    then find the previous min
    */
    void pop()
    {
        if(!head)
            return;
        else
        {
            if(head->val<min_val)
            {
                min_val = 2*min_val - head->val;
            }
        }
        Node* temp;
        temp = head;
        head = head->next;
        delete(temp);

    }
    /*
    if top value is the min ele
    determine it using 
    value less than min_element.
    and then print the min_element.
    */
    long long int top()
    {
        if(!head)
            return 0;
        else
        {
            if(head->val<min_val)
                return min_val;
            return head->val;
        }

    }

    long long int getMin()
    {
        if(!head)
            return 0;
        return min_val;
    }

};

int main(int argc, char const *argv[])
{
    MinStack* stack = new MinStack();
    stack->push(-2);
    cout<<"push mian hian"<<endl;
    stack->push(0);
    stack->push(-3);
    cout<<stack->getMin();
    cout<<"get min main hain"<<endl;
    stack->pop();
    cout<<"pop main hain"<<endl;
    cout<<stack->top();
    cout<<"top main hain"<<endl;
    cout<<stack->getMin();



    return 0;
}

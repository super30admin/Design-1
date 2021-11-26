#include "minStack.h"
#include "limits.h"

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

MinStack::MinStack()
{
    min = INT_MAX;
    min_stack.push(min);
}

// Time Complexity : O(1)
// Space Complexity : O(1)

int MinStack::top()
{
    return main_stack.top();
}

// Time Complexity : O(1)
// Space Complexity : O(1)

int MinStack::getMin()
{
    return min_stack.top();
}

// Time Complexity : O(1)
// Space Complexity : O(1)

void MinStack::push(int new_value)
{
    main_stack.push(new_value);
    if(new_value < min)
    {
        min = new_value;
    }

    min_stack.push(min);
}

// Time Complexity : O(1)
// Space Complexity : O(1)

void MinStack::pop()
{
    if(min != INT_MAX)
    {
        min_stack.pop();
        min = min_stack.top(); 
    }

    main_stack.pop();
}

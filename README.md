Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)


#### Approach 

I used two lists(Arrays)

list1 as the parent stack
list2 as the child stack for min stack value 

Approach was to do one to  one mapping 


push :
append the elements to main stack 
append the min_value to child stack 

pop: 
delete the last elements in both stack

getmin:
retrive the last element from the childstack

peek 
return the last element from mainstack 


Approach fro Hash set 

I used statick arrays of length 1000 and 1000 for both primary and secondary array

used  two hash menthods
1) module % for which index to go in primary and / for secondary

for one index we have to add one more extra length to handle 10^6 element

Below error is beacuse of edge case when we recieve 10^6 element can you please help me resolving this issue 
I am getting TypeError: list indices must be integers or slices, not float

fixed this issue after checking there is 10^6 element that case  was now handled and  resolved 
    ~~~~~~~~~~~~~~~^^^^^^
    self.hass[val1][val2]= True

Line 21 in add (Solution.py)
             ^^^^^^^^
    result = obj.add(
Line 68 in __helper_select_method__ (Solution.py)
                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    ctime, ans = __DriverSolution__().__helper_select_method__(method, params[index], obj)








# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

Best Approach (Double Hashing):
1. Create a list ranging till sqrt(10^6)
	parentList = 0th index to 999th index, len =1000
2. Calculate hash-parent for input key and return it as an index for parentList.
	indexParent = key%1000
3. Go to parentList[indexParent], Create a childList ranging till sqrt(10^6)
	parentList[indexParent] = childList ; where childList = 0th index to 999th index, len =1000
4. Calculate hash-child for input key and return it as an index for childList.
	indexChild = key//1000
5. If parentList[indexParent][indexChild] == None; the set it to TRUE
6. Border Case:
		if key = 10^6
		indexParent = key%1000 = 0
		indexChild = key//1000 = 1000
		
		But we are initializing childList as "childList = 0th index to 999th index, len =1000"
		
		Therefore in such case:
		if indexParent = 0; initialize a childList as "childList = 0th index to 1000th index, len =1001"
		
		Summarize:
		if key = 10^6
			indexParent = key%1000 = 0
			indexChild = key//1000 = 1000
		
		parentList[0][1000] <= 10^6 value flag can be stored

Trade-off: Space wastage
	

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

Approach (Two Stack Approach):

1. pushStack: To push the elements into list
2. minStack: only push the minimum keys to the list

	Eg: Push the following -2,0,1,-3,4,-3

		pushStack = [-2,0,1,-3,4,-3]
		minStack = [-2,-3,-3]

3. Push(key) to the pushStack
4. Push(key) to the minStack only if minStack[-1]>key

Approach (One stack, store tuple pairs)

1. pushStack: push (key,minValue) pair into the list
	Eg: Push the following -2,0,1,-3,4,-2

		pushStack = [(-2,-2),(0,-2),(1,-2),(-3,-3),(4,-3),(-3,-3)]

Approach (One stack, store the "previous-minimum" below the "new-minimum")

1. pushStack: push the key into the list
2. If "key" to insert has the relationship key<= minValue
		2.1. Push minValue to the pushStack
		2.2. Update the minValue to the new key
		2.3. Now push the key to the pushStack

3. If pop() the key:
		3.1. Pop the element from the pushStack and store it in an 'ele'
		3.2. if ele == minValue; then new minValue will be pushStack's current top() element 
										***only if; pushStack's len >1, else it will be None 
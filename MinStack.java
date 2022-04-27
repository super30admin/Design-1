// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;
class MinStack {
    int[] arr;
    int[] orderedArr;
    int MAX_SIZE = 1000;
    //To keep track of number of elements in the arr
    int counter = 0;

    public MinStack() {
        arr = new int[MAX_SIZE];
        orderedArr = new int[MAX_SIZE];
        Arrays.fill(arr, -1);
        Arrays.fill(orderedArr, -1);
    }
    

    //Adding Elements
    public void push(int val) {
        if(isFull())
            return;
        arr[counter] = val;
        orderedArr[counter] = val;
        sort(val);
        counter++;
    }
    
    //Moving the newly added element to the correct position
    private void sort(int val) {
        for(int i = counter-1; i>=0; i--){
            if(orderedArr[i] > orderedArr[i+1]){
                int temp = orderedArr[i];
                orderedArr[i] = orderedArr[i+1];
                orderedArr[i+1] = temp; 
            }
            else{
                return;
            }
        }
    }


    //Decrementing counter 
    public void pop() {
        if(isEmpty())
            return;
        delete(arr[counter-1]);
        counter--;
    }
    
    //Deleting top element in the orderedArr
    public void delete(int val){
        for(int i = 0; i<=counter; i++){
            if(val == orderedArr[i]){
                swap(i);
            }
        }
    }
    
    //After deleting top element, need move all elements to left in orderededArr
    public void swap(int index){
        for(int i = index; i < counter;i++){
            orderedArr[i] = orderedArr[i+1];
        }
        orderedArr[counter] = -1;
    }
    
    //Retriving element at (counter-1)th index of arr
    public int top() {
        if(isEmpty())
            return -1;
        int val = arr[counter - 1];
        return val;
    }
    
    //Retriving element at 0th index of orderedArr
    public int getMin() {
        if(isEmpty())
            return -1;
        int val = orderedArr[0];
        return val;
    }

    public boolean isFull(){
        if(counter >= MAX_SIZE)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(counter == 0)
            return true;
        return false;
    }
}
//
// Created by shazmaan on 7/1/2019.
//
#include <bits/stdc++.h>

using namespace std;

#define MAX 3

class SpecialStack {
    int top;
    int counter = 0;
    int minCounter = 0;
public:
    int a[MAX];// Maximum size of Stack
    int size = 0;
    SpecialStack() { //Constructor here
    }
    bool push(int x);
    int pop();
    int peek();
    bool isEmpty();
    bool isFull();
    int getMin();

};

bool SpecialStack::push(int x){
    if(counter<MAX){
        a[counter]=x;
        if((size==0)||x<minCounter){
            minCounter=x;
        }
//        cout<<"counter : "<<counter<<endl;
        top=x;
        counter++; size++;

//        cout<<"Count : "<<counter<<" Size : "<<size<<endl;
        return true;
    }
    cout<<"Stack Overflow"<<endl;
    return false;
    //Your code here

    //Check Stack overflow as well
}
int SpecialStack::pop(){
    int ret =0;
    if(size==0){
        cout<<"Stack Underflow"<<endl;
    }else{
        counter--;
//        cout<<"Pop counter : "<<counter<<endl;
        ret = a[counter];
        top=a[size-2];
        size--;
//        cout<<"TOP : "<<top<<endl;

    }
    return ret;
    //Your code here
    //Check Stack Underflow as well
}

int SpecialStack::peek() {
    if(size==0){
        return 0;
    }else{
        return top;
    }

    //Your code here

    //Check empty condition too

}
bool SpecialStack::isEmpty() {
    if(size==0){
        return true;
    }
    return false;
    //Your code here

}
bool SpecialStack::isFull() {
    if(size==MAX){
        return true;
    }
    return false;
}
int SpecialStack::getMin(){
    return minCounter;
}


// Driver program to test above functions

int main() {

    class SpecialStack s;

    s.push(10);

    s.push(20);

    s.push(30);
    cout<<s.size<<endl;
    cout << s.pop() << " Popped from stack\n";
    s.push(30);
    cout<<s.size<<endl;
    cout<<s.getMin();
//    cout<<s.peek();
//    s.push(30);


    return 0;

}
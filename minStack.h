#include <stack>

using namespace std;
class MinStack{
private:
    stack<int> main_stack;
    stack<int> min_stack;
    int min;
public:
    MinStack();

    void push(int);
    void pop();
    int top();
    int getMin();
};
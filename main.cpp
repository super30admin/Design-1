#include <iostream>
#include "minStack.h"

int main()
{
    MinStack *s = new MinStack();
    s->push(5);
    s->push(9);
    s->push(4);
    s->pop();
    s->push(12);
    s->push(3);
    s->pop();
    cout << s->getMin() << endl;
    delete s;
}
import java.util.Stack;

class SpecialStack extends Stack<Integer>
{
    Stack<Integer> min = new Stack<>();

    void push(int x)
    {
        if(isEmpty() == true)
        {
            super.push(x);
            min.push(x);
        }
        else
        {
            super.push(x);
            int y = min.pop();
            min.push(y);
            if(x < y)
                min.push(x);
            else
                min.push(y);
        }
    }

    public Integer pop()
    {
        int x = super.pop();
        min.pop();
        return x;
    }


    /** SpecialStack's member method to get minimum element from it. */
    int getMin()
    {
        int x = min.pop();
        min.push(x);
        return x;
    }

    /* Driver program to test SpecialStack methods */
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(2);
        s.push(3);
        System.out.println(s.getMin());
        s.push(1);
        System.out.println(s.getMin());
    }
}
class MinStack {
    List<Integer> l;
    int top;
    List<Integer> minList;
    int minListTop;
    public MinStack() {
        l=new ArrayList<Integer>();
        minList=new ArrayList<Integer>();
        top = -1;
        minListTop = -1;
    }

    public void push(int val) {
        if(minList.isEmpty())
        {
            minList.add(val);
            minListTop++;
        }
        else
        {
            if(val<=minList.get(minListTop))
            {
                minList.add(val);
                minListTop++;
            }
        }
        l.add(val);
        top++;
    }

    public boolean checkForEquality(int x, int y) {
        return (x ^ y) == 0;
    }

    public void pop() {
        if(l.isEmpty())
            return;

        if(checkForEquality(minList.get(minListTop),l.get(top)))
        {
            minList.remove(minListTop);
            minListTop--;
        }
        l.remove(top);
        top--;

    }

    public int top() {
        return l.get(top);
    }

    public int getMin() {
        return minList.get(minListTop);
    }
}
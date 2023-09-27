// T.C -> O(1)
// S.C -> O(N)

// Does it pass LC: No
// I have passed 28/31 test case and I am having problem when integer goes out of range

public class DesignMinStack {
    int cnt;
    int[] arr;
    int[] minUntilNow;

    public DesignMinStack() {
        cnt = -1;
        arr = new int[1000000];
        minUntilNow = new int[1000000];
    }

    public void push(int val) {
        cnt++;
        arr[cnt] = val;

        if (cnt == 0)
            minUntilNow[cnt] = val;
        else {
            if (val < minUntilNow[cnt - 1])
                minUntilNow[cnt] = val;
            else
                minUntilNow[cnt] = minUntilNow[cnt - 1];

        }

    }

    public void pop() {
        if (cnt > 0)
            cnt--;
    }

    public int top() {
        if (cnt > -1) {
            return arr[cnt];
        } else {
            return -1;
        }

    }

    public int getMin() {
        return minUntilNow[cnt] == Integer.MIN_VALUE ? arr[cnt] : minUntilNow[cnt];
    }
}

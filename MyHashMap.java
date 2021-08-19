public class MyHashMap<Key, Value>
{
    int M = 10;
    Node[] st = new Node[M];
    int size = 0;
    final double capacity = 0.2;
    public static void main(String[] arg)
    {
        MyHashMap<Integer, Integer> obj = new MyHashMap<>();
        obj.put(-11, 2);
        obj.put(4, 80);
        obj.put(24, 34);
        obj.put(20, 10);
        obj.put(28, 11);
        obj.put(40, 987);
        obj.put(400, 765);
        obj.remove(400);
        // int ans = obj.get(-24);
        //int val = obj.get(400);
        // System.out.println("____ANS__::" + ans);
        boolean a = obj.contains(40);
        System.out.println(a + "::____SIZE____::" + obj.size);
//        System.out.println("___" + obj.st[4].toString());
//        for (Node x = obj.st[0]; x != null; x = x.next)
//        {
//            System.out.println("___AS_F_______::" + x.Value);
//        }
    }

    public int hash(Key key)
    {
        return key.hashCode() & Integer.MAX_VALUE % M;
    }

    public void put(Key key, Value value)
    {
        int idx = hash(key);
        System.out.println("___IDX_____::" + idx);
        for (Node x = st[idx]; x != null; x = x.next)
        {
            if (key.equals(x.Key))
            {
                x.Value = value;
                return;
            }
        }
        st[idx] = new Node(key, value, st[idx]);
        size++;
        double loadFactor = (double) size / st.length;
        // System.out.println("___LOAD FACTOR___::" + loadFactor);
        if (loadFactor > capacity)
        {
            rehash();
        }
    }

    public boolean contains(Key key)
    {
        int idx = hash(key);
        for (Node x = st[idx]; x != null; x = x.next)
        {
            if (key.equals(x.Key))
                return true;
        }
        return false;
    }

    public void remove(Key key)
    {
        int idx = hash(key);
        Node pre = new Node(-1, -1, st[idx]);
        for (Node x = pre; x.next != null; x = x.next)
        {
            if (key.equals(x.next.Key))
            {
                pre.next = pre.next.next;
                System.out.println("_____IF--------::" + pre.toString());
                break;
            }
        }
        st[idx] = pre.next;
        size--;
    }

    public Value get(Key key)
    {
        int idx = hash(key);
        for (Node x = st[idx]; x != null; x = x.next)
        {
            if (key.equals(x.Key))
                return (Value) x.Value;
        }
        return null;
    }

    public void rehash()
    {
        System.out.println("___REHASH_____");
        Node[] tmp = st;
        st = new Node[tmp.length * 2];
        size = 0;
        System.out.println("_____ST_________::::" + st.length);
        for (int i = 0; i < tmp.length; i++)
        {
            for (Node x = tmp[i]; x != null; x = x.next)
            {
                put((Key) x.Key, (Value) x.Value);
            }
        }
    }

    private static class Node
    {
        Object Key;
        Object Value;
        Node next;
        public Node(Object Key, Object Value, Node next)
        {
            this.Key = Key;
            this.Value = Value;
            this.next = next;
        }
        public String toString()
        {
            return String.valueOf("[" + Key + "," + Value + "]");
        }
    }
}

namespace Algorithms
{

    public class MyHashSet
    {
        static int MAX_SIZE = 1000000;
        static int ARRAY_SIZE = 100;
        LinkedListHash[] parentList;

        public MyHashSet()
        {
            parentList = new LinkedListHash[ARRAY_SIZE];
            for(int i = 0;i < ARRAY_SIZE; i++)
            {
                parentList[i] = null;
            }
        }

        int getIndex(int key)
        {
            return key % ARRAY_SIZE;
        }

        public void Add(int key)
        {
            int index = getIndex(key);
            LinkedListHash childList = parentList[index];
            if(childList == null)
            {
                LinkedListHash list = new LinkedListHash();
                list.add(key);
                parentList[index] = list;
            }
            else
            {
                if (!childList.Contains(key))
                {
                    childList.add(key);
                }
            }
        }

        public void Remove(int key)
        {
            int index = getIndex(key);
            LinkedListHash chiildList = parentList[index];
            if(chiildList != null)
            {
                chiildList.delete(key);
            }
        }

        public bool Contains(int key)
        {
            int index = getIndex(key);
            LinkedListHash childList = parentList[index];
            bool result = false;
            if(childList != null)
            {
                result =  childList.Contains(key);
            }
            return result;
        }

        public class LinkedListHash
        {
            Node head; // head of linked list 

            /* Linked list node */
            class Node
            {
                public int data;
                public Node next;
                public Node(int d)
                {
                    data = d;
                    next = null;
                }
            }


            public void add(int new_data)
            {
                Node new_node = new Node(new_data);
                new_node.next = head;
                head = new_node;
            }

            public void delete(int key)
            {
                Node temp = head, prev = null;
                if(temp != null && temp.data == key)
                {
                    head = temp.next;
                    return;
                }

                while(temp != null && temp.data == key)
                {
                    prev = temp;
                    temp = temp.next;
                }
                if(temp == null)
                {
                    return;
                }
                prev.next = temp.next;
            }

            public bool Contains(int data)
            {
                Node current = head;
                while (current != null)
                {
                    if(current.data == data)
                    {
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }
        }
    }
}

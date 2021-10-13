public class ListStack implements StackInterface
{
    //Data
    private SinglyLinkedList linkedList = new SinglyLinkedList();
    private int size = 0;

    public ListStack(){}

    public ListStack(ListStack listStack)
    {
        SinglyLinkedList.Node lsPointer = listStack.linkedList.head;
        for(int i=0;i< listStack.size;i++)
        {
            this.push(lsPointer.data);
            lsPointer = lsPointer.next;
            this.size++;
        }
    }

    public boolean equals(ListStack listStack)
    {
        boolean flag = true;
        if(this.size!=listStack.size)
            flag = false;
        else
        {
            int counter =0;
            SinglyLinkedList.Node ls1Pointer = this.linkedList.head;
            SinglyLinkedList.Node ls2Pointer = this.linkedList.head;
            while(flag && counter<this.size)
            {
                if(ls1Pointer.data!= ls2Pointer.data)
                    flag=false;
                ls1Pointer=ls1Pointer.next;
                ls2Pointer=ls2Pointer.next;
            }
        }
        return flag;
    }

    @Override
    public String toString()
    {
        return this.linkedList.toString();
    }

    @Override
    public void push(int value)
    {
        this.size++;
        this.linkedList.append(value);
    }

    @Override
    public int pop()
    {
        if(this.size>0)
        {
            SinglyLinkedList.Node nPointer = this.linkedList.head;
            this.size--;
            for(int i =1;i<this.size();i++)
            {
                System.out.println(nPointer.data);
                nPointer = nPointer.next;
            }
            int temp = nPointer.next.data;
            nPointer.next =null;
            return temp;
        }
        else
            return 0;
    }

    @Override
    public int peek()
    {
        if(this.size>0)
        {
            SinglyLinkedList.Node nPointer = this.linkedList.head;
            for(int i =1;i<this.size();i++)
            {
                nPointer = nPointer.next;
            }
            return nPointer.data;
        }
        else
            return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.linkedList= new SinglyLinkedList();
    }

    private class SinglyLinkedList
    {
        private class Node
        {
            private int data;
            private Node next;

            public Node(int data)
            {
                this.data = data;
                this.next = null;
            }
        }

        public Node head = null;

        //-------------------------------------------------------------
        public void append(int data)
        {
            // create a new node
            Node newNode = new Node(data);

            // check if the list is empty
            if (head == null)
            {
                head = newNode;
            }
            else
            {
                Node p = head;
                // traverse the list until p refers to the last node
                while (p.next != null)
                    p = p.next;
                p.next = newNode;
            }
        }

        //-------------------------------------------------------------
        public boolean equals(Object obj)
        {
            //...

            return false;
        }

        //-------------------------------------------------------------
        public String toString()
        {
            String str = "{";
            Node curr = head;
            while (curr != null)
            {
                str += (curr == head ? "" : ",") + curr.data;
                curr = curr.next;
            }
            str += "}";
            return str;
        }

    }
}

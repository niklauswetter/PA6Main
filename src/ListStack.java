public class ListStack implements StackInterface
{
    //Data
    private SinglyLinkedList linkedList = new SinglyLinkedList();

    public ListStack(){}

    public ListStack(ListStack listStack)
    {
        if(!listStack.isEmpty())
        {
            SinglyLinkedList.Node tNode = listStack.linkedList.head;
            this.push(tNode.data);
            while(tNode.next!=null)
            {
                tNode=tNode.next;
                this.push(tNode.data);
            }
        }
    }

    public boolean equals(ListStack listStack)
    {
        boolean flag = true;
        if(this.size()!=listStack.size())
            flag=false;
        else
        {
            if(this.isEmpty())
                return flag;
            SinglyLinkedList.Node nP1 = this.linkedList.head;
            SinglyLinkedList.Node nP2 = listStack.linkedList.head;
            while(nP1.next!=null)
            {
                if(nP1.data!= nP2.data)
                    return false;
                nP1=nP1.next;
                nP2=nP2.next;
                //Check for the last one
                if(nP1.next==null)
                    flag = nP1.data == nP2.data;
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
        this.linkedList.append(value);
    }

    @Override
    public int pop()
    {
        int temp = -1;
        if(!this.isEmpty())
        {
            SinglyLinkedList.Node tNode = this.linkedList.head;
            temp = tNode.data;
            while(tNode.next!=null)
            {
                temp=tNode.next.data;
                tNode=tNode.next;
                if(tNode.next.next==null)
                    tNode.next=null;
            }
        }
        return temp;
    }

    @Override
    public int peek()
    {
        int temp = -1;
        if(!this.isEmpty())
        {
            SinglyLinkedList.Node tNode = this.linkedList.head;
            temp = tNode.data;
            while(tNode.next!=null)
            {
                temp=tNode.next.data;
                tNode=tNode.next;
            }
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.head == null;
    }

    @Override
    public int size() {
        int counter = 0;
        if(!this.isEmpty())
        {
            counter++;
            SinglyLinkedList.Node tNode = this.linkedList.head;
            while(tNode.next!=null) {
                counter++;
                tNode=tNode.next;
            }
        }
        return counter;
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

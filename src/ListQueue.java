public class ListQueue implements QueueInterface
{
    //Data
    private SinglyLinkedList linkedList = new SinglyLinkedList();

    public ListQueue(){}

    public ListQueue(ListQueue listQueue)
    {
        if(!listQueue.isEmpty())
        {
            SinglyLinkedList.Node tNode = listQueue.linkedList.head;
            this.enqueue(tNode.data);
            while(tNode.next!=null)
            {
                tNode=tNode.next;
                this.enqueue(tNode.data);
            }
        }
    }

    public boolean equals(ListQueue listQueue)
    {
        boolean flag = true;
        if(this.size()!=listQueue.size())
            flag=false;
        else
        {
            if(this.isEmpty())
                return flag;
            SinglyLinkedList.Node nP1 = this.linkedList.head;
            SinglyLinkedList.Node nP2 = listQueue.linkedList.head;
            while(nP1.data!=nP2.data)
                return false;
            nP1=nP1.next;
            nP2= nP2.next;
            if(nP1.next==null)
                flag = nP1.data == nP2.data;
        }
        return flag;
    }

    @Override
    public String toString() { return this.linkedList.toString();}

    @Override
    public void enqueue(int value) {
        this.linkedList.append(value);
    }

    @Override
    public int dequeue() {
        int temp = -1;
        if(!this.isEmpty())
        {
            temp = this.linkedList.head.data;
            this.linkedList.head=this.linkedList.head.next;
        }
        return temp;
    }

    @Override
    public int peek()
    {
        int temp = -1;
        if(!this.isEmpty())
            temp = this.linkedList.head.data;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.head==null;
    }

    @Override
    public int size() {
        int counter =0;
        if(!this.isEmpty())
        {
            counter++;
            SinglyLinkedList.Node tNode = this.linkedList.head;
            while(tNode.next!=null)
            {
                counter++;
                tNode=tNode.next;
            }
        }
        return counter;
    }

    @Override
    public void clear() {
        this.linkedList = new SinglyLinkedList();
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


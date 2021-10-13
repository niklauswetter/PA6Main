public class Main {

    public static void main(String[] args)
    {
        ListQueue listQueue1 = new ListQueue();

        for(int i = 0; i<8;i++)
        {
            listQueue1.enqueue(i);
        }

        System.out.println(listQueue1);
        ListQueue listQueue2 = new ListQueue(listQueue1);
        System.out.println(listQueue1.equals(listQueue2));
        listQueue1.dequeue();
        System.out.println(listQueue1);
        System.out.println(listQueue2);
        System.out.println(listQueue1.peek());
        for (int i = 0;i<9;i++)
            System.out.println(listQueue2.dequeue());
        System.out.println(listQueue2.peek());
    }
}

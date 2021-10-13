public class Main {

    public static void main(String[] args)
    {
        ListStack listStack = new ListStack();
        System.out.println(listStack);
        for(int i = 0;i<25;i++)
            listStack.push(i);
        ListStack listStack2 = new ListStack(listStack);
        System.out.println(listStack.equals(listStack2));
        System.out.println(listStack.size());
        System.out.println(listStack.pop());
        System.out.println(listStack);
        for(int i =0;i<10;i++)
            listStack2.pop();
        System.out.println(listStack2);
        System.out.println(listStack.equals(listStack2));
        listStack.clear();
        System.out.println(listStack);
    }
}

public class ArrayStack implements StackInterface
{
    //Data
    private int[] dynamicArray = new int[DEFAULT_SIZE];
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    //Methods

    /**
     * YOU CAN ACCESS PRIVATE VALUES INSIDE CLASSES GENIUS
     *
     */

    @Override
    public void push(int value) {

    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }


    //Private methods
    private void resize()
    {
        this.size*=2;
        int temp[] = new int[this.size];
        for(int i = 0; i<this.dynamicArray.length;i++)
            temp[i] = this.dynamicArray[i];
        this.dynamicArray=temp;
    }

}

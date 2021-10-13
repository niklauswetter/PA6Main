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

    public ArrayStack()
    {}

    public ArrayStack(ArrayStack arrayStack)
    {
        while(arrayStack.size>this.dynamicArray.length)
        {
            this.resize();
        }
        this.size=arrayStack.size;
        for(int i = 0; i< arrayStack.size;i++){
            this.dynamicArray[i] = arrayStack.dynamicArray[i];
        }
    }

    public boolean equals(ArrayStack arrayStack)
    {
        boolean flag = true;
        int counter = 0;
        if(this.size!=arrayStack.size)
            flag=false;
        else
        {
            while (flag && counter<this.size)
            {
                if(this.dynamicArray[counter] != arrayStack.dynamicArray[counter])
                    flag = false;
                counter++;
            }
        }
        return flag;
    }

    @Override
    public String toString()
    {
        String temp ="";
        if(this.size==0)
            temp="{}";
        else
        {
            temp+="{";
            for(int i = 0; i<this.size;i++)
            {
                if(i<this.size-1)
                    temp+=this.dynamicArray[i]+",";
                else
                    temp+=this.dynamicArray[i];
            }
            temp+="}";
        }
        return temp;
    }

    @Override
    public void push(int value)
    {
        this.dynamicArray[this.size]=value;
        this.size++;
        if(this.size+1==this.dynamicArray.length)
            this.resize();
    }

    @Override
    public int pop()
    {
        int temp = -1;
        if(this.size>0)
        {
            temp = this.dynamicArray[this.size];
            this.size--;
            this.dynamicArray[this.size] = 0;
        }
        return temp;
    }

    @Override
    public int peek()
    {
        int temp = -1;
        if(this.size>0)
            temp = this.dynamicArray[this.size-1];
        return temp;
    }

    @Override
    public boolean isEmpty()
    {
        return this.size==0;
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public void clear()
    {
        this.size=0;
        this.dynamicArray = new int[DEFAULT_SIZE];
    }


    //Private methods
    private void resize()
    {
        int index = this.dynamicArray.length*2;
        int temp[] = new int[index];
        for(int i = 0; i<this.dynamicArray.length;i++)
            temp[i] = this.dynamicArray[i];
        this.dynamicArray=temp;
    }

}

public class ArrayQueue implements QueueInterface
{
    //Data
    private int[] dynamicArray = new int[DEFAULT_SIZE];
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public ArrayQueue(){}

    public ArrayQueue(ArrayQueue arrayQueue)
    {
        while(arrayQueue.size>this.dynamicArray.length)
        {
            this.resize();
        }
        this.size=arrayQueue.size;
        for(int i = 0; i< arrayQueue.size;i++){
            this.dynamicArray[i] = arrayQueue.dynamicArray[i];
        }
    }

    public boolean equals(ArrayQueue arrayQueue)
    {
        boolean flag = true;
        int counter = 0;
        if(this.size!=arrayQueue.size)
            flag=false;
        else
        {
            while (flag && counter<this.size)
            {
                if(this.dynamicArray[counter] != arrayQueue.dynamicArray[counter])
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
    public void enqueue(int value)
    {
        this.dynamicArray[this.size]=value;
        this.size++;
        if(this.size+1==this.dynamicArray.length)
            this.resize();
    }

    @Override
    public int dequeue()
    {
        if(this.size>0)
        {
            int result = this.dynamicArray[0];
            for(int i = 1;i<this.size;i++)
                this.dynamicArray[i-1]=this.dynamicArray[i];
            this.size--;
            this.dynamicArray[this.size]=0;
            return result;
        }
        else
            return 0;
    }

    @Override
    public int peek()
    {
        int temp = 0;
        if(this.size>0)
            temp = this.dynamicArray[0];
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

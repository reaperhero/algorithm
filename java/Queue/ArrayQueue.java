public class ArrayQueue<T> {

    private T[] queue;//队列数组
    private int head = 0;//头下标
    private int tail = 0;//尾下标
    private int count = 0;//元素个数

    public ArrayQueue() {
        queue = (T[]) new Object[10];
        this.head = 0;//头下标为零
        this.tail = 0;
        this.count = 0;
    }

    public ArrayQueue(int size) {
        queue = (T[]) new Object[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    //入队
    public boolean inQueue(T t) {
        if (count == queue.length)
            return false;
        queue[tail++ % (queue.length)] = t;//如果不为空就放入下一个
        count++;
        return true;
    }

    //出队
    public T outQueue() {
        if (count == 0)//如果是空的那就不能再出栈了
            return null;
        count--;
        return queue[head++ % (queue.length)];
    }

    //查队头
    public T showHead() {
        if (count == 0) return null;
        return queue[head];
    }

    //判满
    public boolean isFull() {
        return count == queue.length;
    }

    //判空
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(10);
		for(int i=0;!arrayQueue.isFull();i++)
		{
			arrayQueue.inQueue(i);
		}

        System.out.println("队满？" + arrayQueue.isFull());
        for (int i = 0; !arrayQueue.isEmpty(); i++) {
            System.out.println(arrayQueue.showHead() + "  " + arrayQueue.outQueue());
        }
    }

}

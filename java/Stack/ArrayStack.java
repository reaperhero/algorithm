
public  class ArrayStack{
    private int[] arrInt;//内置数组
    private int top;//栈顶指针

    public ArrayStack(int size){
        this.arrInt = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return -1 == top;
    }

    public boolean isFull(){
        return arrInt.length -1 == top;
    }

    public void push(int item){
        if(isFull()){
            throw new RuntimeException("栈已满");
        }
        arrInt[++top] = item;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return arrInt[top--];
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);
        System.out.println("isEmpty: "+stack.isEmpty());
        for(int i = 0;i<10;i++){
            stack.push(i);
        }
        System.out.println("isFull: "+stack.isFull());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
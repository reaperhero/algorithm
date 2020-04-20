
public class SingleLinkQueue {
    public static void main(String[] args) {
        LinkQueue<Integer> linkQueue = new LinkQueue<Integer>();
        //入队5个
        for (int i = 0; i < 5; i++) {
            linkQueue.inQueue(i);
        }
        //出栈测试
        for (int i = 0; !linkQueue.isEmpty(); i++) {
            System.out.println(linkQueue.peek() + "  " + linkQueue.outQueue());
        }
//        for (int i = 0; i < 8; i++) {
//            System.out.println(linkQueue.peek() + "  " + linkQueue.outQueue());
//        }
    }
}


class LinkQueue<T> {
    class Node<T> {
        private T data;//数据域
        private Node<T> next;//引用域

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public void setNext(Node<T> t) {
            this.next = t;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getNext() {
            return this.next;
        }
    }

    private Node<T> head;//队头
    private Node<T> tail;//队尾

    public LinkQueue() {
        this.head = null;
        this.tail = null;
    }

    //入队
    public boolean inQueue(T t) {
        Node<T> p = new Node<T>(t);//生成一个结点
        if (head == null)//如果头等于空
        {
            head = p;//头引用指向这个结点
            tail = p;//尾引用指向这个结点
        } else {
            tail.next = p;//插入尾部
            tail = p;//尾引用指向新的尾结点
        }
        return true;
    }

    //dream it possible
    //出队
    public T outQueue() {
        if (head == null) return null;
        else {
            T t = head.getData();//取下对队头
            head = head.next;//头引用后移
            return t;
        }

    }

    //查队头
    public T peek() {
        if (head == null) return null;
        else
            return head.getData();
    }

    //判空
    public boolean isEmpty() {
        return head == null;
    }
}
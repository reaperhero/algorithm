public class SingleLinkStack {
    private LinkNode link;

    SingleLinkStack() {
        link = new LinkNode();
    }

    // 判断是否为空
    public boolean isEmpty() {
        return link.isEmpty();
    }

    // 入栈
    private void push(Object obj) {
        Node node = new Node(obj);
        link.addHNode(node);
    }

    // 出栈
    private Object pop() {
        return link.sysHnode();
    }

    // 出栈，但不删除头结点
    private Object peek() {
        return link.sysHNode();
    }

    // 获取栈大小
    private int size() {
        return link.getSize();
    }

    public static void main(String[] args) {
        SingleLinkStack stack = new SingleLinkStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println("栈的大小:" + stack.size());
        System.out.println("栈顶元素:" + stack.peek());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "-->");
        }

    }

}

class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }
}

class LinkNode {
    private Node head;
    private int size;

    public LinkNode() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    // 头插入
    public void addHNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    // 输出头结点，不删除
    public Object sysHNode() {
        if (head == null) {
            return null;
        }
        Object obj = head.data;
        return obj;
    }

    // 输出头结点,并删除
    public Object sysHnode() {
        if (head == null) {
            return null;
        }
        Object obj = head.data;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        size--;
        return obj;
    }

    public int getSize() {
        return size;
    }
}
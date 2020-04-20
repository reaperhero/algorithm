
public class SingleWayLinkedList{
    public static void main(String[] args) {
        String x;
        LinkedList<String> list=new LinkedList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        for(int i=0;i<list.size();i++){
            System.out.println("输出第"+i+":"+list.GetE(i));

        }
        System.out.println();
        System.out.println("测试删除");
        x=list.Delete(0);
        System.out.println("删除了"+x);
        for(int i=0;i<=list.size();i++){
            System.out.println("输出第"+i+":"+list.GetE(i));

        }
        System.out.println("测试修改");
        list.Renew("Yimi", 2);
        for(int i=1;i<=list.size();i++){
            System.out.println("输出第"+i+":"+list.GetE(i));

        }
        System.out.println();
        System.out.println("测试查找");
        x=list.GetE(3);
        System.out.println("x="+x);

    }
}



class LinkedList<E> {
    // 声明头节点
    private Node<E> head;
    // 声明 尾节点
    private Node<E> last;
    // 链表的大小
    private int size;
    private int modcount;// 计算修改表的次数

    public LinkedList() {
        head = new Node<E>();// 实例化头节点
        last = head;
    }

    /**
     * 获取单链表中存储的元素总数
     *
     * @return 返回size属性
     */
    public int size() {
        return size;
    }

    /**
     * 获取指定索引位置的节点对象
     *
     * @param index索引位置
     * @return 返回获取到的节点对象
     */
    private Node<E> Select(int index) {
        Node<E> node = head.getNext();// 将头节点的下一个节点赋给node
        for (int i = 0; i < index; i++) {
            node = node.getNext();// 获取node的下一个节点
        }
        return node;
    }

    /**
     * 找到指定节点的数据域，并返回
     *
     * @param index 索引
     * @return 节点的数据域
     */

    public E GetE(int index) {
        if (index < 0 || index > size - 1)
            return null;
        Node<E> node = Select(index); // 查找指定索引位置的节点对象
        return node.getE();// 获取节点中的数据域元素并返回
    }

    /**
     * 增
     *
     * @param e要添加的元素
     */
    public void add(E e) {
        Node<E> node = new Node<E>(e);// 以e实例化一个节点
        last.setNext(node);// 往尾节点后加节点
        last = node;// 该节点设为最后一个节点
        size++;
    }

    /**
     * 删除指定的节点e,并返回e
     *
     * @param i为索引号
     * @return 返回删除的元素e
     */
    public E Delete(int index) {

        if (index < 0 || index > size)
            return null;
        if (index == 0) {// 当索引为1时，令头节点的下一个节点为头节点
            Node<E> node2 = head.getNext();
            head.setNext(node2.getNext());
            size--;
            return node2.getE();
        }
        // 获取要删除节点的前一个节点
        Node<E> bNode = Select(index - 1);
        // 获取要删除的节点
        Node<E> Node = bNode.getNext();
        // 获取要删除节点的后一个节点
        Node<E> nNode = Node.getNext();

        // 先建立删除节点的前一个节点和删除节点的后一个节点的关系
        bNode.setNext(nNode);
        // 清除dNode的下一个节点
        Node.setNext(null);
        size--;// 计数器减1
        return Node.getE();// 返回删除节点中的数据域
    }

    /**
     * 修改指点位置的数据域
     *
     * @param x新内容
     * @param index索引位置
     * @return 返回修改后的数据
     */
    public E Renew(E x, int index) {
        if (index < 0 || index > size || size == 0)
            return null;
        Node<E> xnode = new Node<E>(x);// 获取一个新节点
        Node<E> node = Select(index);
        node.setE(xnode.getE());
        return node.getE();
    }


    // 测试

}


class Node<E> {
    private Node<E> next;// 指向下一个节点
    private E e;// 数据域

    public Node() {

    }

    public Node(E e) {
        this.e = e;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

}

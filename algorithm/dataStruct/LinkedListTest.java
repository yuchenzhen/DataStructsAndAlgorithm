import java.util.Stack;

public class LinkedListTest {
    private Node headNode;

    public LinkedListTest() {
        Node head = new Node(null, null);
        this.headNode = head;
    }

    public LinkedListTest(Node firstNode) {
        Node head = new Node(null, firstNode);
        this.headNode = head;
    }
    public Node getHeadNode () {
        return this.headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    // insert
    public void insert (int index, Object element) {
        int i = 0;
        Node tempNode = this.headNode;
        while ( i < index) {
            tempNode = tempNode.next;
            i++;
        }
        Node newNextNode = tempNode.next;
        Node insertNode = new Node(element, newNextNode);
        tempNode.setNext(insertNode);
    }

    // delete
    public void delete (int index) {
        int i = 0;
        Node tempNode = this.headNode;
        while (i < index) {
            tempNode = tempNode.getNext();
            i++;
        }
        Node newNextNode = tempNode.getNext();
        tempNode.setNext(newNextNode);
    }

    // find
    public Node find(int index) {
        int i = 0;
        Node tempNode = this.headNode;
        while (i < index) {
            tempNode = tempNode.getNext();
            i++;
        }
        return tempNode;
    }

    // length
    public int length () {
        Node tempNode = this.headNode.getNext();
        int i = 0;
        while (tempNode.getNext() != null) {
            i++;
            tempNode = tempNode.getNext();
        }
        return i+1;
    }

    // 遍历链表，打印出所有节点的方法
    public void showAll() {
        Node tempNode = headNode.next;
        while (tempNode.next != null) {
            System.out.println(tempNode.element);
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.element);
    }

    public void reversePrint () {
        Stack stack = new Stack();
        Node tempNode = headNode.next;
        stack.push(tempNode.element);
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            stack.push(tempNode.element);
        }
        while (stack.size() != 0) {
            Object node = stack.pop();
            System.out.println(node);
        }
    }

    //    2、查找单向链表中的倒数第k个节点
    public Object findLastK (int k) {
        int i1 = 0;
        int i2 = i1 + k;
        int length = this.length();

        if (i2 > length) {
            throw new Error("k 大于链表长度");
        }

        Node tempNode = headNode;
        while (i2 < length) {
            tempNode = tempNode.next;
            i1++;
            i2++;
        }

        System.out.println("findLastKth: "+ tempNode.element);
        return tempNode.element;
    }

    public void reverse () {
        Node tempNode = headNode.next;
        Node newReverseNode = new Node(null, null);
        Node nextNode;
        while (tempNode.next != null) {
            // 把tempNode在旧链表中的下一个节点暂存起来
            nextNode = tempNode.getNext();
            // 设置tempNode在新链表中作为头节点的next值
            tempNode.setNext(newReverseNode);
            // 更新newReverseNode的值，下一次循环需要用
            newReverseNode = tempNode;
            // 更新头节点
            this.setHeadNode(newReverseNode);
            // tempNode往后移动一个位置
            tempNode = nextNode;
        }
        tempNode.setNext(newReverseNode);
        // 然后把它放到新链表的第一个节点的位置
        this.setHeadNode(tempNode);
        // 新建一个新链表的头节点
        newReverseNode = new Node(null, tempNode);
        this.setHeadNode(newReverseNode);

        this.showAll();
    }
    // A -> B -> C -> D

    public Node orderMerge (LinkedListTest mergeList) {

        if (mergeList == null) {
            return this.headNode;
        }

        // 新链表的第一个有效节点(注意与头节点的区分！)
        Node newHead;
        // temp指针会在两个链表中来回选出较小的节点
        Node temp;

        // 一开始，让temp指针指向head1和head2中较小的数据，得到head节点

        Node head1 = this.getHeadNode().next;
        Node head2 = mergeList.getHeadNode().next;
        if ((int) head1.getElement() < (int) head2.getElement()) {
            newHead = this.headNode;
            temp = head1;
            head1 = head1.getNext();
        } else {
            newHead = head2;
            temp = head2;
            head2 = head2.getNext();
        }

        while (head1 != null && head2 != null) {
            if ((int) head1.getElement() < (int) head2.getElement()) {
                // temp指针的下一个节点对应较小的那个数据
                temp.setNext(head1);
                // temp指针往后移
                temp = temp.getNext();
                // head1也要往后移
                head1 = head1.getNext();
            } else {
                temp.setNext(head2);
                temp = temp.getNext();
                head2 = head2.getNext();
            }
        }

        // 合并剩下的节点，剩下的节点一定是都在同一个链表中
        // 如果head1不为空，说明链表1里面还有节点，链表2已经被遍历完了
        if (head1 != null) {
            temp.setNext(head1);
        }
        if (head2 != null) {
            temp.setNext(head2);
        }
        // 返回新链表的第一个有效节点(注意与头节点的区分！)
        this.setHeadNode(newHead);
        return newHead;
    }


    public static void main (String[] arg) {
        Node firstNode = new Node("originHead", null);
        LinkedListTest myLinkedList = new LinkedListTest(firstNode);

        myLinkedList.insert(0, "欧阳锋");
        myLinkedList.insert(1, "欧阳锋2");
        myLinkedList.insert(2, "欧阳锋3");
        myLinkedList.showAll();

        //    1、从尾到头打印单向链表
        myLinkedList.reversePrint();

        System.out.println("length: " + myLinkedList.length());

        //    2、查找单向链表中的倒数第k个节点
        myLinkedList.findLastK(2);

        System.out.println("============= origin：");
        myLinkedList.showAll();

        System.out.println("============= after reverse：");
        //    3、反转一个单向链表【出现频率较高】
        myLinkedList.reverse();

        System.out.println("============= test 4：");

        LinkedListTest orderList1 = new LinkedListTest();
        LinkedListTest orderList2 = new LinkedListTest();


        orderList1.insert(0, 1);
        orderList1.insert(1, 2);
        orderList1.insert(2, 5);
        orderList1.insert(3, 7);
        orderList1.insert(4, 9);

        orderList2.insert(0, 1 + 2);
        orderList2.insert(1, 2 + 2);
        orderList2.insert(2, 5 + 2);
        orderList2.insert(3, 7 + 2);
        orderList2.insert(4, 9 + 2);

        System.out.println("============= test 4： orderList 1");
        System.out.println("this headnode is " + orderList1.getHeadNode().element);
        orderList1.showAll();
        System.out.println("============= test 4： orderList 2");
        orderList2.showAll();

        System.out.println("============= test 4： orderList 1 new");
        Node neworderList1 = orderList1.orderMerge(orderList2);
        System.out.println("neworderList1" + neworderList1.getElement());
        orderList1.showAll();
    }
    //    1、从尾到头打印单向链表
    //    2、查找单向链表中的倒数第k个节点
    //    3、反转一个单向链表【出现频率较高】
    //    4、合并两个有序的单向链表，合并之后的链表依然有序【出现频率较高】
    //    5、找出两个单向链表相交的第一个公共节点
}

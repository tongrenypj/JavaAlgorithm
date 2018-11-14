package 反转单链表;

public class Main {

    public static class Node{

        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }


    }
    public static void main(String[] args){

        Node head = new Node(1);
        Node temp = head;
        for (int i = 2 ;i<=5; i++){
            Node node = new Node(i);
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        temp = head;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;

        }
        //反转链表

        //当前遍历结点
        head = head;
        //存储遍历当前结点的下一个结点
        Node next = null;
        //存储遍历当前结点的上一个结点
        Node pre = null;
        while (head!=null){
            //存储当前结点的下一个结点
            next = head.next;
            head.next = pre;
            //更新前一个结点
            pre = head;
            //更新当前结点
            head = next;
        }

        temp = pre;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;

        }
    }
}

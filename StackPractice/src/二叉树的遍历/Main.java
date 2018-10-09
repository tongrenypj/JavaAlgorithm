package 二叉树的遍历;

import java.util.Stack;

public class Main {

    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }

    public static void midOrderRecur(Node head){
        if(head == null){
            return;
        }

        midOrderRecur(head.left);
        System.out.println(head.value);
        midOrderRecur(head.right);

    }
    public static void postOrderRecur(Node head){
        if(head == null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);

    }

    public static void main(String[] args){



    }
    public static void preOrder(Node head){

        Stack<Node> stack = new Stack<Node>();
        if(head == null){
            return;
        }
        stack.push(head);

        while(!stack.empty()){

            head = stack.pop();
            System.out.println(head.value);
            if(head.right !=null) {
                stack.push(head.right);
            }
            if(head.left !=null) {
                stack.push(head.left);
            }

        }

    }

    //较难理解
    public static void midOrder(Node head){
        Stack<Node> stack = new Stack<Node>();
        if(head == null){
            return;
        }


        while(!stack.empty()|| head!= null){

            if(head!=null){
                stack.push(head);
                head = head.left;
            }else {

                head = stack.pop();
                System.out.println(head.value);
                head = head.right;

            }

        }
    }

}

class Node{
    public int value;
    public Node left;
    public Node right;
    Node(int data){
        this.value = data;

    }

}

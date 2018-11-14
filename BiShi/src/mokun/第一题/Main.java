package mokun.第一题;

import java.util.Scanner;
//链表k翻转
public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val =x;
            next =null;
        }
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n ; i++) {
            a[i] = scanner.nextInt();
        }
        ListNode head = new ListNode(a[0]);
        ListNode p = head;
        for (int i = 1; i < n ; i++) {

            ListNode node = new ListNode(a[i]);
            p.next =node;
            p=node;

        }
        int k = scanner.nextInt();
        print1(head);
        ListNode node1 = Reverse_k(head,k);
        print1(node1);



    }

    public static ListNode Reverse_k(ListNode head, int k){
        ListNode k_head = head;
        int count = 0;
        while (k_head!=null&&count!=k){
            k_head = k_head.next;
            count++;
        }
        if(count == k){
            ListNode pre = Reverse_k(k_head,k);
            while (count>0){
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                count --;

            }
            head = pre;

        }
        return head;



    }
    public static void print1(ListNode head){
        while (head!=null){

            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();

    }


}

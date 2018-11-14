package 华为;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHe {
    static class Node {
        char calc;
        int index;
        int b;
        boolean isCount = false;
        Node next;

    }

    private static Node GetExp(String s) {
        Node tail = new Node();     //  表达式链表的尾指针
        Node head = new Node(); //表达式链表的头指针
        head = tail;
        Pattern p = Pattern.compile("[\\+\\-]{0,1}([\\d]){1,4}(X\\^)([\\d]){1,4}");
        Matcher m = p.matcher(s);
        Pattern p1 = Pattern.compile("([\\d]){1,4}");
        Matcher m1;

        while (m.find()) {
            Node tmp = new Node();
            String s1 = m.group();
            if (s1.startsWith("+") || s1.startsWith("-"))
                tmp.calc = s1.charAt(0);
            else
                tmp.calc = '+';
            m1 = p1.matcher(s1);

            if (m1.find()) {
                tmp.b = Integer.parseInt(tmp.calc + m1.group());

                m1.find();

                tmp.index = Integer.parseInt(m1.group());
            }

            tail.next = tmp;
            tail = tmp;
        }
        return head;
    }

    private static String GetExp(Node ResultHead) {
        StringBuffer resultString = new StringBuffer();
        ResultHead = ResultHead.next;
        while (ResultHead != null) {
//          如果表达式的系数大于0而且又不是第一个单项表达式，则需要在其前面添加一个“+”
            if (ResultHead.b >= 0 && resultString.length() != 0)
                resultString.append("+");
            resultString.append(ResultHead.b);
            resultString.append("X^");
            resultString.append(ResultHead.index);
            ResultHead = ResultHead.next;
        }
        return resultString + "";
    }

    private static String calculate(Node es) {
//      异常输入判断
        if (es == null && es.next != null)
            return null;
        es = es.next;
        Node ResultHead = new Node();//新链表的头指针
//      遍历查看尚未被计算过的单项表达式节点
        while (es != null && es.isCount == false) {
            Node resultTmp = new Node();
            int index = es.index;
            int ratio = es.b;
            es.isCount = true;
//          子循环里面使用一个新的指针，避免两个指针的干扰
            Node es1 = es.next;
            while (es1 != null) {
//              如果找到一个指数相同而且又没有计算过的节点，则进行计算，并将该节点的标记设置为已经计算过
                if (es1.index == index && es1.isCount == false) {
                    ratio += es1.b;
                    es1.isCount = true;
                }
                es1 = es1.next;

            }
            resultTmp.index = index;
            resultTmp.b = ratio;

            InsertList(ResultHead, resultTmp);
            es = es.next;
        }
        return GetExp(ResultHead);
    }


    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String n = scanner.nextLine();
        String s = "-7X^4+5X^6-3X^3+3X^3+1X^0";
        System.out.println(calculate(GetExp(s)));


    }

    private static Node InsertList(Node resultHead, Node tmp) {
        Node r1 = resultHead;
        if (resultHead.next == null)
            resultHead.next = tmp;
        Node resultTail = resultHead.next;
        if (resultTail.next == null) {
            if (tmp.index < resultTail.index) {
                resultHead.next = tmp;

            } else if (tmp.index > resultTail.index) {
                resultHead.next = tmp;
                tmp.next = resultTail;
            } else {
                boolean done = false;
                while (!done) {
                    resultHead = resultHead.next;
                    resultTail = resultTail.next;
                    if (resultTail != null) {
                        if (tmp.index < resultHead.index && tmp.index > resultTail.index) {
                            resultHead.next = tmp;
                            tmp.next = resultTail;
                            done = true;
                        }
                    } else {

                        resultHead.next = tmp;
                        done = true;
                    }
                }
            }

        }
        return r1;

    }
}

package 拼多多.第一题;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] s = a.toCharArray();
        int count[] = new int[26];
        for (int i = 0; i < 26; i++)
            count[i] = 0;
        for (int i = 0; i < s.length; i++)
            count[s[i] - 'a']++;

        int sum = 0;
        for (int i = 0; i < 26; i++)
            sum += count[i] * count[i];

        int k = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                int tmp = sum - count[i] * count[i] - count[j] * count[j] + (count[i] + count[j]) * (count[i] + count[j]);
                if (tmp > k)
                    k = tmp;
            }
        }

        System.out.println(k);

    }
}

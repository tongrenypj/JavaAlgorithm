package 拼多多.第三题;

public class Main {

//    #include<iostream>
//
//    using namespace std;
//
//    int main()
//    {
//        int n, k;
//        cin >> n >> k;
//        if (k > (n*n / 4))
//        {
//            cout << '-' << endl;
//            return 0;
//        }
//
//        char* s = new char[n];
//        int c = 0;
//        int r = k;
//
//        for (int i = n - 1;i >= 0;i--)
//        {
//            if (r == 0)
//            {
//                s[i] = 'B';
//                continue;
//            }
//
//            c++;
//            if (r < c)
//            {
//                for (int j = 0;j < r;j++)
//                {
//                    s[i] = s[i + 1];
//                    s[i + 1] = 'B';
//                    i--;
//                }
//                r = 0;
//                continue;
//            }
//            else
//            {
//                s[i] = 'B';
//                i--;
//                s[i] = 'A';
//                r -= c;
//            }
//        }
//
//        for (int i = 0;i < n;i++)
//        {
//            cout << s[i];
//        }
//        cout << endl;
//
//        return 0;
//    }
}

import java.util.Scanner;

public class B1476 {
    // 날짜 계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt(); // 1 <= E <= 15
        int S = sc.nextInt(); // 1 <= S <= 28
        int M = sc.nextInt(); // 1 <= M <= 19
        int year = 1;

        int e = 1, s = 1, m = 1;
        while (true) {
            if (E == e && S == s && M == m) {
                System.out.println(year);
                break;
            }
            else {
                e += 1;
                s += 1;
                m += 1;
                year += 1;

                if (e > 15) // E,S,M의 범위가 넘어가는 경우 1이 됨
                    e = 1;
                if (s > 28)
                    s = 1;
                if (m > 19)
                    m = 1;
            }
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class B1246 {
    // 온라인 판매
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 달걀 갯수
        int m = sc.nextInt(); // 잠재 고객수
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.sort(p); // 금액 순으로 정렬

        int profit_buf, price = 0, profit = 0;
        for (int i=0; i<m; i++){
            if (m-i > n) { // 높은 가격을 제시한 고객이 달걀 갯수보다 많을 경우
                profit_buf = p[i] * n;
            }
            else {
                profit_buf = p[i] * (m - i);
            }
            if (profit_buf > profit) { // 버퍼의 값과 비교하며 갱신
                price = p[i];
                profit = profit_buf;
            }
        }
        System.out.println(price + " " + profit);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class B1531 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[100][100];

        for (int i = 0; i < n; i++){
            int x1 = sc.nextInt()-1; // 두 모서리의 좌표도 포함되므로
            int y1 = sc.nextInt()-1;
            int x2 = sc.nextInt()-1;
            int y2 = sc.nextInt()-1;
            for (int j = y1; j <= y2; j++){
                for (int k = x1; k <= x2; k++){
                    arr[j][k] += 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (arr[i][j] > m)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}

import java.util.Scanner;

public class B1010 {
    // 다리 놓기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long res = 1;
            for (int j=m; j>n; j--){
                res *= j;
                res /= m-j+1;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}

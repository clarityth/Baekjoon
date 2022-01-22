import java.util.Scanner;

public class B7568 {
    // 덩치
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[][] arr = new int[2][N];
        for (int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[0][i] = x;
            arr[1][i] = y;
        }
        int [] rank = new int[N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) {
                if (arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j])
                    rank[i]++;

            }
            sb.append(rank[i]+1).append(" ");
        }
        System.out.println(sb);
    }
}

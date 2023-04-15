// 덩치
import java.util.Arrays;
import java.util.Scanner;

public class B7568 {
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
    Arrays.fill(rank,1);
    for (int i=0; i<N; i++){
      for (int j=0; j<N; j++) {
        if (arr[0][i] < arr[0][j] && arr[1][i] < arr[1][j]) // 덩치가 큰사람의 수만큼 증가
          rank[i]++;

      }
      sb.append(rank[i]).append(" ");
    }
    System.out.println(sb);
  }
}

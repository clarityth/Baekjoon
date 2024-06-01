//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;
public class B2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] minSum = new int[N][3];
        int[][] maxSum = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minSum[0][0] = maxSum[0][0] = arr[0][0];
        minSum[0][1] = maxSum[0][1] = arr[0][1];
        minSum[0][2] = maxSum[0][2] = arr[0][2];
        // 1[0][0]                2[0][1]                       3[0][2]
        // 4[1][0]([0][0],[0][1]) 5[1][1]([0][0],[0][1],[0][2]) 6[1][2]([0][1],[0][2])
        // 4[2][0]([1][0],[1][1]) 9[2][1]([1][0],[1][1],[1][2]) 0[2][2]([1][1],[1][2])
        for (int i = 1; i < N; i++) {
                minSum[i][0] = Math.min(minSum[i - 1][0], minSum[i - 1][1]) + arr[i][0];
                maxSum[i][0] = Math.max(maxSum[i - 1][0], maxSum[i - 1][1]) + arr[i][0];

                minSum[i][1] = Math.min(Math.min(minSum[i - 1][0], minSum[i - 1][1]), minSum[i - 1][2]) + arr[i][1];
                maxSum[i][1] = Math.max(Math.max(maxSum[i - 1][0], maxSum[i - 1][1]), maxSum[i - 1][2]) + arr[i][1];

                minSum[i][2] = Math.min(minSum[i - 1][1], minSum[i - 1][2]) + arr[i][2];
                maxSum[i][2] = Math.max(maxSum[i - 1][1], maxSum[i - 1][2]) + arr[i][2];
        }
        bw.flush();
        bw.write(Math.max(Math.max(maxSum[N - 1][0], maxSum[N - 1][1]), maxSum[N - 1][2]) + " " + Math.min(Math.min(minSum[N - 1][0], minSum[N - 1][1]), minSum[N - 1][2]));
        br.close();
        bw.close();
    }
}
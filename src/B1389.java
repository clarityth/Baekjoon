// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.StringTokenizer;
// import java.lang.Math;

// public class Main {
//   public static int[][] connection;
//   public static int N, M;

//   public static void floyd() {
//     for (int k = 1; k <= N; k++) {
//       for (int i = 1; i <= N; i++) {
//         for (int j = 1; j <= N; j++) {
//           if (i == j)
//             continue;
//           else if (connection[i][k] != 0 && connection[k][i] != 0) {
//             if (connection[i][j] == 0) {
//               connection[i][j] = connection[i][k] + connection[k][j];
//             } else {
//               connection[i][j] = Math.min(connection[i][j], connection[i][k] + connection[k][j]);
//             }
//           }
//         }
//       }
//     }
//   }

//   public static void main(String[] args) throws IOException {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st = new StringTokenizer(br.readLine());
//     N = Integer.parseInt(st.nextToken());
//     M = Integer.parseInt(st.nextToken());
//     connection = new int[N + 1][N + 1];
//     for (int i = 0; i < M; i++) {
//       st = new StringTokenizer(br.readLine());
//       int A = Integer.parseInt(st.nextToken());
//       int B = Integer.parseInt(st.nextToken());
//       connection[A][B] = connection[B][A] = 1;
//     }
//     floyd();
//     int min = 2147483647;
//     int personNum = 0;
//     for(int i=1; i<=N; i++){
//       int sum = 0;
//       for(int j=1; j<=N; j++){
//         sum += connection[i][j];
//       }
//       if (sum < min){
//         min = sum;
//         personNum = i;
//       }
//     }
//     System.out.println(personNum);
//   }
// }
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    static final int INF = 987654321;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
 
        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;
 
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        
        // 간선의 방향이 양방향이어야 함.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            arr[x][y] = arr[y][x] = 1;
        }
 
        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 최단경로 초기화
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
 
        int res = INF;
        int idx = -1;
 
        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }
 
            if (res > total) {
                res = total;
                idx = i;
            }
        }
 
        bw.write(idx + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1929 {
    // 소수 구하기
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] prime = new int[n+1]; // 에라토스테네스의 체
        prime[0] = 1; // 1 = 소수 아님
        prime[1] = 1;
        for(int i=2; i<=Math.sqrt(n); i++){
            for (int j=2; i*j<=n; j++) {
                prime[i * j] = 1;
            }
        }
        for(int i=m; i<=n; i++){
            if (prime[i] != 1){
                System.out.println(i);
            }
        }
    }
}

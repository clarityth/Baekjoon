import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050 {
    // 이항 계수 1
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] bc = new int[n+1][n+1];
        System.out.println(bc(bc, n, k));
    }
    public static int bc(int[][] a, int n, int k){ // 파스칼의 삼각형
        a[0][0] = 1;
        if(n>0){
            a[1][0] = 1;
            a[1][1] = 1;
        }
        if(n>1){
            for(int i=2; i<=n; i++){
                for(int j=0; j<=i; j++){
                    if(j == 0 || j == i){
                        a[i][j] = 1;
                    } else {
                        a[i][j] = a[i-1][j-1] + a[i-1][j];
                    }
                }
            }
        }
        return a[n][k];
    }
}

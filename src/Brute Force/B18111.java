import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
    // 마인크래프트
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int b = Integer.parseInt(st.nextToken()); // 블록 갯수
        int[][] arr = new int[n][m];
        int max = 0;
        int min = 257;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]) {
                    max = arr[i][j];
                }
                if(min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        int ans = 256*n*m;
        int height = 0;
        for(int target=max; target>=min; target--){
            int time = 0;
            int bag = b;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j] != target) {
                        int diff = Math.abs(target - arr[i][j]);
                        if (target > arr[i][j]){ // 블록 놓기
                            bag -= diff;
                            time += diff;
                        } else { // 블록 제거
                            bag += diff;
                            time += 2*diff;
                        }
                    }
                }
            }
            if (bag < 0){ // 인벤토리에 남은 블록이 음수일 경우, 해당 높이로 쌓는 것이 불가능
                continue;
            }
            if (time < ans){
                ans = time;
                height = target;
            }
        }
        System.out.println(ans+" "+height);
    }
}

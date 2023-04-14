// 랜선 자르기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {
    // 랜선자르기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lans = new long[k];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            lans[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lans);
        long min = 1L; // left를 1로 설정하지 않으면, /zero exception 발생
        long max = lans[k-1];

        while(min <= max){
            int cnt = 0;
            long mid = (min+max)/2;
            for (long lan : lans){
                if (lan >= mid) {
                    cnt += lan / mid;
                }
            }
            if(cnt >= n){ // 너무 많이 잘랐을 경우, 하한을 올려줌
                min = mid+1;
            }
            else { // 너무 적게 잘랐을 경우, 상한을 내려줌
                max = mid-1;
            }
        }
        System.out.println(max);
    }
}

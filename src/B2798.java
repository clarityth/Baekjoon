import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {
    // 블랙잭
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int buf = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = num[i]+num[j]+num[k];
                    if (sum == m){
                        System.out.println(sum);
                        return;
                    }
                    else if(sum > buf && sum < m){
                        buf = sum;
                    }
                }
            }
        }
        System.out.println(buf);
    }
}

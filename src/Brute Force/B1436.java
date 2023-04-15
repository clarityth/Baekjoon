// 영화감독 숌
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=665; cnt<n; i++){
            if(String.valueOf(i).contains("666")){
                cnt++;
            }
            if (cnt == n){
                System.out.println(i);
            }
        }
    }
}

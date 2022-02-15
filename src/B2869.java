import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2869 {
    // 달팽이는 올라가고 싶다
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 올라가는 높이
        int b = Integer.parseInt(st.nextToken()); // 미끄러지는 높이
        int v = Integer.parseInt(st.nextToken()); // 나무막대 높이
        v -= a; // 첫째날
        if (v % (a-b) == 0){ // 나누어 떨어짐
            System.out.println((v/(a-b)) +1); // 첫째날 더해줌
        }
        else { // 한번 더 올라가야 함
            System.out.println((v/(a-b)) +2); // 첫째날과 하루를 더 더해줌
        }
    }
}

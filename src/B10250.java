import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10250 {
    // ACM 호텔
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 호텔의 층 수
            int w = Integer.parseInt(st.nextToken()); // 각 층의 방 수
            int n = Integer.parseInt(st.nextToken()); // 몇번째 손님
            int width, height;
            if (n % h == 0){ // n가 h가 같을 때 배정받는 층 = h, 호수 = n/h
                height = h;
                width = (n/h);
            } else {
                height = n % h;
                width = (n/h) + 1;
            }
            if (height < 10) { // 호수가 YXX의 경우
                if (width < 10) {
                    sb.append(height + "0" + width);
                } else {
                    sb.append(height).append(width);
                }
            } else { // 호수가 YYXX의 경우
                if (width < 10) {
                    sb.append(height + "0" + width);
                } else {
                    sb.append(height).append(width);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10814 {
    // 나이순 정렬
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] person  = new StringBuilder[201];
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<person.length; i++){ // StringBuilder 배열 초기화
            person[i] = new StringBuilder();
        }
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            person[age].append(age + " " + name + "\n"); // age를 인덱스로 사용하여 가입한 순서대로 append
        }
        for(StringBuilder p : person){
            sb.append(p);
        }
        System.out.println(sb);
    }
}

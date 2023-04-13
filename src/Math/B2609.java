import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2609 {
    // 최대공약수와 최소공배수
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (b > a){ // a > b라고 가정
            int temp = a;
            a = b;
            b = temp;
        }
        long res1 = 0; // 공약수
        long res2 = 0; // 공배수
        for (int i=1; i<=a; i++){
            if (i <= b){
                if (a % i == 0 && b % i == 0){
                    res1 = i;
                }
            }
            if ((b * i) % a == 0 && res2 == 0){
                res2 = b * i;
            }
        }
        System.out.println(res1);
        System.out.println(res2);
    }
}

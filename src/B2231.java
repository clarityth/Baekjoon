import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231 {
    // 분해합
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        for (int i=n-9*input.length(); i<n; i++){ // 생성자의 최솟값 = 각 자릿수가 모두 9일 경우
            int num = i;
            int digitsum = num;
            while(num != 0){
                int digit = num % 10;
                digitsum += digit;
                num /= 10;
            }
            if (digitsum == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}

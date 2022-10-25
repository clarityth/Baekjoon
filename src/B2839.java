import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
    // 설탕 배달
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        if (n%5 == 0){
            System.out.println(n/5);
        }
        else { // Greedy
            res += n/5;
            n = n%5;
            if (n%3 != 0) { // 나머지가 3으로 나누어지지 않으면
                while(res > 0) { // 몫이 0이 될때 종료
                    res--; // 몫을 하나 줄이고, 복구시킨 무게를 3으로 나눔
                    n += 5;
                    if(n%3 == 0){ // 3으로 나누어 떨어진다면, 출력
                        res += n/3;
                        System.out.println(res);
                        return;
                    }
                }
                System.out.println(-1); // n킬로그램을 만들 수 없음
            }
            else{
                res += n/3;
                System.out.println(res);
            }
        }
    }
}

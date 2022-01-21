import java.util.Scanner;

public class B1292 {
    // 쉽게 푸는 문제
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        int res = 0;
        for (int i = 1; i <= 1000; i++) { // start부터 end까지 반복
            for (int j = 0; j < i; j++){ // 현재 숫자만큼 반복
                cnt++; // 몇번째 숫자인지 카운트
                if (cnt >= a &&  cnt <= b){
                    res += i;
                }

            }
        }
        System.out.println(res);
    }
}

import java.util.Scanner;

public class B2914 {
    // 저작권
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 수록된 곡의 갯수
        int i = sc.nextInt(); // 평균값
        // i = x / a + 올림, x = i * a
        int res = (a*(i-1))+1; // 적어도이므로 +1
        System.out.println(res);
    }
}

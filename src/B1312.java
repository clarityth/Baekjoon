import java.util.Scanner;

public class B1312 {
    // 소수
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int res = a%b;
        for (int i=0; i<n-1; i++){
            res *= 10;
            res %= b;
        }
        res *= 10;
        res /= b;
        System.out.println(res);
    }
}

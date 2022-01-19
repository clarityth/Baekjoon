import java.util.Scanner;

public class B1094 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int len = 64;
        int cnt = 0;

        while (x > 0) {
            if (len > x) {
                len /= 2;
            }
            else {
                cnt++;
                x -= len;
            }
        }
        System.out.println(cnt);
    }
}

import java.util.Scanner;

public class B2475 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int res=0;
        for (int i=0; i<5; i++) {
            int a = sc.nextInt();
            res += a*a;
        }
        System.out.println(res%10);
    }
}

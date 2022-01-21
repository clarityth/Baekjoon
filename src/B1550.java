import java.util.Scanner;

public class B1550 {
    // 16진수
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int res = Integer.parseInt(n, 16);
        sc.close();
        System.out.println(res);
    }
}

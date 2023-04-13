import java.util.Scanner;

public class B3046 {
    // R2
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int s = sc.nextInt();
        // s = r1 + r2 /2, r2 = 2*s - r1
        int r2 = 2*s - r1;
        System.out.println(r2);
    }
}

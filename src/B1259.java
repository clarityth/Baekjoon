import java.util.Scanner;

public class B1259 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int num = sc.nextInt();

        while (num != 0) {
            int input = num;
            int rev = 0;

            while (num > 0) {
                rev = rev * 10 + (num % 10);
                num /= 10;
            }

            if (rev == input)
                sb.append("yes" + "\n");
            else
                sb.append("no" + "\n");
            num = sc.nextInt();
        }

        System.out.println(sb);

    }
}

import java.util.Scanner;

public class B1259 {
    // 팰린드롬수
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        while (num != 0) {
            int input = num;
            int rev = 0;

            while (num > 0) {
                rev = rev * 10 + (num % 10); // 자릿수를 늘려주고 원래 자리에 나머지를 삽입
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

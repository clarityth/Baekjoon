import java.math.BigInteger;
import java.util.Scanner;

public class B2845 {
    // 파티가 끝나고 난 뒤
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BigInteger n = sc.nextBigInteger();
        BigInteger p = sc.nextBigInteger();
        for(int i=0; i<5; i++){
            BigInteger num = sc.nextBigInteger();
            BigInteger res = num.subtract(n.multiply(p));
            sb.append(res).append(" ");
        }
        System.out.println(sb);
    }
}

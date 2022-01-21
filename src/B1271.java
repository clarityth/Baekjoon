import java.math.BigInteger;
import java.util.Scanner;

public class B1271 {
    // 엄청난 부자2
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();
        sc.close();
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}

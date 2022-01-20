import java.util.Arrays;
import java.util.Scanner;

public class B2693 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int[] arr = new int[10];
            for (int j=0; j<10; j++){
                int num = sc.nextInt();
                arr[j] = num;
            }
            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        System.out.println(sb);
    }
}

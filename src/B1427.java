import java.util.Arrays;
import java.util.Scanner;

public class B1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        int index = 0;
        int[] a = new int[11];
        Arrays.fill(a,-1);

        while (num > 0){
            a[index++] = num % 10;
            num /= 10;
        }
        for (int j=0; j<a.length; j++){
            for (int k=0; k<a.length-1; k++){
                if (a[k]<a[k+1]){
                    int temp = a[k+1];
                    a[k+1] = a[k];
                    a[k] = temp;
                }
            }
        }

        int l = 0;
        while (a[l] != -1){
            sb.append(a[l++]);
        }
        System.out.println(sb);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class B1037 {
    // 약수
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = arr[n-1];
        int min = arr[0];
        System.out.println(max*min);
    }
}

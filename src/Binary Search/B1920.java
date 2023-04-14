// 수 찾기
import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            int a = sc.nextInt();
            arr[i] = a;
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i=0; i<m; i++){
            int b = sc.nextInt();

            if (binarySearch(arr, b) != -1){
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
    public static int binarySearch(int[] arr, int key){ // 이진 탐색
        int low = 0; // 처음 index
        int high = arr.length - 1; // 마지막 index

        while (low <= high){
            int mid = (low+high)/2; // mid 계산

            if (key < arr[mid]){
                high = mid-1;
            }
            else if (key > arr[mid]){
                low = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

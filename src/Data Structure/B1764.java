// 듣보잡
import java.util.Arrays;
import java.util.Scanner;

public class B1764 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;

        String[] arr = new String[n+m];
        for(int i=0; i<n+m; i++){
            String name = sc.next();
            arr[i] = name;
        }
        Arrays.sort(arr);

        for(int i=0; i<n+m; i+=2) {
            if (upperBound(arr, i) - lowerBound(arr, i) > 1){
                cnt++;
                sb.append(arr[i]).append("\n");
            }
        }
        sb.insert(0, cnt+"\n");
        System.out.println(sb);

    }
    public static int upperBound(String[] arr, int key){
        int hi = arr.length;
        int lo = 0;
        while(lo < hi){
            int mid = (lo+hi) / 2;
            if (arr[key].compareTo(arr[mid]) < 0){ // key값이 mid값보다 클 경우
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static int lowerBound(String[] arr, int key){
        int hi = arr.length;
        int lo = 0;
        while(lo < hi){
            int mid = (lo+hi) / 2;
            if (arr[key].compareTo(arr[mid]) <= 0){ // key값이 mid값보다 크거나 같을 경우
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

import java.util.*;

public class B10816 {
    // 숫자 카드 2
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt(); // 가지고 있는 숫자 카드 수
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 이분 탐색을 위한 정렬

        int m = sc.nextInt();
        for (int i=0; i<m; i++){
            int num = sc.nextInt();
            sb.append(upperBound(arr, num)-lowerBound(arr, num)).append(" "); // 값의 갯수 = 찾는 값 초과 값의 idx - 찾는 값 이상 값의 idx
        }
        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int key){ // 찾는 값 이상의 값의 index를 반환
        int low = 0;
        int high = arr.length;

        while (low < high){
            int mid = (low+high)/2;
            if (key <= arr[mid]) { // 키 값이 배열의 중간값보다 작거나 같을 경우
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int key){ // 찾는 값을 초과하는 값의 index를 반환
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low+high)/2;
            if (key < arr[mid]) { // 키 값이 배열의 중간값보다 작을 경우
                high = mid;
            }
            else { // 중복값 처리
                low = mid + 1;
            }
        }
        return low;
    }
}

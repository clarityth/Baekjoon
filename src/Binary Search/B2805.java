import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    // 나무 자르기
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max){
                max = arr[i];
            }
        }
        while(min < max){
            int mid = (min+max)/2;
            long sum = 0;
            for(int tree : arr) {
                if (tree > mid) { // 나무의 높이가 자르는 높이보다 높을 경우에만 추가
                    sum += tree - mid;
                }
            }
            if(sum < m){ // 합계가 가져가려는 길이보다 작을 경우, 자르는 높이의 상한을 낮춤
                max = mid;
            }
            else { // 합계가 가져가려는 길이보다 더 크거나 같을 경우, 자르는 높이의 하한을 올림
                min = mid+1;
            }

        }
        System.out.println(min-1); // upperBound를 반환하므로, -1
    }
}

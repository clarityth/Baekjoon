import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2920 {
    // 음계
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean asc = true;
        boolean desc = true;
        int[] arr =  new int[8];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i=1; i<8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i-1] > arr[i]) {
                asc = false;
            }
            else if (arr[i-1] < arr[i]) {
                desc = false;
            }
        }
        if (asc) {
            System.out.println("ascending");
        }
        else if (desc){
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }
    }
}

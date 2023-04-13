import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B11651 {
    // 좌표 정렬하기 2
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p[i][0] = x;
            p[i][1] = y;
        }
        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0]-o2[0]; // y좌표가 같은 경우 x좌표가 증가하는 순으로 정렬
                }
                return o1[1]-o2[1];// y좌표가 증가하는 순으로 정렬
            }
        });
        for(int i=0; i<n; i++) {
            sb.append(p[i][0]+" "+p[i][1]+"\n");
        }
        System.out.println(sb);
    }
}

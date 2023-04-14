// 트리의 부모 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int[] parents = new int[n+1];
        dfs(list, parents, 1, 0);
        for (int i=2; i<=n; i++){
            System.out.println(parents[i]);
        }
    }
    private static void dfs(ArrayList<Integer>[]list, int[] parents, int now, int pre){
        parents[now] = pre;
        for (int item : list[now]){
            if (item != pre){
                dfs(list, parents, item, now);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] coordinate = new int[N];
    int[] sortedCoordinate = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for(int i=0; i<N; i++){
      coordinate[i] = sortedCoordinate[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(sortedCoordinate);
    HashMap<Integer,Integer> rankMap = new HashMap<>();
    int rank = 0;
    
    for(int i=0; i<N; i++){
      if(!rankMap.containsKey(sortedCoordinate[i])){
        rankMap.put(sortedCoordinate[i], rank);
        rank++;
      }
    }
    StringBuilder sb = new StringBuilder();
    
    for(int i=0; i<N; i++){
      sb.append(rankMap.get(coordinate[i])+" ");
    }
    System.out.print(sb);
  }
}
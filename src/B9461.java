import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B9461 {
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N, T;
    long [] padovan = new long [101];
    padovan[0] = 0l; padovan[1] = 1l; padovan[2] = 1l; padovan[3] = 1l;
    T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++){
      N = Integer.parseInt(br.readLine());
      if (N > 3 && padovan[N] == 0){
        for(int j=4; j<=N; j++){
          padovan[j] = padovan[j-2] + padovan[j-3];
        }
      }
      sb.append(padovan[N]+"\n");
    }
    System.out.println(sb);
  }
}
  
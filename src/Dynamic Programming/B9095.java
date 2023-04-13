import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
  public static int recur(int n){
    if (n == 1){
      return 1;
    }
    else if (n == 2) {
      return 2;
    }
    else if (n == 3) {
      // 1+1+1 = 1+2 = 2+1 = 3
      return 4;
    }
    else {
      return recur(n-1)+recur(n-2)+recur(n-3);
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++){
      int n = Integer.parseInt(br.readLine());
      int result = recur(n);
      sb.append(result+"\n");
    }
    System.out.println(sb);
  }
}
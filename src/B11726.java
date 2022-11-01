import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11726{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1){
      System.out.println("1");
    }
    else {
      int arr[] = new int[n+1];
      arr[0] = 1;
      arr[1] = 2;
      for(int i=2; i<n; i++){
        arr[i] = (arr[i-2] + arr[i-1]) % 10007;
      }
      System.out.println(arr[n-1]);
    }
  }
}
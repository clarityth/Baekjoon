import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static int max(int a, int b){
    return a > b ? a : b;
  }
  
  public static void B2579(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numOfStair = Integer.parseInt(br.readLine());
    int[] stairValue = new int[301];
    int[] dp = new int[301];
    
    for (int i = 0; i < numOfStair; i++) {
      stairValue[i] = Integer.parseInt(br.readLine());
    }
    
    dp[0] = stairValue[0];
    dp[1] = max(stairValue[0] + stairValue[1], stairValue[1]);
    dp[2] = max(stairValue[0] + stairValue[2], stairValue[1]+stairValue[2]);
    
    for (int i = 3; i < numOfStair; i++) {
      dp[i] = max(dp[i-3]+stairValue[i-1]+stairValue[i], dp[i-2]+stairValue[i]); 
    }
    System.out.println(dp[numOfStair-1]);
  }
}

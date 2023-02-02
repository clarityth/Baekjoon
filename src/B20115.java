import java.io.*;
import java.util.*;

public class B20115 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Double energyDrinks[] = new Double[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    double maxDrink = 0;
    int maxIdx = 0;
    for (int i = 0; i < N; ++i){
      energyDrinks[i] = Double.parseDouble(st.nextToken());
      if (energyDrinks[i] > maxDrink) {
        maxDrink = energyDrinks[i];
        maxIdx = i;
      }
    }
    for (int i = 0; i < N; ++i){
      if (i == maxIdx)
        continue;
      maxDrink += energyDrinks[i] / 2;
    }
    bw.write(String.valueOf(maxDrink));
    bw.flush();
    bw.close();
    br.close();
  }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Iterator;

public class B26596 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int M = Integer.parseInt(br.readLine());
    HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
    HashMap<Integer, String> revIngredients = new HashMap<Integer, String>();
    for (int i = 0; i < M; ++i){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String ingredient = st.nextToken();
      int amount = Integer.parseInt(st.nextToken());
      int existingAmount = ingredients.getOrDefault(ingredient, -1);
      if (existingAmount == -1){
        // 처음 넣는 경우
        ingredients.put(ingredient, amount);
        revIngredients.put(amount, ingredient);
      } 
      else {
        // 기존에 이미 들어간 경우
        ingredients.replace(ingredient, existingAmount + amount);
        revIngredients.remove(existingAmount);
        revIngredients.put(existingAmount + amount, ingredient);
      }
    }
    boolean isGoldenRatio = false;
    // HashMap 순회 (entrySet()을 사용하는 것이 Iterator+keySet()보다 빠름)
    for (HashMap.Entry<String, Integer> entry : ingredients.entrySet()) {
      String key = entry.getKey();
      int targetValue = (int) Math.floor(entry.getValue() * 1.618);
      String targetIngredient = revIngredients.getOrDefault(targetValue, "\0");
      // 황금 비율을 이루는 재료를 탐색
      if (!targetIngredient.equals("\0") && !targetIngredient.equals(key)){
        isGoldenRatio = true;
        break;
      }
    }
    if (isGoldenRatio)
      bw.write("Delicious!");
    else
      bw.write("Not Delicious...");
    bw.flush();
    bw.close();
    br.close();
  }
}
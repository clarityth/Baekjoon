// 나는야 포켓몬 마스터 이다솜
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.HashMap;

public class B1620{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<Integer, String> pokedex = new HashMap<>();
    HashMap<String, Integer> pokedexReverse = new HashMap<>();
    
    for(int i=1; i<N+1; i++){
      String pokemon = br.readLine();
      pokedex.put(i, pokemon);
      pokedexReverse.put(pokemon, i);
    }
    
    for(int i=0; i<M; i++){
      String input = br.readLine();
      char c = input.charAt(0);
      if (c >= 48 && c<= 57){
        int pokeNum = Integer.parseInt(input);
        String pokeName = pokedex.get(pokeNum);
        sb.append(pokeName+"\n");
      }
      else {
        int pokeNum = pokedexReverse.get(input);
        sb.append(pokeNum+"\n");
      }
    }
    System.out.println(sb);
  }
}
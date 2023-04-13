import java.io.*;
import java.util.*;

public class B22233 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, Boolean> keyWordMap = new HashMap<String, Boolean>();
    // hashMap에 <단어, true>를 저장 -> getOrDefault() 탐색 실패시 false를 기본값으로 설정
    for (int i=0; i<N; ++i){
      String word = br.readLine();
      keyWordMap.put(word, true);
    }
    for (int i=0; i<M; ++i){
      String usedWordStr = br.readLine();
      String[] usedWordArr = usedWordStr.split(",");
      // , 를 기준으로 문자열 파싱
      for (String usedWord : usedWordArr){
        if (keyWordMap.getOrDefault(usedWord, false) == true){
          // 단어장에 있는 단어를 사용
          keyWordMap.remove(usedWord);
          --N;
        }
      }
      bw.write(String.valueOf(N));
      bw.write("\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
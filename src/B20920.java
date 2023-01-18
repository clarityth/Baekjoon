import java.io.*;
import java.util.*;

public class B20920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
    // hashMap에 <단어, 해당 단어가 등장한 횟수>를 저장
    for (int i=0; i<N; ++i){
      String word = br.readLine();
      if (word.length() >= M){
        int frequency = wordMap.getOrDefault(word, -1);
        if (frequency == -1){
          // 처음 나온 단어
          wordMap.put(word, 1);
        } 
        else {
          // 이전에 나왔던 단어
          wordMap.replace(word, frequency+1);
        }
      }
    }
    List<Map.Entry<String, Integer>> vocaList = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());
    Collections.sort(vocaList, new Comparator<Map.Entry<String, Integer>>() {
      @Override
    	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        // 빈도 순으로 정렬
        int v1 = o1.getValue();
        int v2 = o2.getValue();
        if (v1 != v2){
          return -(v1 - v2);
        }
        else {
          String k1 = o1.getKey();
          String k2 = o2.getKey();
          int l1 = k1.length();
          int l2 = k2.length();
          if (l1 != l2) {
          // 길이가 긴 순으로 정렬
    			 return -(l1 - l2);
    		  }
      		else {
            for (int i=0; i<k1.length(); ++i){
              if (k1.charAt(i) != k2.charAt(i))
              // 사전 순으로 정렬
                return k1.charAt(i)-k2.charAt(i);
            }
          }
        }
        return 0;
    	}
    });
    for(Map.Entry<String, Integer> e : vocaList){
      bw.write(e.getKey() + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
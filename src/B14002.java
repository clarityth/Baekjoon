import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;
import java.util.Stack;

public class B14002 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) 
      sequence[i] = Integer.parseInt(st.nextToken());
    
    Vector<Integer> lis = new Vector<Integer>();
    // 이진 탐색 LIS 알고리즘 사용시 LIS의 길이는 구할 수 있으나, 부분 수열을 출력하는 경우 문제가 발생
    int[] idxOrder = new int[N];
    // 입력받은 숫자가 lis 벡터의 어느 index에 넣어졌는지를 저장하는 배열
    int idx = -1;
    for (int i = 0; i<N; ++i) {
      int num = sequence[i];
      if (lis.isEmpty() || lis.lastElement() < num) {
        lis.add(num);
        idx = lis.size() - 1;
      }
      else {
        idx = Collections.binarySearch(lis, num);
        if (idx < 0) 
          idx = (idx * -1) - 1;
        lis.set(idx, num);
      }
      idxOrder[i] = idx;
    }

    // 가령 lis.size() = 3인 경우, idxOrder 배열에 저장된 값이 2,1,0이 나오는 sequence 배열의 값을 스택에 push
    Stack <Integer> s = new Stack <Integer>();
    int targetIdx = lis.size()-1;
    int i = N-1;
    int cnt = lis.size();
    while (cnt >= 0){
      while (targetIdx >= 0){
        if (idxOrder[i] == targetIdx){
          s.push(sequence[i]);
          --targetIdx;
          break;
        }
        --i;
      }
      --cnt;
    }
    
    bw.write(String.valueOf(lis.size()) + "\n");
    while(!s.isEmpty())
      bw.write(String.valueOf(s.pop()) + " ");
    bw.flush();
    bw.close();
    br.close();
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class B1406 {
    // 에디터
    static LinkedList<Character> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            list.add(input.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()){
            iter.next();
        }
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str){
                case "L" :
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case "D" :
                    if (iter.hasNext())
                        iter.next();
                    break;
                case "B" :
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P" :
                    iter.add(st.nextToken().charAt(0));
                    break;
            }
        }
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}

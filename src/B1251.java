import java.util.*;

public class B1251 {
    // 단어 나누기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> revWords = new ArrayList<>();
        for(int i=1; i<str.length()-1; i++) {
            String revWord;
            String first, mid, last;
            for (int j=i+1; j<str.length(); j++) {
                first = str.substring(0, i); // 0부터 i-1까지
                mid = str.substring(i, j); // i부터 j-1까지
                last = str.substring(j); // j부터 끝까지
//                sb.append(first + " " + mid + " " + last + " \n");
                revWord = reverse(first) + reverse(mid) + reverse(last);
                revWords.add(revWord);
            }
        }
        Collections.sort(revWords);
        System.out.println(revWords.get(0));
    }
    public static String reverse(String s){ // stack을 이용하여 단어 뒤집기
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        for (int i=0; i<s.length(); i++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

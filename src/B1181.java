import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1181 {
    // 단어 정렬
    // 길이가 짧은 것부터
    // 길이가 같으면 사전 순으로
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        for (int i = 0; i<N; i++){
            str[i] =  sc.next();
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) // 길이가 같다면, 사전순으로 정렬
                    return o1.compareTo(o2);

                else
                    return o1.length() - o2.length(); // 길이순 정렬
            }
        });

        System.out.println(str[0]);
        for(int i=1; i<N; i++) {
            if (! str[i].equals(str[i - 1]))
                System.out.println(str[i]);
        }
    }
}

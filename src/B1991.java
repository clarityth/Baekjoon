import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1991 {
    static Map<String, List<String>> map = new HashMap<>();
    // 트리 순회
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("\\s");
            List<String> list = new ArrayList<>();

            list.add(tmp[1]); // 왼쪽 자식
            list.add(tmp[2]); // 오른쪽 자식
            map.put(tmp[0], list); // 루트
        }
        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }

    public static void preorder(String s){ // 전위 순회
        if(s.equals("."))
            return;
        System.out.print(s); // 루트
        preorder(map.get(s).get(0)); // 왼쪽 자식
        preorder(map.get(s).get(1)); // 오른쪽 자식
    }

    public static void inorder(String s){ // 중위 순회
        if (s.equals("."))
            return;
        inorder(map.get(s).get(0)); // 왼쪽 자식
        System.out.print(s); // 루트
        inorder(map.get(s).get(1)); // 오른쪽 자식
    }

    public static void postorder(String s){ // 후위 순회
        if (s.equals("."))
            return;
        postorder(map.get(s).get(0)); // 왼쪽 자식
        postorder(map.get(s).get(1)); // 오른쪽 자식
        System.out.print(s); // 루트
    }
}

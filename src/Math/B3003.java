import java.util.Scanner;

public class B3003 {
    // 킹, 퀸, 룩, 비숍, 나이트, 폰
    public static void main(String[] args){
        int [] arr = new int[]{1,1,2,2,2,8};
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<6; i++){
            int num = sc.nextInt();
            arr[i] -= num;
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}

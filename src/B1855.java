import java.util.Scanner;

public class B1855 {
    // 암호
    // [0,0] [1,0] [2,0] line 0
    // [0,1] [1,1] [2,1] line 1
    // [0,2] [1,2] [2,2] line 2
    // [0,3] [1,3] [2,3] line 3
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int K = sc.nextInt();
        String str = sc.next();
        char[][] arr = new char[K][200/K];
        int index = 0;
        int line = 0;

        for (int col=0; col<str.length()/K; col++){
            int row;
            if (line % 2 == 0) {
                for (row = 0; row < K; row++) {
                    arr[row][col] = str.charAt(index++);
                }
            }
            else if (line % 2 == 1) {
                for (row = K -1; row >= 0; row--) {
                    arr[row][col] = str.charAt(index++);
                }
            }
            line++;

        }
        for (int i=0; i<K; i++){
            for (int j=0; j<str.length()/K; j++){
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }
}

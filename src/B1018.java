import java.util.Scanner;

public class B1018 {
    // 체스판 다시 칠하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행의 갯수
        int M = sc.nextInt(); // 열의 갯수
        char[][] input = new char[50][50];

        for (int i=0; i<N; i++){
            String str = sc.next();
            for (int j=0; j<M; j++){
                input[i][j] = str.charAt(j);
            }
        }

        char[][] black = {{'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'}};
        char[][] white = {{'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'},
                        {'W','B','W','B','W','B','W','B'},
                        {'B','W','B','W','B','W','B','W'}};

        // 다시 칠해야하는 정사각형의 갯수
        int b_cnt = 64;
        int w_cnt = 64;

        for (int i=0; i<=N-8; i++){ // 여유 행만큼 이동
            for (int j=0; j<=M-8; j++){ // 여유 열만큼 이동
                int b_wrong = 0;
                int w_wrong = 0;
                for (int k=0; k<8; k++) {
                    for (int l=0; l<8; l++) {
                        if (input[k + i][l + j] != black[k][l]) {
                            b_wrong++;
                        }
                        if (input[k + i][l + j] != white[k][l]) {
                            w_wrong++;
                        }
                    }
                }
                if (b_cnt > b_wrong) b_cnt = b_wrong;
                if (w_cnt > w_wrong) w_cnt = w_wrong;
            }
        }
        System.out.println(Math.min(b_cnt, w_cnt));

        }
    }

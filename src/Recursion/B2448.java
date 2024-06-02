// 별 찍기 - 11
import java.io.*;
import java.util.Arrays;

public class B2448 {
    public static int N;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); // 삼각형의 높이
        char[][] triangle = new char[N][2 * N];
        sb = new StringBuilder();

        // 초기화
        initializeTriangle(triangle);

        // 삼각형 그리기
        drawTriangle(triangle, N, 0, N - 1);

        // 출력
        printTriangle(triangle);
        bw.flush();
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    // 삼각형 배열을 공백으로 초기화
    private static void initializeTriangle(char[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            Arrays.fill(triangle[i], ' ');
        }
    }

    // 삼각형을 재귀적으로 그리기(인자로 삼각형의 위쪽 꼭짓점의 좌표)
    private static void drawTriangle(char[][] triangle, int height, int row, int col) {
        if (height == 3) {
            triangle[row][col] = '*';
            triangle[row + 1][col - 1] = '*';
            triangle[row + 1][col + 1] = '*';
            triangle[row + 2][col - 2] = '*';
            triangle[row + 2][col - 1] = '*';
            triangle[row + 2][col] = '*';
            triangle[row + 2][col + 1] = '*';
            triangle[row + 2][col + 2] = '*';
            return;
        }
        int newHeight = height / 2;
        // 상단 삼각형
        drawTriangle(triangle, newHeight, row, col);

        // 좌하단 삼각형
        drawTriangle(triangle, newHeight, row + newHeight, col - newHeight);

        // 우하단 삼각형
        drawTriangle(triangle, newHeight, row + newHeight, col + newHeight);
    }

    // 삼각형 배열을 출력
    private static void printTriangle(char[][] triangle){
        for (int row = 0; row < triangle.length; row++) {
            sb.append(triangle[row]);
            sb.append("\n");
        }
    }
}
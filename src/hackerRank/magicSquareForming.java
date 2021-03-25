package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class magicSquareForming {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        //possible magicsquare is 8
        int[][] magic0 = {{8,1,6}, {3,5,7}, {4,9,2}};
        int[][] magic1 = {{6,1,8}, {7,5,3}, {2,9,4}};
        int[][] magic2 = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] magic3 = {{2,9,4}, {7,5,3}, {6,1,8}};
        int[][] magic4 = {{8,3,4}, {1,5,9}, {6,7,2}};
        int[][] magic5 = {{4,3,8}, {9,5,1}, {2,7,6}};
        int[][] magic6 = {{6,7,2}, {1,5,9}, {8,3,4}};
        int[][] magic7 = {{2,7,6}, {9,5,1}, {4,3,8}};

        int[] sum = new int[8];

        //compare given parameter and possible magicsquare
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[0] += Math.abs(s[i][j] - magic0[i][j]);
                sum[1] += Math.abs(s[i][j] - magic1[i][j]);
                sum[2] += Math.abs(s[i][j] - magic2[i][j]);
                sum[3] += Math.abs(s[i][j] - magic3[i][j]);
                sum[4] += Math.abs(s[i][j] - magic4[i][j]);
                sum[5] += Math.abs(s[i][j] - magic5[i][j]);
                sum[6] += Math.abs(s[i][j] - magic6[i][j]);
                sum[7] += Math.abs(s[i][j] - magic7[i][j]);
            }
        }

        int min = sum[0];

        for (int i = 0; i < sum.length; i++) {
            if (min > sum[i]) {
                min = sum[i];
            }
        }

        return min;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);
        System.out.println(result);
        scanner.close();
    }
}

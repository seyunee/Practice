package beakJoon;

import java.util.Scanner;
//Longest Common Subsequence, 최장 공통 부분 수열
//O(n^2)
//dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j])
public class lcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        String y = sc.nextLine();
        int[][] dp = new int[1001][1001];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[x.length()][y.length()]);
    }
}

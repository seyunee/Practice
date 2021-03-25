package beakJoon;

import java.util.Scanner;

//동적프로그래밍 완전탐색
//N이 최대1,000,000이라서 O(n)으로 푼다.
//점화식. 인접한항들에 대한 관계식
//길이가 i인수열을 만드는 방법은 i번째에 1이 들어가거나 i-1,i번째에 00이 들어가는경우.
//D[i]=D[i-1]+D[i-2] 로 피보나치와 동일

public class exhaustiveSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }

        System.out.println(dp[n]);
    }
}

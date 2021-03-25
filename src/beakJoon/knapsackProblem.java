package beakJoon;

import java.util.Scanner;

//배낭문제. 물품의수가 n,무게가 k 일때 동적프로그래밍으로 시간복잡도 O(nk)
//각 물품의 번호 i에 따라서 가치배열D[n][k]으로 가능
public class knapsackProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			for (int j = 1; j <= k; j++) {
				if (j < weight) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}

package beakJoon;

import java.util.ArrayList;
import java.util.Scanner;
//차례대로 연주하기때문에 동적프로그래밍으로 해결가능
//O(nm)
//모든 볼륨에 대하여 연주가능여부를 계산한다.
//D[i][j-V[i]=True if D[i-1][j]=True
//D[i][j+V[i]=True if D[i-1][j]=True
public class volumeList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<Integer>();
		int[][] dp = new int[101][1001];
		
		for (int i = 0; i < n; i++) {
			data.add(sc.nextInt());
		}

		//가능한것 표시하기
		dp[0][s] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (dp[i - 1][j] == 0) continue;
				if (j - data.get(i - 1) >= 0) {
					dp[i][j - data.get(i - 1)] = 1;
				}
				if (j + data.get(i - 1) <= m) {
					dp[i][j + data.get(i - 1)] = 1;
				}
			}
		}

		//결과 값을 맨 마지만 배열만 확인하기
		int result = -1;
		for (int i = m; i >= 0; i--) {
			if (dp[n][i] == 1) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}

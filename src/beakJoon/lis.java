package beakJoon;

import java.util.ArrayList;
import java.util.Scanner;
//가장 긴 증가하는 부분수열(LIS)
//O(n^2)
//0<=j<i에 대하여 D[i]=max(D[i],D[j]+1) if array[j]<array[i]
public class lis {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 0;
		ArrayList<Integer> data = new ArrayList<Integer>();
		int[] dp = new int[1000];
		
		for (int i = 0; i < n; i++) {
			data.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data.get(j) < data.get(i)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}

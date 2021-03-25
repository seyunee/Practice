package beakJoon;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//가장 긴 증가하는 부분수열(LIS)의 심화변형문제
//O(n^2)
//벽돌의 번호를 출력해야 하기때문에 계산된 테이블을 역추적해야함
// 무게,너비 기준으로 정렬
public class lis_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] array = new int[n+1][4];
		for (int i = 1; i < n+1; i++) {
			array[i][0] = i;
			array[i][1] = sc.nextInt();
			array[i][2] = sc.nextInt();
			array[i][3] = sc.nextInt();
		}

		Arrays.sort(array, Comparator.comparingInt(num1 -> num1[3]));

		int[] dp = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i][1] > array[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + array[i][2]);
				}
			}
		}

		int[] maxDp=dp.clone();
		Arrays.sort(maxDp);
		int max =maxDp[maxDp.length-1];
		List<Integer> result = new ArrayList<Integer>();
		while (n!=0){
			if(max==dp[n]){
				result.add(array[n][0]);
				max -= array[n][2];
			}
			n -=1;
		}

		result = result.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(result.size());
		for(Integer print : result){
			System.out.println(print);
		}
	}

}

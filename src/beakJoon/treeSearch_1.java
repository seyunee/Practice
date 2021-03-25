package beakJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class treeSearch_1 {

	static Map<String, List<String>> map = new HashMap<>();

	//전위순회
	private static void preorder(String v) {
		if(v.equals(".")) return;

		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}

	//중위순회
	private static void inorder(String v) {
		if(v.equals(".")) return;

		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}

	//후위순회
	private static void postorder(String v) {
		if(v.equals(".")) return;

		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 클래스를 이용해 빠르게 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("\\s");
			List<String> list = new ArrayList<>();

			list.add(tmp[1]); list.add(tmp[2]);
			map.put(tmp[0], list);
		}

		preorder("A"); System.out.println();
		inorder("A"); System.out.println();
		postorder("A");
	}

}

package beakJoon.bfs;

import java.util.Scanner;

public class iceCube {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        if(x < 0 || y <0 || x>=n || y>=m) return false;

        if(graph[x][y] == 0){
            graph[x][y] = 1;
            dfs(x -1,y);
            dfs(x ,y-1);
            dfs(x +1,y);
            dfs(x ,y+1);
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행n
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력
    }
}

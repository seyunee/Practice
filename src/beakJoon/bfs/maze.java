package beakJoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


public class maze {
    public static int n, m;
    public static int[][] graph = new int[201][201];
    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    private static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for(int i=0;i<4;i++){
                int mx = x+dx[i];
                int my = y+dy[i];
                if (mx < 0 || mx >= n || my < 0 || my >= m) continue;
                if(graph[mx][my] ==0)continue;
                if(graph[mx][my] ==1){
                    graph[mx][my]=graph[x][y] +1;
                    q.offer(new Node(mx,my));
                }
            }
        }
        return graph[n - 1][m - 1];

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

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }
}

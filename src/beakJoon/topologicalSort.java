package beakJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class topologicalSort {
    //위상정렬
    //즉, 방향 그래프에 존재하는 각 정점들의 선행 순서를 위배하지 않으면서 모든 정점을 나열하는 것
    //https://gmlwjd9405.github.io/2018/08/27/algorithm-topological-sort.html
    //시간복잡도 O(v+e)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        int link[] = new int[n+1];
        LinkedList<Integer> list[] = new LinkedList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(b);
            link[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++)
            if(link[i] == 0)
                pq.offer(i);
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");
            Iterator<Integer> it = list[now].iterator();
            while(it.hasNext()) {
                int next = it.next();
                link[next]--;
                if(link[next] == 0)
                    pq.offer(next);
            }
        }
        System.out.println(sb.toString());
    }
}

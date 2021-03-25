package beakJoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_18352 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt() +1;
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] distance = new int[n];

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            distance[i]=0;
        }

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()){
            int v = q.poll();
            for(int i=0;i<graph.get(v).size();i++){
                int newv = graph.get(v).get(i);
                if(distance[newv]==0){
                    q.offer(newv);
                    distance[newv]= distance[v]+1;
                }
            }
        }

        distance[x]=0;
        boolean result = true;
        for(int i=0;i<n;i++){
            if(distance[i]==k) {
                System.out.println(i);
                result=false;
            }
        }

        if(result){
            System.out.println(-1);
        }

    }

}

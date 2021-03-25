package beakJoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class heapCardSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 자바(Java)에서는 기본적으로 우선순위 큐가 최소 힙(Min Heap)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            pq.add(x); //힙에 다 넣기
        }

        int result=0;
        while(pq.size()>1){
            int one = pq.poll();
            int two = pq.poll();
            result += one+two;
            pq.add(one+two);
        }

        System.out.println(result);
    }
}

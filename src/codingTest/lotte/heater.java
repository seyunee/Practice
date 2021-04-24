package codingTest.lotte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class heater {
    //메소드 시작
    public static void main(String[] args)
    {
        int[][] office = {{1,0,0,0},{0,0,0,1},{0,0,1,0},{0,1,1,0}};
        int result1 = solution(office,2);
        System.out.println("result=="+result1);
    }

    public static int solution(int[][] office, int k) {

        //격자의 크기
        int n = office[0].length;
        List<Integer> people = new ArrayList<>();

        for ( int x = 0; x <= n-k; x++) {
            for (int y = 0; y <= n-k; y++) {
                //k의 이동
                System.out.println("x==" + x);
                System.out.println("y==" + y);
                int person = 0;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        System.out.println("[" + (x + i) + "][" + (y + j) + "]==" + office[x + i][y + j]);

                        if (office[x + i][y + j] == 1) {
                            person++;
                        }
                    }
                }
                people.add(person);
            }
        }

        people =  people.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return people.get(0);
    }
}

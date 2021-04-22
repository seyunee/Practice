package programmers;

import java.util.Arrays;

public class maxnumber42746 {
    //메소드 시작
    public static void main(String[] args)
    {
        int[] numbers1 = {6, 10, 2};
        System.out.println(solution(numbers1));
        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers2));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        for(int i=0; i< numbers.length;i++){
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, (r1, r2) -> (r2+r1).compareTo(r1+r2));

        if(result[0].equals("0")){
             return "0";
        }

        for(String r : result){
            answer += r;
        }

        return answer;
    }
}

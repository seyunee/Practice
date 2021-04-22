package programmers;


import java.util.Arrays;

public class hindex42747 {
    //메소드 시작
    public static void main(String[] args)
    {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0; i<citations.length;i++){
            int h=citations.length-i;
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}

package programmers;

public class carpet42842 {
    //메소드 시작
    public static void main(String[] args)
    {
        int[] result1 = solution(10,2);
        int[] result2 = solution(8,1);
        int[] result3 = solution(24,24);
    }

    public static int[] solution(int brown, int yellow){
        int x=0;
        int y=0;
        int total = brown + yellow;
        for(y=3;y<brown/2; y++){
            if(total%y==0){
                if(brown == (2*(total/y))+(2*y)-4){
                    x =total/y;
                    break;
                }
            }

        }
        int[] answer = {x,y};
        System.out.println(x+", "+y);
        return answer;
    }
}

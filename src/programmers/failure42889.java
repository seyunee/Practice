package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ochunsung {
    private int stage;
    private double failure;

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public double getFailure() {
        return failure;
    }

    public void setFailure(double failure) {
        this.failure = failure;
    }

}

public class failure42889 {
    //메소드 시작
    public static void main(String[] args)
    {
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4,4,4,4,4};
        int[] result1 = solution(5, stages1);
        //int[] result2 = solution(4,stages2);

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<ochunsung> ochunsungs = new ArrayList<>();

        for(int i=1;i<=N;i++){
            ochunsung ochunsungStage = new ochunsung();
            ochunsungStage.setStage(i);

            double fail = 0.0d;
            double pass = 0.0d;
            for(int stage : stages){
                if(stage==i){
                    fail++;
                    pass++;
                }else if(stage>i){
                    pass++;
                }
            }
            ochunsungStage.setFailure(pass>0?(fail/pass):0);
            ochunsungs.add(ochunsungStage);
        }

        ochunsungs = ochunsungs.stream().sorted((o1,o2)-> Integer.compare(o1.getStage(), o2.getStage())).collect(Collectors.toList());
        ochunsungs = ochunsungs.stream().sorted((o1,o2)-> Double.compare(o2.getFailure(), o1.getFailure())).collect(Collectors.toList());

        // 정렬된 스테이지 번호 반환
        for (int i = 0; i < N; i++) {
            answer[i] = ochunsungs.get(i).getStage();
            System.out.print(answer[i] + " -> ");
        }
        return answer;
    }
}

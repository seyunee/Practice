package beakJoon.search;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class mockTest {
    private static int rightAnswer(int[] pattern, int[] answers) {
        int problem = answers.length;
        int[] stuAnswer = new int[problem];
        int correct =0;

        for(int i=0;i<problem;i++){
            stuAnswer[i]=pattern[i%pattern.length];
            if(answers[i]==stuAnswer[i]){
                correct++;
            }
        }
        return correct;
    }

    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5,3,3,3,4,4,5,5,5,5,2,3,1};

        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};

        int answer1 = rightAnswer(stu1,answer);
        int answer2 = rightAnswer(stu2,answer);
        int answer3 = rightAnswer(stu3,answer);

        int max = Math.max(Math.max(answer1,answer2),answer3);

        ArrayList<Integer> answers = new ArrayList<Integer>();
        if(answer1==max) answers.add(1);
        if(answer2==max) answers.add(2);
        if(answer3==max) answers.add(3);

        answers.stream().sorted().collect(Collectors.toList());

        System.out.print(answers);

    }
}

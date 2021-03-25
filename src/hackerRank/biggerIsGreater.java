package hackerRank;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class biggerIsGreater {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {

        int[] arr = new int[w.length()];

        for(int i=0; i<w.length(); i++){
            arr[i] = w.charAt(i);
        }
        String rs = "";
        if(nextPermutation(arr)){
            for(int n : arr){
                rs += (char)n;
            }
            return rs;
        } else {
            return "no answer";
        }
    }

    static boolean nextPermutation(int[] array) {
        // 내림차순 정렬을 따르고 있는 가장 긴 꼬리부분을 찾는다
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        // i는 꼬리부분의 시작점
        // 이미 정렬이 되어 있는 상태이므로 리턴하고 끝낸다
        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        //꼬리부분에서 가장 작으며 중심축보다 큰 수를 찾는다
        while (array[j] <= array[i - 1]) {
            j--;
        }
        // array[j] 가 새로운 중심축이 될 수이다 (기존 피봇과 위치를 바꿀 수)

        // 기존 피봇과 새로운 피봇이 될 수를 치환한다
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // 꼬리부분을 뒤집는다
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);
            System.out.println(result);
        }

        scanner.close();
    }
}


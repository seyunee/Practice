package naverwebtoon;

import java.util.ArrayList;
import java.util.Random;

public class oddoreven {
     /*  - 홀짝 비교는 입력값 'num'과 비교
        - 당첨일 경우 입력한 'num' 값의 2배 return
                - 미당첨일 경우 0 return*/

    private static int oddOrEven(int num) {
        Random right = new Random();
        int rightNum =  right.nextInt() % 2 ;
        if((num % 2) == rightNum){
            return num*2;
        }else{
            return 0;
        }
    }

    /*
    q. 문자열 압축프로그램을 개발하려고 한다.
        중복한 문자의 갯수를 숫자로 변환하시오

        예) aaaa bcbd aaaabbabab
        => a4 bcbd a4b2abab


        q. 이 알고리즘은 실제 효율적일까?
        q. 압축 효율을 높이려면???
     */
    private static void str(String str1){
        String[] strArr = str1.split(" ");
        for(String strData : strArr){
            System.out.println(strData);
            Character alpha = strData.charAt(0);
            String result="";
            int alphaCount =0;
            for(int i=1; i<strData.length(); i++){
                if(alpha == strData.charAt(i)){
                    alphaCount++;
                }else{
                    if(alphaCount>0){
                        result = result + alpha + alphaCount;
                    }
                    alpha = strData.charAt(i);
                    alphaCount =0;
                }
            }
            System.out.println(result);
        }

    }

    /*
    [문제] 주어진 문자열에서 "x"를 제외하세요. 단, 문자열의 맨 앞 또는 맨 뒤에 "x"가 나타나는 경우는 제외하지 않습니다.
    ex) stringX("xxHxix") => "xHix"
    stringX("abxxxcd") => "abcd"
    stringX("xabxxxcdx") => "xabcdx"
     */
    public static void removeX(String stringX){
        for(int i=0 ; i<stringX.length();i++){
            String result = "";
            Character x = 'x';
            if( !(stringX.charAt(i)==x && i!=0 && i!=stringX.length())){
                result += stringX.charAt(i);
            }
        }
    }


    /*
    다음과 같은 입출력을 가지는 프로그램을 구현하기
    입력 : [ A, B, C, D ]
    출력 : [ AB, AC, AD, BC, BD, CD, ABC, ABD, BCD, ABCD ]
     */

    private static void strings(String[] arr){
        ArrayList<String> results = new ArrayList<>();

        for(int i=0 ; i<arr.length-1;i++){
            for(int j=i+1 ; j<arr.length;j++) {
                results.add(arr[i] + arr[j]);
            }
        }
    }

    /*1. 21, 9, 4, 1, 5 (높은수부터 차례대로 정렬)*/
    private static void sort(int[] arr){
       for(int i=0;i<arr.length;i++){
           for(int j=i;j<arr.length;j++){
               if(arr[i]<arr[j]){
                   int temp = arr[j];
                   arr[j] = arr[i];
                   arr[i] = temp;
               }
           }
       }
       for(int n=0;n<arr.length;n++){
           System.out.println(arr[n]);
       }
    }

    public static void main (String[] args){
       // str("aaaa bcbd aaaabbabab");

        int[] arr = {21, 9, 4, 1, 5 };
        sort(arr);

    }
}

package beakJoon.greedy;
import java.util.*;

public class b_1439 {
    public static String str;
    public static int count0 = 0; // 전부 0으로 바꾸는 경우
    public static int count1 = 0; // 전부 1로 바꾸는 경우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        if(str.charAt(0)=='1'){
            //첫글자가 1이니깐 0으로 바꾸려면 +1
            count0++;
        }else{
            count1++;
        }

        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)!=str.charAt(i)){
                if(str.charAt(i)=='1'){
                    count0++;
                }else{
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}

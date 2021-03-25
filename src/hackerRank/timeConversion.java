package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class timeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String conversion = "";
        String time = s.substring(s.length()-2,s.length());
        String hour = s.substring(0,2);
        if(time.equals("AM")){
            if(Integer.parseInt(hour)==12){
                conversion = "00"+s.substring(2,s.length()-2);
            }
            else{
                conversion = s.substring(0,s.length()-2);
            }
        }else{
            if(Integer.parseInt(hour)==12){
                conversion = "12"+s.substring(2,s.length()-2);
            }
            else{
                conversion = (Integer.parseInt(hour)+12) + s.substring(2,s.length()-2);
            }
        }

        return  conversion;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.print(result);
    }
}

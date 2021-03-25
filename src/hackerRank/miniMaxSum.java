package hackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class miniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        long sum = 0l;

        for(int ar:arr){
            if(min>ar){
                min=ar;
            }

            if(max<ar){
                max=ar;
            }

            sum+=ar;
        }

        System.out.print((sum-max)+" "+(sum-min));


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class jumpingOnTheClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int result =0;
        int i=0;
        int end = c.length-1;
        while(i<end){
            if(i+1==end){
                result++;
                break;
            }
            if(c[i+2]==1){
                i=i+1;
            }else{
                i=i+2;
            }
            result++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

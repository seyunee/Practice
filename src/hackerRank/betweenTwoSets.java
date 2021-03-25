package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class betweenTwoSetsResult {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int result =0;
        int lcm = lcm(a); //최소공배수
        int gcd = gcd(b); //최대공약수

        int index = 1;
        int comp = 0;

        while (comp < gcd) {
            comp = lcm * index;
            if (gcd % comp == 0) {
                result ++;
            }
            index++;
        }

        return result;
    }

    private static int gcd(int a, int b) {//최대공약수
        while (b > 0){
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }

        return a;
    }

    private static int gcd(List<Integer> input){ //최대공약수
        int result = input.get(0);

        for(int i = 1; i < input.size(); i++) {
            result = gcd(result, input.get(i));
        }

        return result;
    }

    private static int lcm(int a, int b){ //최소공배수
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> input){ //최소공배수
        int result = input.get(0);

        for(int i = 1; i < input.size(); i++) {
            result = lcm(result, input.get(i));
        }

        return result;
    }
}

public class betweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = betweenTwoSetsResult.getTotalX(arr, brr);
        System.out.print(total);
        bufferedReader.close();
    }
}

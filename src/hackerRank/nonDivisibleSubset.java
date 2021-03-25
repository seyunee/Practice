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


class nonDivisibleSubsetResult {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] arr = new int[k];
        for (int i = 0; i < s.size(); i++) {
            arr[s.get(i) % k]++;
        }

        int result = 0;
        /** 위에서 3번을 구하는 것. */
        if (k % 2 == 0) {
            result = result + Math.min(arr[k/2], 1);
        }
        /** 위에서 2번을 구하는 것. */
        result = result + Math.min(arr[0], 1);
        /** 위에서 1번을 구하는 것.
         * * 여기서 주의할게 j != k - j 은 서로 같은 수이면 이미 위에서 구했기 때문. (짝수)
         * * 홀수일 경우 j <= k / 2 까지 접근해야 2개를 뽑을 수 있음.
         * * 또한, j <= k 인 이유는 1,2,3,4,... k-4, k-3, k-2, k-1 에서 2개씩 뽑기 때문. */
        for (int j = 1; j <= k / 2; j++) {
            if (j != k - j) {
                result += Math.max(arr[j], arr[k - j]);
            }
        }
        return result;
    }

}

public class nonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = nonDivisibleSubsetResult.nonDivisibleSubset(k, s);
        System.out.print(result);
        bufferedReader.close();
    }
}

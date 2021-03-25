package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class countingValleysResult {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int vally = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char p : path.toCharArray()){
            if(p == 'U') ++lvl;
            if(p == 'D') --lvl;

            // if we just came UP to sea level
            if(lvl == 0 && p == 'U')
                vally++;
        }
        return vally;
    }

}

public class countingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleysResult.countingValleys(steps, path);
        System.out.println(result);
        bufferedReader.close();
    }
}

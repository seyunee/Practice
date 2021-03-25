package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ifkakaoSolution {
    static int ifkakaoSolution(List<Integer> start_time,List<Integer> running_time) {
        int result = 0;
        HashMap<Integer,Integer> session = new HashMap<>();
        for(int i =0 ;i<start_time.size();i++){
            session.put(start_time.get(i), running_time.get(i));
        }

        return result;
    }
}

public class ifkakao {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> start_time = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int running = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> running_time = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ifkakaoSolution.ifkakaoSolution(start_time,running_time);
        System.out.println(result);

        bufferedReader.close();
    }
}